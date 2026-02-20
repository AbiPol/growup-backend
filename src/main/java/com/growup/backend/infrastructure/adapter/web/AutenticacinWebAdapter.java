package com.growup.backend.infrastructure.adapter.web;

import com.growup.backend.api.AutenticacinApiDelegate;
import com.growup.backend.domain.port.in.AuthInPort;
import com.growup.backend.infrastructure.adapter.web.mapper.UserWebMapper;
import com.growup.backend.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * Adaptador Web para Autenticación.
 * Implementa AutenticacinApiDelegate delegando en AuthInPort.
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class AutenticacinWebAdapter implements AutenticacinApiDelegate {

    private final AuthInPort authInPort;
    private final UserWebMapper userMapper;

    @Override
    public ResponseEntity<AuthResponse> authLoginPost(LoginRequest loginRequest) {
        var user = authInPort.login(loginRequest.getEmail(), loginRequest.getPassword());
        var token = authInPort.generateToken(user);

        AuthResponse response = new AuthResponse();
        response.setUser(userMapper.toDto(user));
        response.setToken(token);

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<AuthResponse> authRegisterPost(RegisterRequest registerRequest) {
        var domainUser = userMapper.toDomain(registerRequest);
        var createdUser = authInPort.register(domainUser, registerRequest.getPassword());
        var token = authInPort.generateToken(createdUser);

        AuthResponse response = new AuthResponse();
        response.setUser(userMapper.toDto(createdUser));
        response.setToken(token);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Override
    public ResponseEntity<User> authMeGet() {
        // 1. Obtener el email del usuario autenticado desde Spring Security
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        // 2. Llamar al caso de uso (Dominio)
        com.growup.backend.domain.model.User userDomain = authInPort.getUser(email);
        // 3. Mapear a DTO de OpenAPI y devolver
        return ResponseEntity.ok(userMapper.toDto(userDomain));
    }

    @Override
    public ResponseEntity<User> authMePut(UpdateUserRequest updateUserRequest) {
        log.info("GrowUp-Log: AutenticacinWebAdapter - Actualizando perfil para usuario: {}", updateUserRequest);
        // 1. Obtener el email del usuario autenticado desde Spring Security
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        // 2. Llamar al caso de uso (Dominio)
        com.growup.backend.domain.model.User userDomain = authInPort.updateProfile(email, updateUserRequest);
        // 3. Mapear a DTO de OpenAPI y devolver
        return ResponseEntity.ok(userMapper.toDto(userDomain));
    }
}
