package com.growup.backend.infrastructure.mapper;

import com.growup.backend.domain.model.Review;
import com.growup.backend.infrastructure.adapter.persistence.jpa.entity.ReviewJpaEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Mapper para convertir entre el modelo de dominio Review y la entidad JPA
 * ReviewJpaEntity.
 */
@Component
@RequiredArgsConstructor
public class ReviewPersistenceMapper {

    public Review toDomain(ReviewJpaEntity entity) {
        if (entity == null)
            return null;

        return Review.builder()
                .id(entity.getId())
                .courseId(entity.getCourse().getId())
                .studentId(entity.getUser().getId())
                .studentName(entity.getUser().getName())
                .rating(entity.getRating())
                .comment(entity.getComment())
                .createdAt(entity.getCreatedAt())
                .version(entity.getVersion())
                .build();
    }

    public ReviewJpaEntity toEntity(Review domain) {
        if (domain == null)
            return null;

        return ReviewJpaEntity.builder()
                .id(domain.getId())
                .rating(domain.getRating())
                .comment(domain.getComment())
                .version(domain.getVersion() != null ? domain.getVersion() : 0L)
                .build();
    }
}
