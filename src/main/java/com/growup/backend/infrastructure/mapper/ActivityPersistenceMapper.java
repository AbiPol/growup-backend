package com.growup.backend.infrastructure.mapper;

import com.growup.backend.domain.model.Activity;
import com.growup.backend.infrastructure.adapter.persistence.jpa.entity.ActivityJpaEntity;
import com.growup.backend.model.ActivityType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Mapper para convertir entre el modelo de dominio Activity y la entidad JPA
 * ActivityJpaEntity.
 */
@Component
@RequiredArgsConstructor
public class ActivityPersistenceMapper {

    private final UserPersistenceMapper userMapper;

    /** Convierte una entidad JPA → modelo de dominio */
    public Activity toDomain(ActivityJpaEntity entity) {
        if (entity == null)
            return null;

        Activity activity = new Activity();
        activity.setId(entity.getId());
        activity.setUser(userMapper.toDomain(entity.getUser()));
        activity.setType(mapType(entity.getType())); // String → Enum
        activity.setAction(entity.getAction());
        activity.setTarget(entity.getTarget());
        activity.setTime(entity.getTime());
        activity.setVersion(entity.getVersion());
        return activity;
    }

    /**
     * Convierte un modelo de dominio → entidad JPA para guardar en base de datos
     */
    public ActivityJpaEntity toEntity(Activity domain) {
        if (domain == null)
            return null;

        ActivityJpaEntity entity = new ActivityJpaEntity();
        entity.setId(domain.getId());
        entity.setUser(userMapper.toEntity(domain.getUser()));
        entity.setType(mapType(domain.getType())); // Enum → String
        entity.setAction(domain.getAction());
        entity.setTarget(domain.getTarget());
        entity.setTime(domain.getTime());
        entity.setVersion(domain.getVersion() != null ? domain.getVersion() : 0L);
        return entity;
    }

    // --- Conversión del enum ActivityType ---

    /** String guardado en DB → enum del dominio */
    private ActivityType mapType(String type) {
        if (type == null)
            return null;
        try {
            return ActivityType.fromValue(type);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    /** Enum del dominio → String para guardar en DB */
    private String mapType(ActivityType type) {
        return type != null ? type.getValue() : null;
    }
}
