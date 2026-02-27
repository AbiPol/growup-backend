package com.growup.backend.infrastructure.mapper;

import com.growup.backend.domain.model.Notification;
import com.growup.backend.infrastructure.adapter.persistence.jpa.entity.NotificationJpaEntity;
import com.growup.backend.model.NotificationType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Mapper para convertir entre el modelo de dominio Notification y la entidad
 * JPA NotificationJpaEntity.
 */
@Component
@RequiredArgsConstructor
public class NotificationPersistenceMapper {

    private final UserPersistenceMapper userMapper;

    /** Convierte una entidad JPA → modelo de dominio */
    public Notification toDomain(NotificationJpaEntity entity) {
        if (entity == null)
            return null;

        Notification notification = new Notification();
        notification.setId(entity.getId());
        notification.setUser(userMapper.toDomain(entity.getUser()));
        notification.setTitle(entity.getTitle());
        notification.setMessage(entity.getMessage());
        notification.setType(mapType(entity.getType())); // String → Enum
        notification.setRead(entity.getRead());
        notification.setDate(entity.getDate());
        notification.setLink(toUri(entity.getLink()));
        notification.setVersion(entity.getVersion());
        return notification;
    }

    /**
     * Convierte un modelo de dominio → entidad JPA para guardar en base de datos
     */
    public NotificationJpaEntity toEntity(Notification domain) {
        if (domain == null)
            return null;

        NotificationJpaEntity entity = new NotificationJpaEntity();
        entity.setId(domain.getId());
        entity.setUser(userMapper.toEntity(domain.getUser()));
        entity.setTitle(domain.getTitle());
        entity.setMessage(domain.getMessage());
        entity.setType(mapType(domain.getType())); // Enum → String
        entity.setRead(domain.getRead());
        entity.setDate(domain.getDate());
        entity.setLink(toString(domain.getLink()));
        entity.setVersion(domain.getVersion() != null ? domain.getVersion() : 0L);
        return entity;
    }

    // --- Métodos URI y Enum ---

    private java.net.URI toUri(String value) {
        if (value == null || value.isBlank())
            return null;
        try {
            return java.net.URI.create(value);
        } catch (Exception e) {
            return null;
        }
    }

    private String toString(java.net.URI value) {
        return value != null ? value.toString() : null;
    }

    /** String guardado en DB → enum del dominio */
    private NotificationType mapType(String type) {
        if (type == null)
            return null;
        try {
            return NotificationType.fromValue(type);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    /** Enum del dominio → String para guardar en DB */
    private String mapType(NotificationType type) {
        return type != null ? type.getValue() : null;
    }
}
