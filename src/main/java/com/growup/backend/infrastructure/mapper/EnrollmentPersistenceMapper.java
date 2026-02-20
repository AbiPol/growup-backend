package com.growup.backend.infrastructure.mapper;

import com.growup.backend.domain.model.Enrollment;
import com.growup.backend.infrastructure.adapter.persistence.jpa.entity.EnrollmentJpaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper para convertir entre el modelo de dominio Enrollment y la entidad JPA
 * EnrollmentJpaEntity.
 */
@Mapper(componentModel = "spring", uses = { UserPersistenceMapper.class, CoursePersistenceMapper.class })
public interface EnrollmentPersistenceMapper {

    @Mapping(target = "enrollmentStatus", expression = "java(mapStatus(entity.getEnrollmentStatus()))")
    Enrollment toDomain(EnrollmentJpaEntity entity);

    // @Mapping(target = "version", ignore = true)
    @Mapping(target = "enrollmentStatus", expression = "java(mapStatus(domain.getEnrollmentStatus()))")
    EnrollmentJpaEntity toEntity(Enrollment domain);

    default String mapStatus(com.growup.backend.model.EnrollmentStatus status) {
        return status != null ? status.getValue() : null;
    }

    default com.growup.backend.model.EnrollmentStatus mapStatus(String status) {
        if (status == null)
            return null;
        try {
            return com.growup.backend.model.EnrollmentStatus.fromValue(status);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
