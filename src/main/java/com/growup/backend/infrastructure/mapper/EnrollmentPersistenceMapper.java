package com.growup.backend.infrastructure.mapper;

import com.growup.backend.domain.model.Enrollment;
import com.growup.backend.infrastructure.adapter.persistence.jpa.entity.EnrollmentJpaEntity;
import com.growup.backend.model.EnrollmentStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Mapper para convertir entre el modelo de dominio Enrollment y la entidad JPA
 * EnrollmentJpaEntity.
 */
@Component
@RequiredArgsConstructor
public class EnrollmentPersistenceMapper {

    private final UserPersistenceMapper userMapper;
    private final CoursePersistenceMapper courseMapper;

    /** Convierte una entidad JPA → modelo de dominio */
    public Enrollment toDomain(EnrollmentJpaEntity entity) {
        if (entity == null)
            return null;

        Enrollment enrollment = new Enrollment();
        enrollment.setId(entity.getId());
        enrollment.setStudent(userMapper.toDomain(entity.getUser())); // "user" en JPA es "student" en dominio
        enrollment.setCourse(courseMapper.toDomain(entity.getCourse()));
        enrollment.setProgress(entity.getProgress());
        enrollment.setLastAccessDate(entity.getLastAccessDate());
        enrollment.setEnrollmentStatus(mapStatus(entity.getEnrollmentStatus())); // Enum → String
        enrollment.setNextLessonId(entity.getNextLessonId());
        enrollment.setCreatedAt(entity.getCreatedAt());
        enrollment.setVersion(entity.getVersion());
        return enrollment;
    }

    /**
     * Convierte un modelo de dominio → entidad JPA para guardar en base de datos
     */
    public EnrollmentJpaEntity toEntity(Enrollment enrollment) {
        if (enrollment == null)
            return null;

        EnrollmentJpaEntity entity = new EnrollmentJpaEntity();
        entity.setId(enrollment.getId());
        entity.setUser(userMapper.toEntity(enrollment.getStudent())); // "student" en dominio es "user" en JPA
        entity.setCourse(courseMapper.toEntity(enrollment.getCourse()));
        entity.setProgress(enrollment.getProgress());
        entity.setLastAccessDate(enrollment.getLastAccessDate());
        entity.setEnrollmentStatus(mapStatus(enrollment.getEnrollmentStatus())); // String → Enum
        entity.setNextLessonId(enrollment.getNextLessonId());
        entity.setCreatedAt(enrollment.getCreatedAt());
        entity.setVersion(enrollment.getVersion() != null ? enrollment.getVersion() : 0L);
        return entity;
    }

    // --- Conversión del enum EnrollmentStatus ---

    /** Enum EnrollmentStatus → String para guardar en DB */
    private String mapStatus(EnrollmentStatus status) {
        return status != null ? status.getValue() : null;
    }

    /** String de la DB → Enum EnrollmentStatus */
    private EnrollmentStatus mapStatus(String status) {
        if (status == null)
            return null;
        try {
            return EnrollmentStatus.fromValue(status);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
