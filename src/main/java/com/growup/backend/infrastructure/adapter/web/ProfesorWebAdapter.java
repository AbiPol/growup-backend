package com.growup.backend.infrastructure.adapter.web;

import com.growup.backend.api.ProfesorApiDelegate;
import com.growup.backend.domain.port.in.*;
import com.growup.backend.infrastructure.adapter.web.mapper.ActivityWebMapper;
import com.growup.backend.infrastructure.adapter.web.mapper.CourseWebMapper;
import com.growup.backend.infrastructure.adapter.web.mapper.ReviewWebMapper;
import com.growup.backend.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

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
    private final UserInPort userInPort;
    private final DashboardInPort dashboardInPort;
    private final ReviewInPort reviewInPort;
    private final CourseWebMapper courseMapper;
    private final ActivityWebMapper activityMapper;
    private final ReviewWebMapper reviewMapper;

    private UUID getCurrentInstructorId() {
        String currentEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        return userInPort.getUserByEmail(currentEmail).getId();
    }

    @Override
    public ResponseEntity<List<Activity>> teacherActivitiesGet(Integer limit) {
        var activities = activityInPort.getActivitiesByUser(getCurrentInstructorId());
        var list = activities.stream()
                .limit(limit != null ? limit : 10)
                .map(activityMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @Override
    public ResponseEntity<List<CoursePerformance>> teacherAnalyticsCoursesGet() {
        var instructorId = getCurrentInstructorId();
        return ResponseEntity.ok(dashboardInPort.getCoursePerformance(instructorId));
    }

    @Override
    public ResponseEntity<List<RevenueData>> teacherAnalyticsRevenueGet(Integer months) {
        var instructorId = getCurrentInstructorId();
        return ResponseEntity.ok(dashboardInPort.getRevenueTrends(instructorId, months));
    }

    @Override
    public ResponseEntity<AnalyticsSummary> teacherAnalyticsSummaryGet() {
        var instructorId = getCurrentInstructorId();
        return ResponseEntity.ok(dashboardInPort.getAnalyticsSummary(instructorId));
    }

    @Override
    public ResponseEntity<List<CourseItem>> teacherCoursesGet() {
        var courses = courseInPort.getCoursesByInstructor(getCurrentInstructorId());
        return ResponseEntity.ok(courses.stream()
                .map(courseMapper::toCourseItemDto)
                .collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<DashboardStats> teacherDashboardStatsGet() {
        var instructorId = getCurrentInstructorId();
        return ResponseEntity.ok(dashboardInPort.getDashboardStats(instructorId));
    }

    @Override
    public ResponseEntity<List<Review>> teacherReviewsGet() {
        var reviews = reviewInPort.getReviewsByInstructor(getCurrentInstructorId());
        return ResponseEntity.ok(reviews.stream()
                .map(reviewMapper::toDto)
                .collect(Collectors.toList()));
    }
}
