package com.growup.backend.infrastructure.adapter.web.mapper;

import com.growup.backend.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.net.URI;

/**
 * Mapper para convertir entre el modelo de dominio User y el DTO de OpenAPI.
 */
@Mapper(componentModel = "spring")
public interface UserWebMapper {

    @Mapping(target = "avatarUrl", expression = "java(toUri(domain.getAvatar()))")
    com.growup.backend.model.Instructor toInstructorDto(User domain);

    @Mapping(target = "avatar", expression = "java(toUri(domain.getAvatar()))")
    com.growup.backend.model.User toDto(User domain);

    @Mapping(target = "avatar", expression = "java(toString(dto.getAvatar()))")
    User toDomain(com.growup.backend.model.User dto);

    @Mapping(target = "email", ignore = true)
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "isActive", ignore = true)
    @Mapping(target = "joinDate", ignore = true)
    // @Mapping(target = "version", ignore = true)
    @Mapping(target = "avatar", source = "avatarUrl")
    @Mapping(target = "role", ignore = true)
    User instructorToDomain(com.growup.backend.model.Instructor dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "joinDate", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "isActive", ignore = true)
    @Mapping(target = "avatar", ignore = true) // Register doesn't have avatar usually or handled separately
    User toDomain(com.growup.backend.model.RegisterRequest dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "joinDate", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "isActive", ignore = true)
    @Mapping(target = "email", ignore = true) // Usually email update requires re-verification
    @Mapping(target = "password", ignore = true) // Handled separately
    @Mapping(target = "avatar", expression = "java(toString(dto.getAvatar()))")
    @Mapping(target = "version", ignore = true)
    User toDomain(com.growup.backend.model.UpdateUserRequest dto);

    default URI toUri(String avatar) {
        if (avatar == null || avatar.isEmpty())
            return null;
        try {
            return URI.create(avatar);
        } catch (Exception e) {
            return null;
        }
    }

    default String toString(URI avatar) {
        return avatar != null ? avatar.toString() : null;
    }

    default com.growup.backend.model.Role mapRole(com.growup.backend.domain.model.Role role) {
        if (role == null)
            return null;
        return com.growup.backend.model.Role.fromValue(role.name());
    }

    default com.growup.backend.domain.model.Role mapRole(com.growup.backend.model.Role role) {
        if (role == null)
            return null;
        return com.growup.backend.domain.model.Role.valueOf(role.name());
    }
}
