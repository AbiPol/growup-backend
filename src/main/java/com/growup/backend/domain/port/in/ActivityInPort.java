package com.growup.backend.domain.port.in;

import com.growup.backend.domain.model.Activity;

import java.util.List;
import java.util.UUID;

/**
 * Puerto de Entrada para el registro de actividades.
 */
public interface ActivityInPort {
    void logActivity(UUID userId, String type, String action, String target);

    List<Activity> getActivitiesByUser(UUID userId);
}
