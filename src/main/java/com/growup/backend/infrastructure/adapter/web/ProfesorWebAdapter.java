package com.growup.backend.infrastructure.adapter.web;

import com.growup.backend.api.ProfesorApiDelegate;
import com.growup.backend.domain.port.in.ActivityInPort;
import com.growup.backend.domain.port.in.CourseInPort;
import com.growup.backend.infrastructure.adapter.web.mapper.ActivityWebMapper;
import com.growup.backend.infrastructure.adapter.web.mapper.CourseWebMapper;
import com.growup.backend.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Adaptador Web para Profesor.
 * Implementa ProfesorApiDelegate delegando en los puertos de entrada.
 */
@Component
@RequiredArgsConstructor
public class ProfesorWebAdapter implements ProfesorApiDelegate {

    private final CourseInPort courseInPort;
    private final ActivityInPort activityInPort;
    private final CourseWebMapper courseMapper;
    private final ActivityWebMapper activityMapper;

    // TODO: En producción, obtener del SecurityContext
    private static final UUID MOCK_PROFESOR_ID = UUID.fromString("00000000-0000-0000-0000-000000000002");

    @Override
    public ResponseEntity<List<Activity>> teacherActivitiesGet(Integer limit) {
        var activities = activityInPort.getActivitiesByUser(MOCK_PROFESOR_ID);
        var list = activities.stream()
                .limit(limit != null ? limit : 10)
                .map(activityMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @Override
    public ResponseEntity<List<CoursePerformance>> teacherAnalyticsCoursesGet() {
        // TODO: Implementar analíticas reales en el puerto de entrada
        return ResponseEntity.ok(Collections.emptyList());
    }

    @Override
    public ResponseEntity<List<RevenueData>> teacherAnalyticsRevenueGet(Integer months) {
        // TODO: Implementar analíticas reales
        return ResponseEntity.ok(Collections.emptyList());
    }

    @Override
    public ResponseEntity<AnalyticsSummary> teacherAnalyticsSummaryGet() {
        // TODO: Implementar analíticas reales
        return ResponseEntity.ok(new AnalyticsSummary());
    }

    @Override
    public ResponseEntity<List<CourseItem>> teacherCoursesGet() {
        var courses = courseInPort.getCoursesByInstructor(MOCK_PROFESOR_ID);
        return ResponseEntity.ok(courses.stream()
                .map(courseMapper::toCourseItemDto)
                .collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<DashboardStats> teacherDashboardStatsGet() {
        // TODO: Implementar estadísticas reales
        return ResponseEntity.ok(new DashboardStats());
    }
}
