package com.growup.backend.application.service;

import com.growup.backend.domain.port.in.UserInPort;
import com.growup.backend.domain.port.out.UserPersistencePort;
import com.growup.backend.domain.model.User;
import com.growup.backend.infrastructure.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Servicio de Aplicación para Usuarios.
 * Implementa el Puerto de Entrada y se comunica con el Puerto de Salida.
 * Aquí reside la lógica de coordinación de negocio.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class UserService implements UserInPort {

    private final UserPersistencePort userPersistencePort;

    @Override
    public User getUserById(UUID id) {
        log.info("GrowUp-Log: UserService - Buscando usuario por ID: {}", id);
        return userPersistencePort.findById(id)
                .orElseThrow(() -> {
                    log.error("GrowUp-Log: UserService - Usuario no encontrado: {}", id);
                    return new ResourceNotFoundException("Usuario no encontrado con ID: " + id);
                });
    }

    @Override
    public List<User> getAllUsers() {
        log.info("GrowUp-Log: UserService - Listando todos los usuarios");
        return userPersistencePort.findAll();
    }

    @Override
    public User updateUser(UUID id, User user) {
        log.info("GrowUp-Log: UserService - Actualizando usuario: {}", id);
        User existingUser = getUserById(id);

        // Aplicamos cambios al modelo de dominio
        existingUser.setName(user.getName());
        existingUser.setBio(user.getBio());
        existingUser.setAvatar(user.getAvatar());
        existingUser.setVersion(user.getVersion());

        return userPersistencePort.save(existingUser);
    }

    @Override
    public User getInstructorProfile(UUID id) {
        log.info("GrowUp-Log: UserService - Cargando perfil de instructor: {}", id);
        // En una arquitectura pura, podríamos tener lógica específica aquí
        return getUserById(id);
    }
}
