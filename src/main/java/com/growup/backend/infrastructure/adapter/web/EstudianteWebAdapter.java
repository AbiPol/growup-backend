package com.growup.backend.infrastructure.adapter.web;

import com.growup.backend.api.EstudianteApiDelegate;
import com.growup.backend.domain.port.in.EnrollmentInPort;
import com.growup.backend.domain.port.in.NotificationInPort;
import com.growup.backend.infrastructure.adapter.web.mapper.EnrollmentWebMapper;
import com.growup.backend.infrastructure.adapter.web.mapper.NotificationWebMapper;
import com.growup.backend.model.EnrolledCourse;
import com.growup.backend.model.Notification;
import com.growup.backend.model.StudentStats;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Adaptador Web para Estudiante.
 * Implementa EstudianteApiDelegate delegando en los puertos de entrada.
 */
@Component
@RequiredArgsConstructor
public class EstudianteWebAdapter implements EstudianteApiDelegate {

    private final EnrollmentInPort enrollmentInPort;
    private final NotificationInPort notificationInPort;
    private final EnrollmentWebMapper enrollmentMapper;
    private final NotificationWebMapper notificationMapper;

    // TODO: En producción, obtener del SecurityContext
    private static final UUID MOCK_STUDENT_ID = UUID.fromString("00000000-0000-0000-0000-000000000001");

    @Override
    public ResponseEntity<EnrolledCourse> coursesIdEnrollPost(UUID id) {
        var enrollment = enrollmentInPort.enrollStudent(MOCK_STUDENT_ID, id);
        return ResponseEntity.ok(enrollmentMapper.toDto(enrollment));
    }

    @Override
    public ResponseEntity<List<EnrolledCourse>> studentEnrollmentsGet() {
        var enrollments = enrollmentInPort.getStudentEnrollments(MOCK_STUDENT_ID);
        return ResponseEntity.ok(enrollments.stream()
                .map(enrollmentMapper::toDto)
                .collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<List<Notification>> studentNotificationsGet(Boolean unreadOnly) {
        var notifications = notificationInPort.getNotificationsByUser(MOCK_STUDENT_ID);
        if (Boolean.TRUE.equals(unreadOnly)) {
            // Filtrar en memoria para mock
            notifications = notifications.stream().filter(n -> !n.getRead()).collect(Collectors.toList());
        }
        return ResponseEntity.ok(notifications.stream()
                .map(notificationMapper::toDto)
                .collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<Void> studentNotificationsIdReadPut(UUID id) {
        notificationInPort.markAsRead(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<StudentStats> studentStatsGet() {
        var stats = enrollmentInPort.getStudentStats(MOCK_STUDENT_ID);
        return ResponseEntity.ok(enrollmentMapper.toStatsDto(stats));
    }
}
