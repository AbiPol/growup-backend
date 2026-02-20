package com.growup.backend.infrastructure.mapper;

import com.growup.backend.domain.model.Course;
import com.growup.backend.domain.model.CourseModule;
import com.growup.backend.domain.model.Topic;
import com.growup.backend.infrastructure.adapter.persistence.jpa.entity.CourseJpaEntity;
import com.growup.backend.infrastructure.adapter.persistence.jpa.entity.CourseModuleJpaEntity;
import com.growup.backend.infrastructure.adapter.persistence.jpa.entity.TopicJpaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Mapper para convertir entre el modelo de dominio Course y la entidad JPA
 * CourseJpaEntity.
 */
@Mapper(componentModel = "spring")
public interface CoursePersistenceMapper {

    @Mapping(target = "syllabus", source = "syllabus")
    @Mapping(target = "level", expression = "java(mapLevel(entity.getLevel()))")
    @Mapping(target = "publicationStatus", expression = "java(mapStatus(entity.getPublicationStatus()))")
    @Mapping(target = "imageUrl", expression = "java(toUri(entity.getImageUrl()))")
    Course toDomain(CourseJpaEntity entity);

    @Mapping(target = "syllabus", source = "syllabus")
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "level", expression = "java(mapLevel(domain.getLevel()))")
    @Mapping(target = "publicationStatus", expression = "java(mapStatus(domain.getPublicationStatus()))")
    @Mapping(target = "imageUrl", expression = "java(toString(domain.getImageUrl()))")
    @Mapping(target = "instructor", ignore = true) // Handled by service or user mapper
    CourseJpaEntity toEntity(Course domain);

    // Mappers para módulos (usados automáticamente por MapStruct)
    CourseModule toDomainModule(CourseModuleJpaEntity entity);

    @Mapping(target = "course", ignore = true) // Evitar ciclo infinito
    CourseModuleJpaEntity toEntityModule(CourseModule domain);

    // Mappers para temas
    @Mapping(target = "duration", expression = "java(mapDuration(entity.getDuration()))")
    Topic toDomainTopic(TopicJpaEntity entity);

    @Mapping(target = "duration", expression = "java(mapDuration(domain.getDuration()))")
    TopicJpaEntity toEntityTopic(Topic domain);

    default java.net.URI toUri(String value) {
        return (value != null && !value.isEmpty()) ? java.net.URI.create(value) : null;
    }

    default String toString(java.net.URI value) {
        return value != null ? value.toString() : null;
    }

    default String mapLevel(com.growup.backend.model.CourseLevel level) {
        return level != null ? level.getValue() : null;
    }

    default com.growup.backend.model.CourseLevel mapLevel(String level) {
        if (level == null)
            return null;
        try {
            return com.growup.backend.model.CourseLevel.fromValue(level);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    default String mapStatus(com.growup.backend.model.CourseStatus status) {
        return status != null ? status.getValue() : null;
    }

    default com.growup.backend.model.CourseStatus mapStatus(String status) {
        if (status == null)
            return null;
        try {
            return com.growup.backend.model.CourseStatus.fromValue(status);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    default String mapDuration(Integer duration) {
        return duration != null ? duration.toString() + " hours" : null;
    }

    default Integer mapDuration(String duration) {
        if (duration == null)
            return null;
        try {
            // Assumes format "X hours" or just "X"
            String clean = duration.replace(" hours", "").replace(" hour", "").trim();
            return Integer.parseInt(clean);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
