package com.growup.backend.infrastructure.adapter.persistence;

import com.growup.backend.domain.port.out.NotificationPersistencePort;
import com.growup.backend.domain.model.Notification;
import com.growup.backend.infrastructure.adapter.persistence.jpa.repository.NotificationJpaRepository;
import com.growup.backend.infrastructure.mapper.NotificationPersistenceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Adaptador de persistencia para notificaciones.
 */
@Component
@RequiredArgsConstructor
public class NotificationPersistenceAdapter implements NotificationPersistencePort {

    private final NotificationJpaRepository notificationRepository;
    private final NotificationPersistenceMapper notificationMapper;

    @Override
    public Notification save(Notification notification) {
        var entity = notificationMapper.toEntity(notification);
        var savedEntity = notificationRepository.save(entity);
        return notificationMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Notification> findById(UUID id) {
        return notificationRepository.findById(id).map(notificationMapper::toDomain);
    }

    @Override
    public List<Notification> findByUserIdOrderByDateDesc(UUID userId) {
        return notificationRepository.findByUserIdOrderByDateDesc(userId).stream()
                .map(notificationMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public long countByUserIdAndReadFalse(UUID userId) {
        return notificationRepository.countByUserIdAndReadFalse(userId);
    }

    @Override
    public void deleteById(UUID id) {
        notificationRepository.deleteById(id);
    }

    @Override
    public List<Notification> findByUserId(UUID userId) {
        return notificationRepository.findByUserId(userId).stream()
                .map(notificationMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public long countUnreadByUserId(UUID userId) {
        return notificationRepository.countByUserIdAndReadFalse(userId);
    }
}
