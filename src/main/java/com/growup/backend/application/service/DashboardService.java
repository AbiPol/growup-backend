package com.growup.backend.application.service;

import com.growup.backend.domain.model.Course;
import com.growup.backend.domain.port.in.DashboardInPort;
import com.growup.backend.domain.port.out.CoursePersistencePort;
import com.growup.backend.domain.port.out.EnrollmentPersistencePort;
import com.growup.backend.domain.port.out.ReviewPersistencePort;
import com.growup.backend.model.AnalyticsSummary;
import com.growup.backend.model.CoursePerformance;
import com.growup.backend.model.DashboardStats;
import com.growup.backend.model.RevenueData;
import com.growup.backend.model.CourseStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.OffsetDateTime;
import java.time.format.TextStyle;
import java.util.*;
import java.util.stream.Collectors; // I will keep it for now as I might use it or just wait for linter to be happy if I remove it correctly
// Actually I will remove it properly.

/**
 * Servicio de Aplicación para el Dashboard.
 * Agrega datos de cursos e inscripciones para calcular estadísticas.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class DashboardService implements DashboardInPort {

        private final CoursePersistencePort coursePersistencePort;
        private final EnrollmentPersistencePort enrollmentPersistencePort;
        private final ReviewPersistencePort reviewPersistencePort;

        @Override
        public DashboardStats getDashboardStats(UUID instructorId) {
                log.info("GrowUp-Log: DashboardService - Calculando estadísticas para instructor: {}", instructorId);

                List<Course> courses = coursePersistencePort.findByInstructorId(instructorId);

                // 1. Cursos Activos (Publicados)
                long activeCoursesCount = courses.stream()
                                .filter(c -> c.getPublicationStatus() != null
                                                && "Publicado".equals(c.getPublicationStatus()))
                                .count();

                // 2. Total Alumnos (Suma de inscripciones de todos sus cursos)
                int totalStudents = courses.stream()
                                .mapToInt(c -> c.getEnrolledCount() != null ? c.getEnrolledCount() : 0)
                                .sum();

                // 3. Ingresos Mensuales (Suma de precios de inscripciones este mes)
                OffsetDateTime startOfMonth = OffsetDateTime.now().withDayOfMonth(1).withHour(0).withMinute(0)
                                .withSecond(0)
                                .withNano(0);
                var monthlyEnrollments = enrollmentPersistencePort.findByInstructorIdAndCreatedAtAfter(instructorId,
                                startOfMonth);

                BigDecimal monthlyRevenue = monthlyEnrollments.stream()
                                .map(e -> e.getCourse() != null && e.getCourse().getPrice() != null
                                                ? BigDecimal.valueOf(e.getCourse().getPrice())
                                                : BigDecimal.ZERO)
                                .reduce(BigDecimal.ZERO, BigDecimal::add);

                // 4. Valoración Media real desde el repositorio de Reviews
                Double avgRating = reviewPersistencePort.getAverageRatingByInstructor(instructorId);
                BigDecimal averageRating = avgRating != null
                                ? BigDecimal.valueOf(avgRating).setScale(2, RoundingMode.HALF_UP)
                                : BigDecimal.ZERO;

                // 5. Crecimientos (Placeholder/Cálculo simple)
                // Por ahora devolvemos valores fijos o calculados si tenemos histórico
                BigDecimal studentsGrowth = BigDecimal.valueOf(0.0);
                BigDecimal revenueGrowth = BigDecimal.valueOf(0.0);

                return new DashboardStats()
                                .totalStudents(totalStudents)
                                .activeCourses((int) activeCoursesCount)
                                .averageRating(averageRating)
                                .monthlyRevenue(monthlyRevenue)
                                .studentsGrowth(studentsGrowth)
                                .revenueGrowth(revenueGrowth);
        }

        @Override
        public AnalyticsSummary getAnalyticsSummary(UUID instructorId) {
                log.info("GrowUp-Log: DashboardService - Calculando resumen de analíticas para instructor: {}",
                                instructorId);

                List<Course> courses = coursePersistencePort.findByInstructorId(instructorId);

                // 1. Cursos Activos (Publicados)
                long activeCoursesCount = courses.stream()
                                .filter(c -> c.getPublicationStatus() != null
                                                && "Publicado".equals(c.getPublicationStatus()))
                                .count();

                // 2. Total Alumnos
                int totalStudents = courses.stream()
                                .mapToInt(c -> c.getEnrolledCount() != null ? c.getEnrolledCount() : 0)
                                .sum();

                // 3. Ingresos Totales (Suma de todas las inscripciones históricas)
                var allEnrollments = enrollmentPersistencePort.findByInstructorId(instructorId);
                BigDecimal totalRevenue = allEnrollments.stream()
                                .map(e -> e.getCourse() != null && e.getCourse().getPrice() != null
                                                ? BigDecimal.valueOf(e.getCourse().getPrice())
                                                : BigDecimal.ZERO)
                                .reduce(BigDecimal.ZERO, BigDecimal::add);

                // 4. Valoración Media
                Double avgRating = reviewPersistencePort.getAverageRatingByInstructor(instructorId);
                BigDecimal averageRating = avgRating != null
                                ? BigDecimal.valueOf(avgRating).setScale(2, RoundingMode.HALF_UP)
                                : BigDecimal.ZERO;

                return new AnalyticsSummary()
                                .activeCourses((int) activeCoursesCount)
                                .totalStudents(totalStudents)
                                .totalRevenue(totalRevenue)
                                .averageRating(averageRating);
        }

        @Override
        public List<RevenueData> getRevenueTrends(UUID instructorId, Integer months) {
                int monthsToFetch = months != null ? months : 12;
                log.info("GrowUp-Log: DashboardService - Calculando tendencias de ingresos ({} meses) para instructor: {}",
                                monthsToFetch, instructorId);

                OffsetDateTime startPeriod = OffsetDateTime.now()
                                .minusMonths(monthsToFetch - 1)
                                .withDayOfMonth(1)
                                .withHour(0).withMinute(0).withSecond(0).withNano(0);

                var enrollments = enrollmentPersistencePort.findByInstructorIdAndCreatedAtAfter(instructorId,
                                startPeriod);

                // Mapa para agrupar por mes (Clave: "yyyy-MM")
                Map<String, RevenueData> statsMap = new LinkedHashMap<>();

                // Inicializar todos los meses del rango para que no falten huecos
                for (int i = 0; i < monthsToFetch; i++) {
                        OffsetDateTime monthDate = startPeriod.plusMonths(i);
                        String key = monthDate.getYear() + "-" + String.format("%02d", monthDate.getMonthValue());
                        String label = monthDate.getMonth().getDisplayName(TextStyle.SHORT, new Locale("es", "ES"));
                        statsMap.put(key, new RevenueData()
                                        .month(label)
                                        .revenue(BigDecimal.ZERO)
                                        .enrollments(0));
                }

                // Llenar datos con las inscripciones reales
                enrollments.forEach(e -> {
                        if (e.getCreatedAt() != null) {
                                String key = e.getCreatedAt().getYear() + "-"
                                                + String.format("%02d", e.getCreatedAt().getMonthValue());
                                RevenueData data = statsMap.get(key);
                                if (data != null) {
                                        BigDecimal price = (e.getCourse() != null && e.getCourse().getPrice() != null)
                                                        ? BigDecimal.valueOf(e.getCourse().getPrice())
                                                        : BigDecimal.ZERO;
                                        data.setRevenue(data.getRevenue().add(price));
                                        data.setEnrollments(data.getEnrollments() + 1);
                                }
                        }
                });

                return new ArrayList<>(statsMap.values());
        }

        @Override
        public List<CoursePerformance> getCoursePerformance(UUID instructorId) {
                log.info("GrowUp-Log: DashboardService - Calculando rendimiento por curso para instructor: {}",
                                instructorId);

                List<Course> courses = coursePersistencePort.findByInstructorId(instructorId);

                return courses.stream().map(c -> {
                        // 1. Número de alumnos
                        int enrolledCount = c.getEnrolledCount() != null ? c.getEnrolledCount() : 0;

                        // 2. Ingresos del curso (Suma de precios de todas sus inscripciones reales)
                        // Para simplificar ahora usamos enrolledCount * price,
                        // pero lo ideal es buscar inscripciones reales si el precio varió.
                        // Mantendremos la coherencia con getAnalyticsSummary
                        BigDecimal courseRevenue = BigDecimal.valueOf(enrolledCount)
                                        .multiply(c.getPrice() != null ? BigDecimal.valueOf(c.getPrice())
                                                        : BigDecimal.ZERO);

                        // 3. Valoración media del curso
                        Double avgRating = reviewPersistencePort.getAverageRatingByCourseId(c.getId());
                        BigDecimal rating = avgRating != null
                                        ? BigDecimal.valueOf(avgRating).setScale(2, RoundingMode.HALF_UP)
                                        : BigDecimal.ZERO;

                        return new CoursePerformance()
                                        .courseId(c.getId())
                                        .courseName(c.getName())
                                        .students(enrolledCount)
                                        .revenue(courseRevenue)
                                        .rating(rating)
                                        .status(CourseStatus.fromValue(c.getPublicationStatus()));
                }).collect(Collectors.toList());
        }
}
