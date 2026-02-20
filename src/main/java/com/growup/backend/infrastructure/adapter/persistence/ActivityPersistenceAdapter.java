package com.growup.backend.infrastructure.adapter.persistence;

import com.growup.backend.domain.port.out.ActivityPersistencePort;
import com.growup.backend.domain.model.Activity;
import com.growup.backend.infrastructure.adapter.persistence.jpa.repository.ActivityJpaRepository;
import com.growup.backend.infrastructure.mapper.ActivityPersistenceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Adaptador de persistencia para actividades.
 */
@Component
@RequiredArgsConstructor
public class ActivityPersistenceAdapter implements ActivityPersistencePort {

    private final ActivityJpaRepository activityRepository;
    private final ActivityPersistenceMapper activityMapper;

    @Override
    public Activity save(Activity activity) {
        var entity = activityMapper.toEntity(activity);
        var savedEntity = activityRepository.save(entity);
        return activityMapper.toDomain(savedEntity);
    }

    @Override
    public List<Activity> findByUserIdOrderByTimeDesc(UUID userId) {
        return activityRepository.findByUserIdOrderByTimeDesc(userId).stream()
                .map(activityMapper::toDomain)
                .collect(Collectors.toList());
    }
}
