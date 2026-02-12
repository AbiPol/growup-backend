package com.growup.backend.api;

import com.growup.backend.model.Activity;
import com.growup.backend.model.AnalyticsSummary;
import com.growup.backend.model.CourseItem;
import com.growup.backend.model.CoursePerformance;
import com.growup.backend.model.DashboardStats;
import com.growup.backend.model.RevenueData;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

/**
 * A delegate to be called by the {@link ProfesorApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-12T11:59:11.015804600Z[Atlantic/Canary]")
public interface ProfesorApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /teacher/activities : Obtener actividades recientes
     * Obtener lista de actividades recientes en los cursos del profesor
     *
     * @param limit Número máximo de actividades a retornar (optional, default to 10)
     * @return Actividades recientes (status code 200)
     * @see ProfesorApi#teacherActivitiesGet
     */
    default ResponseEntity<List<Activity>> teacherActivitiesGet(Integer limit) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"action\" : \"action\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"time\" : \"2000-01-23T04:56:07.000+00:00\", \"user\" : \"user\", \"target\" : \"target\" }, { \"action\" : \"action\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"time\" : \"2000-01-23T04:56:07.000+00:00\", \"user\" : \"user\", \"target\" : \"target\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /teacher/analytics/courses : Obtener rendimiento de cursos
     * Obtener análisis de rendimiento de los cursos del profesor
     *
     * @return Rendimiento de cursos (status code 200)
     * @see ProfesorApi#teacherAnalyticsCoursesGet
     */
    default ResponseEntity<List<CoursePerformance>> teacherAnalyticsCoursesGet() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"courseName\" : \"courseName\", \"revenue\" : 6.027456183070403, \"rating\" : 1.4658129805029452, \"students\" : 0, \"courseId\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" }, { \"courseName\" : \"courseName\", \"revenue\" : 6.027456183070403, \"rating\" : 1.4658129805029452, \"students\" : 0, \"courseId\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /teacher/analytics/revenue : Obtener análisis de ingresos
     * Obtener datos de ingresos mensuales del profesor
     *
     * @param months Número de meses a consultar (optional, default to 12)
     * @return Datos de ingresos (status code 200)
     * @see ProfesorApi#teacherAnalyticsRevenueGet
     */
    default ResponseEntity<List<RevenueData>> teacherAnalyticsRevenueGet(Integer months) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"revenue\" : 0.8008281904610115, \"month\" : \"month\", \"enrollments\" : 6 }, { \"revenue\" : 0.8008281904610115, \"month\" : \"month\", \"enrollments\" : 6 } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /teacher/analytics/summary : Obtener resumen de analíticas
     * Obtener resumen global de analíticas del profesor
     *
     * @return Resumen de analíticas (status code 200)
     * @see ProfesorApi#teacherAnalyticsSummaryGet
     */
    default ResponseEntity<AnalyticsSummary> teacherAnalyticsSummaryGet() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"averageRating\" : 1.4658129805029452, \"totalStudents\" : 6, \"totalRevenue\" : 0.8008281904610115, \"activeCourses\" : 5 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /teacher/courses : Obtener mis cursos
     * Obtener lista de cursos del profesor autenticado con estadísticas
     *
     * @return Lista de cursos del profesor (status code 200)
     * @see ProfesorApi#teacherCoursesGet
     */
    default ResponseEntity<List<CourseItem>> teacherCoursesGet() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ null, null ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /teacher/dashboard/stats : Obtener estadísticas del panel
     * Obtener resumen de estadísticas para el panel del profesor
     *
     * @return Estadísticas del panel (status code 200)
     * @see ProfesorApi#teacherDashboardStatsGet
     */
    default ResponseEntity<DashboardStats> teacherDashboardStatsGet() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"monthlyRevenue\" : 5.962133916683182, \"averageRating\" : 1.4658129805029452, \"totalStudents\" : 0, \"activeCourses\" : 6, \"studentsGrowth\" : 5.637376656633329, \"revenueGrowth\" : 2.3021358869347655 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
