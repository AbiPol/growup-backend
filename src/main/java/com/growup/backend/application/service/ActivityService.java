package com.growup.backend.application.service;

import com.growup.backend.domain.port.in.ActivityInPort;
import com.growup.backend.domain.port.out.ActivityPersistencePort;
import com.growup.backend.domain.port.out.UserPersistencePort;
import com.growup.backend.domain.model.Activity;
import com.growup.backend.domain.model.User;
import com.growup.backend.infrastructure.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Servicio de Aplicación para el registro de actividades.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ActivityService implements ActivityInPort {

    private final ActivityPersistencePort activityPersistencePort;
    private final UserPersistencePort userPersistencePort;

    @Override
    public void logActivity(UUID userId, String type, String action, String target) {
        log.info("GrowUp-Log: ActivityService - Registrando actividad para usuario {}", userId);

        User user = userPersistencePort.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado para registrar actividad"));

        Activity activity = Activity.builder()
                .user(user)
                .type(type)
                .action(action)
                .target(target)
                .time(OffsetDateTime.now())
                .build();

        activityPersistencePort.save(activity);
    }

    @Override
    public List<Activity> getActivitiesByUser(UUID userId) {
        log.info("GrowUp-Log: ActivityService - Buscando actividades para usuario {}", userId);
        return activityPersistencePort.findByUserIdOrderByTimeDesc(userId);
    }
}
