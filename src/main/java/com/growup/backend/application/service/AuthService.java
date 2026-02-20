package com.growup.backend.application.service;

import com.growup.backend.domain.port.in.AuthInPort;
import com.growup.backend.domain.port.out.TokenGeneratorPort;
import com.growup.backend.domain.port.out.UserPersistencePort;
import com.growup.backend.domain.model.Role;
import com.growup.backend.domain.model.User;
import com.growup.backend.infrastructure.exception.ResourceNotFoundException;
import com.growup.backend.model.UpdateUserRequest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * Servicio de Aplicación para Autenticación.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService implements AuthInPort {

    private final UserPersistencePort userPersistencePort;
    private final TokenGeneratorPort tokenGeneratorPort;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public User login(String email, String password) {
        log.info("GrowUp-Log: AuthService - Intentando login para usuario: {}", email);
        log.info("GrowUp-Log: AuthService - Intentando login para contraseña: {}", password);

        // Autenticar con Spring Security (esto validará la contraseña)
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password));

        return userPersistencePort.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado tras autenticación exitosa"));
    }

    @Override
    public User register(User user, String password) {
        log.info("GrowUp-Log: AuthService - Registrando nuevo usuario: {}", user.getEmail());
        // log.info("GrowUp-Log: AuthService - Registrando nuevo usuario: {}", user);

        if (userPersistencePort.findByEmail(user.getEmail()).isPresent()) {
            throw new IllegalArgumentException("El email ya está registrado");
        }

        user.setId(UUID.randomUUID());
        user.setPassword(passwordEncoder.encode(password));
        user.setJoinDate(OffsetDateTime.now());
        user.setIsActive(true);
        user.setRole(Role.STUDENT); // Default role
        user.setVersion(0L);

        return userPersistencePort.save(user);
    }

    @Override
    public String generateToken(User user) {
        return tokenGeneratorPort.generateToken(user);
    }

    @Override
    public User getUser(String email) {
        return userPersistencePort.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con email: " + email));
    }

    @Override
    public User updateProfile(String email, UpdateUserRequest updatedData) {
        log.info("GrowUp-Log: AuthService - Actualizando perfil para usuario: {}", email);
        log.info("GrowUp-Log: AuthService - Actualizando perfil para usuario: {}", updatedData);
        // 1. Buscar el usuario existente
        User existingUser = userPersistencePort.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con email: " + email));

        // 2. Actualizar solo los campos permitidos
        if (updatedData.getName() != null && !updatedData.getName().isBlank()) {
            existingUser.setName(updatedData.getName());
        }
        if (updatedData.getEmail() != null && !updatedData.getEmail().isBlank()) {
            existingUser.setEmail(updatedData.getEmail());
        }
        if (updatedData.getPassword() != null && !updatedData.getPassword().isBlank()) {
            existingUser.setPassword(passwordEncoder.encode(updatedData.getPassword()));
        }
        if (updatedData.getAvatar() != null && !updatedData.getAvatar().toString().isBlank()) {
            existingUser.setAvatar(updatedData.getAvatar().toString());
        }
        if (updatedData.getBio() != null && !updatedData.getBio().isBlank()) {
            existingUser.setBio(updatedData.getBio());
        }

        // 3. Guardar los cambios
        return userPersistencePort.save(existingUser);
    }

}
