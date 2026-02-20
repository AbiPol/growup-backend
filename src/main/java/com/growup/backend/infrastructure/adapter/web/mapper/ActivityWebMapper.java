package com.growup.backend.infrastructure.adapter.web.mapper;

import com.growup.backend.domain.model.Activity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper para convertir entre el modelo de dominio Activity y el DTO de
 * OpenAPI.
 */
@Mapper(componentModel = "spring")
public interface ActivityWebMapper {

    @Mapping(target = "user", source = "user.name")
    @Mapping(target = "type", expression = "java(mapType(domain.getType()))")
    com.growup.backend.model.Activity toDto(Activity domain);

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "type", expression = "java(mapType(dto.getType()))")
    Activity toDomain(com.growup.backend.model.Activity dto);

    default com.growup.backend.model.ActivityType mapType(String type) {
        if (type == null)
            return null;
        try {
            return com.growup.backend.model.ActivityType.fromValue(type);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    default String mapType(com.growup.backend.model.ActivityType type) {
        return type != null ? type.getValue() : null;
    }
}
