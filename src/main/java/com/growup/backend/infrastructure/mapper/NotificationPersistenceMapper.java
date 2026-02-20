package com.growup.backend.infrastructure.mapper;

import com.growup.backend.domain.model.Notification;
import com.growup.backend.infrastructure.adapter.persistence.jpa.entity.NotificationJpaEntity;
import org.mapstruct.Mapper;

/**
 * Mapper para convertir entre el modelo de dominio Notification y la entidad
 * JPA NotificationJpaEntity.
 */
@Mapper(componentModel = "spring", uses = { UserPersistenceMapper.class })
public interface NotificationPersistenceMapper {

    @org.mapstruct.Mapping(target = "type", expression = "java(mapType(entity.getType()))")
    Notification toDomain(NotificationJpaEntity entity);

    @org.mapstruct.Mapping(target = "type", expression = "java(mapType(domain.getType()))")
    NotificationJpaEntity toEntity(Notification domain);

    default java.net.URI map(String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        try {
            return java.net.URI.create(value);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    default String map(java.net.URI value) {
        return value != null ? value.toString() : null;
    }

    default String mapType(com.growup.backend.model.NotificationType type) {
        return type != null ? type.getValue() : null;
    }

    default com.growup.backend.model.NotificationType mapType(String type) {
        if (type == null)
            return null;
        try {
            return com.growup.backend.model.NotificationType.fromValue(type);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
