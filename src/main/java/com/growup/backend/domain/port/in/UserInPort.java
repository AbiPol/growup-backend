package com.growup.backend.domain.port.in;

import com.growup.backend.domain.model.User;

import java.util.List;
import java.util.UUID;

/**
 * Puerto de Entrada para los casos de uso de Usuario.
 */
public interface UserInPort {
    User getUserById(UUID id);

    List<User> getAllUsers();

    User updateUser(UUID id, User user);

    // Nota: El perfil del instructor podría ir en un CourseInPort o aquí
    User getInstructorProfile(UUID id);
}
