package com.growup.backend.infrastructure.adapter.web.mapper;

import com.growup.backend.domain.model.Activity;
import com.growup.backend.model.ActivityType;
import org.springframework.stereotype.Component;

/**
 * Mapper para convertir entre el modelo de dominio Activity y el DTO de
 * OpenAPI.
 */
@Component
public class ActivityWebMapper {

    /** Dominio Activity → DTO Activity (para enviar al frontend) */
    public com.growup.backend.model.Activity toDto(Activity domain) {
        if (domain == null)
            return null;

        com.growup.backend.model.Activity dto = new com.growup.backend.model.Activity();
        dto.setId(domain.getId());
        dto.setUser(domain.getUser() != null ? domain.getUser().getName() : null); // Solo el nombre del usuario
        dto.setType(mapType(domain.getType())); // String → Enum
        dto.setAction(domain.getAction());
        dto.setTarget(domain.getTarget());
        dto.setTime(domain.getTime());
        return dto;
    }

    /** DTO Activity → Dominio Activity (al recibir del frontend) */
    public Activity toDomain(com.growup.backend.model.Activity dto) {
        if (dto == null)
            return null;

        Activity domain = new Activity();
        domain.setId(dto.getId());
        domain.setType(mapType(dto.getType())); // Enum → String
        domain.setAction(dto.getAction());
        domain.setTarget(dto.getTarget());
        domain.setTime(dto.getTime());
        // "user" se ignora: es solo un nombre en el DTO, no un objeto User completo
        return domain;
    }

    // ── Conversión del enum ActivityType ────────────────────────────────────

    /** String del dominio → Enum ActivityType del DTO */
    private ActivityType mapType(String type) {
        if (type == null)
            return null;
        try {
            return ActivityType.fromValue(type);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    /** Enum ActivityType del DTO → String del dominio */
    private String mapType(ActivityType type) {
        return type != null ? type.getValue() : null;
    }
}
