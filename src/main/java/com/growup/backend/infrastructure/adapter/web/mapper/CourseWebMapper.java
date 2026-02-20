package com.growup.backend.infrastructure.adapter.web.mapper;

import com.growup.backend.domain.model.Course;
import com.growup.backend.domain.model.CourseModule;
import com.growup.backend.domain.model.Topic;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper para convertir entre el modelo de dominio Course y los DTOs de
 * OpenAPI.
 */
@Mapper(componentModel = "spring", uses = { UserWebMapper.class })
public interface CourseWebMapper {

    @Mapping(target = "syllabus", source = "syllabus")
    @Mapping(target = "deletedAt", ignore = true)
    com.growup.backend.model.Course toDto(Course domain);

    @Mapping(target = "instructor", ignore = true)
    @Mapping(target = "enrolledCount", ignore = true)
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Course toDomain(com.growup.backend.model.Course dto);

    @Mapping(target = "syllabus", source = "syllabus")
    @Mapping(target = "students", source = "enrolledCount")
    @Mapping(target = "rating", ignore = true) // No rating in domain yet
    @Mapping(target = "deletedAt", ignore = true)
    com.growup.backend.model.CourseItem toCourseItemDto(Course domain);

    // Mappers para módulos (Syllabus en DTO)
    com.growup.backend.model.Syllabus toModuleDto(CourseModule domain);

    CourseModule toModuleDomain(com.growup.backend.model.Syllabus dto);

    // Mappers para temas
    @Mapping(target = "title", source = "name")
    com.growup.backend.model.Topic toTopicDto(Topic domain);

    @Mapping(target = "name", source = "title")
    @Mapping(target = "isFree", ignore = true)
    Topic toTopicDomain(com.growup.backend.model.Topic dto);
}
