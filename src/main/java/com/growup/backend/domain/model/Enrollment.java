package com.growup.backend.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * Modelo de dominio puro para la Inscripción.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Enrollment {
    private UUID id;
    private User student;
    private Course course;
    private Integer progress;
    private OffsetDateTime lastAccessDate;
    private String enrollmentStatus;
    private UUID nextLessonId;
    private Long version;
}
