package com.growup.backend.application.service;

import com.growup.backend.domain.port.in.NotificationInPort;
import com.growup.backend.domain.port.out.NotificationPersistencePort;
import com.growup.backend.domain.port.out.UserPersistencePort;
import com.growup.backend.domain.model.Notification;
import com.growup.backend.domain.model.User;
import com.growup.backend.infrastructure.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Servicio de Aplicación para Notificaciones.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationService implements NotificationInPort {

    private final NotificationPersistencePort notificationPersistencePort;
    private final UserPersistencePort userPersistencePort;

    @Override
    public Notification sendNotification(UUID userId, String title, String message, String type, URI link) {
        log.info("GrowUp-Log: NotificationService - Enviando notificación a usuario {}", userId);

        User user = userPersistencePort.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));

        Notification notification = Notification.builder()
                .user(user)
                .title(title)
                .message(message)
                .type(type)
                .link(link)
                .date(OffsetDateTime.now())
                .read(false)
                .build();

        return notificationPersistencePort.save(notification);
    }

    @Override
    public List<Notification> getNotificationsByUser(UUID userId) {
        return notificationPersistencePort.findByUserId(userId);
    }

    @Override
    public void markAsRead(UUID notificationId) {
        notificationPersistencePort.findById(notificationId)
                .ifPresent(n -> {
                    n.setRead(true);
                    notificationPersistencePort.save(n);
                });
    }

    @Override
    public long countUnread(UUID userId) {
        return notificationPersistencePort.countUnreadByUserId(userId);
    }
}
