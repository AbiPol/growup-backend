package com.growup.backend.infrastructure.adapter.web.mapper;

import com.growup.backend.domain.model.Notification;
import com.growup.backend.model.NotificationType;
import org.springframework.stereotype.Component;

/**
 * Mapper para convertir entre el modelo de dominio Notification y el DTO de
 * OpenAPI.
 */
@Component
public class NotificationWebMapper {

    /** Dominio Notification → DTO Notification (para enviar al frontend) */
    public com.growup.backend.model.Notification toDto(Notification domain) {
        if (domain == null)
            return null;

        com.growup.backend.model.Notification dto = new com.growup.backend.model.Notification();
        dto.setId(domain.getId());
        dto.setUserId(domain.getUser() != null ? domain.getUser().getId() : null); // Solo el ID
        dto.setTitle(domain.getTitle());
        dto.setMessage(domain.getMessage());
        dto.setType(mapType(domain.getType())); // String → Enum
        dto.setRead(domain.getRead());
        dto.setDate(domain.getDate());
        dto.setLink(domain.getLink());
        return dto;
    }

    /** DTO Notification → Dominio Notification (al recibir del frontend) */
    public Notification toDomain(com.growup.backend.model.Notification dto) {
        if (dto == null)
            return null;

        Notification domain = new Notification();
        domain.setId(dto.getId());
        domain.setTitle(dto.getTitle());
        domain.setMessage(dto.getMessage());
        domain.setType(mapType(dto.getType())); // Enum → String
        domain.setRead(dto.getRead());
        domain.setDate(dto.getDate());
        domain.setLink(dto.getLink());
        // "user" se ignora: el servicio lo carga por userId si fuera necesario
        return domain;
    }

    // ── Conversión del enum NotificationType ────────────────────────────────

    /** String del dominio → Enum NotificationType del DTO */
    private NotificationType mapType(String type) {
        if (type == null)
            return null;
        try {
            return NotificationType.fromValue(type);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    /** Enum NotificationType del DTO → String del dominio */
    private String mapType(NotificationType type) {
        return type != null ? type.getValue() : null;
    }
}
