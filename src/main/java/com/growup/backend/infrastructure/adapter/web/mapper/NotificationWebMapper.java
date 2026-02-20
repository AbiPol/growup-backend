package com.growup.backend.infrastructure.adapter.web.mapper;

import com.growup.backend.domain.model.Notification;
import org.mapstruct.Mapper;

/**
 * Mapper para convertir entre el modelo de dominio Notification y el DTO de
 * OpenAPI.
 */
@Mapper(componentModel = "spring")
public interface NotificationWebMapper {

    @org.mapstruct.Mapping(target = "userId", source = "user.id")
    @org.mapstruct.Mapping(target = "type", expression = "java(mapType(domain.getType()))")
    com.growup.backend.model.Notification toDto(Notification domain);

    @org.mapstruct.Mapping(target = "user.id", source = "userId")
    @org.mapstruct.Mapping(target = "type", expression = "java(mapType(dto.getType()))")
    @org.mapstruct.Mapping(target = "user", ignore = true) // Ignored complex user object, handled by service if needed
    Notification toDomain(com.growup.backend.model.Notification dto);

    default com.growup.backend.model.NotificationType mapType(String type) {
        if (type == null)
            return null;
        try {
            return com.growup.backend.model.NotificationType.fromValue(type);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    default String mapType(com.growup.backend.model.NotificationType type) {
        return type != null ? type.getValue() : null;
    }
}
