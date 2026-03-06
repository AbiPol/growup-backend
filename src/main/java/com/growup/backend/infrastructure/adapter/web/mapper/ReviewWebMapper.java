package com.growup.backend.infrastructure.adapter.web.mapper;

import com.growup.backend.domain.model.Review;
import com.growup.backend.infrastructure.adapter.persistence.jpa.repository.CourseJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Mapper para convertir entre el modelo de dominio Review y el DTO de la API.
 */
@Component
@RequiredArgsConstructor
public class ReviewWebMapper {

    private final CourseJpaRepository courseRepository;

    public com.growup.backend.model.Review toDto(Review domain) {
        if (domain == null)
            return null;

        var dto = new com.growup.backend.model.Review();
        dto.setId(domain.getId());
        dto.setCourseId(domain.getCourseId());
        dto.setStudentId(domain.getStudentId());
        dto.setStudentName(domain.getStudentName());
        dto.setRating(domain.getRating());
        dto.setComment(domain.getComment());
        dto.setCreatedAt(domain.getCreatedAt());
        dto.setVersion(domain.getVersion());

        // Para el nombre del curso, lo sacamos del repositorio si es necesario
        // o podríamos añadirlo al modelo de dominio Review si fuera muy frecuente
        if (domain.getCourseId() != null) {
            courseRepository.findById(domain.getCourseId())
                    .ifPresent(course -> dto.setCourseName(course.getName()));
        }

        return dto;
    }

    public Review toDomain(com.growup.backend.model.Review dto) {
        if (dto == null)
            return null;

        return Review.builder()
                .id(dto.getId())
                .courseId(dto.getCourseId())
                .studentId(dto.getStudentId())
                .studentName(dto.getStudentName())
                .rating(dto.getRating())
                .comment(dto.getComment())
                .createdAt(dto.getCreatedAt())
                .version(dto.getVersion())
                .build();
    }
}
