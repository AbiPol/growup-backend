package com.growup.backend.infrastructure.mapper;

import com.growup.backend.domain.model.Activity;
import com.growup.backend.infrastructure.adapter.persistence.jpa.entity.ActivityJpaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper para convertir entre el modelo de dominio Activity y la entidad JPA
 * ActivityJpaEntity.
 */
@Mapper(componentModel = "spring", uses = { UserPersistenceMapper.class })
public interface ActivityPersistenceMapper {

    @Mapping(target = "type", expression = "java(mapType(entity.getType()))")
    Activity toDomain(ActivityJpaEntity entity);

    @Mapping(target = "type", expression = "java(mapType(domain.getType()))")
    ActivityJpaEntity toEntity(Activity domain);

    default String mapType(com.growup.backend.model.ActivityType type) {
        return type != null ? type.getValue() : null;
    }

    default com.growup.backend.model.ActivityType mapType(String type) {
        if (type == null)
            return null;
        try {
            return com.growup.backend.model.ActivityType.fromValue(type);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
