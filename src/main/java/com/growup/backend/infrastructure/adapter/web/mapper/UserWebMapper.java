package com.growup.backend.infrastructure.adapter.web.mapper;

import com.growup.backend.domain.model.User;
import com.growup.backend.model.*;
import org.springframework.stereotype.Component;

import java.net.URI;

/**
 * Mapper para convertir entre el modelo de dominio User y los DTOs de OpenAPI.
 */
@Component
public class UserWebMapper {

    /** Dominio User → DTO Instructor (para mostrar en las cards de cursos) */
    public Instructor toInstructorDto(User user) {
        if (user == null)
            return null;

        Instructor dto = new Instructor();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setBio(user.getBio());
        dto.setAvatarUrl(toUri(user.getAvatar())); // String → URI
        return dto;
    }

    /** Dominio User → DTO User (perfil completo) */
    public com.growup.backend.model.User toDto(User user) {
        if (user == null)
            return null;

        com.growup.backend.model.User dto = new com.growup.backend.model.User();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setBio(user.getBio());
        dto.setAvatar(toUri(user.getAvatar())); // String → URI
        dto.setJoinDate(user.getJoinDate());
        dto.setIsActive(user.getIsActive());
        dto.setRole(mapRole(user.getRole())); // Enum dominio → Enum DTO
        return dto;
    }

    /** DTO User → Dominio User */
    public User toDomain(com.growup.backend.model.User dto) {
        if (dto == null)
            return null;

        User user = new User();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setBio(dto.getBio());
        user.setAvatar(toString(dto.getAvatar())); // URI → String
        user.setJoinDate(dto.getJoinDate());
        user.setIsActive(dto.getIsActive());
        user.setRole(mapRole(dto.getRole())); // Enum DTO → Enum dominio
        return user;
    }

    /** DTO Instructor → Dominio User (para cargar el instructor de un curso) */
    public User instructorToDomain(Instructor dto) {
        if (dto == null)
            return null;

        User user = new User();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setBio(dto.getBio());
        user.setAvatar(toString(dto.getAvatarUrl())); // URI → String
        // email, password, isActive y joinDate no están en el DTO de Instructor
        return user;
    }

    /** DTO RegisterRequest → Dominio User (registro de nuevo usuario) */
    public User toDomain(RegisterRequest dto) {
        if (dto == null)
            return null;

        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword()); // Se encriptará en AuthService
        user.setRole(mapRole(dto.getRole()));
        // id, joinDate, isActive y avatar se asignan en AuthService al registrar
        return user;
    }

    /** DTO UpdateUserRequest → Dominio User (actualización de perfil) */
    public User toDomain(UpdateUserRequest dto) {
        if (dto == null)
            return null;

        User user = new User();
        user.setName(dto.getName());
        user.setBio(dto.getBio());
        user.setAvatar(toString(dto.getAvatar())); // URI → String
        // email, password, id, joinDate e isActive no se actualizan por este DTO
        return user;
    }

    // ── Métodos de apoyo ─────────────────────────────────────────────────────

    /** String con URL → objeto URI (null si está vacío) */
    private URI toUri(String value) {
        if (value == null || value.isEmpty())
            return null;
        try {
            return URI.create(value);
        } catch (Exception e) {
            return null;
        }
    }

    /** URI → String para guardar en base de datos */
    private String toString(URI value) {
        return value != null ? value.toString() : null;
    }

    /** Enum de dominio → Enum de DTO OpenAPI */
    public Role mapRole(com.growup.backend.domain.model.Role role) {
        if (role == null)
            return null;
        return Role.fromValue(role.name());
    }

    /** Enum de DTO OpenAPI → Enum de dominio */
    public com.growup.backend.domain.model.Role mapRole(Role role) {
        if (role == null)
            return null;
        return com.growup.backend.domain.model.Role.valueOf(role.name());
    }
}
