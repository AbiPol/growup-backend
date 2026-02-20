package com.growup.backend.infrastructure.adapter.web.mapper;

import com.growup.backend.domain.model.Enrollment;
import org.mapstruct.Mapper;

/**
 * Mapper para convertir entre el modelo de dominio Enrollment y el DTO
 * EnrolledCourse de OpenAPI.
 */
@Mapper(componentModel = "spring", uses = { UserWebMapper.class, CourseWebMapper.class })
public interface EnrollmentWebMapper {

    @org.mapstruct.Mapping(target = "name", source = "course.name")
    @org.mapstruct.Mapping(target = "description", source = "course.description")
    @org.mapstruct.Mapping(target = "imageUrl", source = "course.imageUrl")
    @org.mapstruct.Mapping(target = "category", source = "course.category")
    @org.mapstruct.Mapping(target = "level", source = "course.level")
    @org.mapstruct.Mapping(target = "price", source = "course.price")
    @org.mapstruct.Mapping(target = "duration", source = "course.duration")
    @org.mapstruct.Mapping(target = "startDate", source = "course.startDate")
    @org.mapstruct.Mapping(target = "endDate", source = "course.endDate")
    @org.mapstruct.Mapping(target = "publicationStatus", source = "course.publicationStatus")
    @org.mapstruct.Mapping(target = "createdAt", source = "course.createdAt")
    @org.mapstruct.Mapping(target = "updatedAt", source = "course.updatedAt")
    @org.mapstruct.Mapping(target = "deletedAt", ignore = true)
    @org.mapstruct.Mapping(target = "instructor", source = "course.instructor")
    @org.mapstruct.Mapping(target = "syllabus", source = "course.syllabus")
    @org.mapstruct.Mapping(target = "enrolledCount", source = "course.enrolledCount")
    com.growup.backend.model.EnrolledCourse toDto(Enrollment domain);

    @org.mapstruct.Mapping(target = "course.name", source = "name")
    @org.mapstruct.Mapping(target = "course.description", source = "description")
    @org.mapstruct.Mapping(target = "course.imageUrl", source = "imageUrl")
    @org.mapstruct.Mapping(target = "course.category", source = "category")
    @org.mapstruct.Mapping(target = "course.level", source = "level")
    @org.mapstruct.Mapping(target = "course.price", source = "price")
    @org.mapstruct.Mapping(target = "course.duration", source = "duration")
    @org.mapstruct.Mapping(target = "course.startDate", source = "startDate")
    @org.mapstruct.Mapping(target = "course.endDate", source = "endDate")
    @org.mapstruct.Mapping(target = "course.publicationStatus", source = "publicationStatus")
    @org.mapstruct.Mapping(target = "course.createdAt", source = "createdAt")
    @org.mapstruct.Mapping(target = "course.updatedAt", source = "updatedAt")
    @org.mapstruct.Mapping(target = "course.instructor", source = "instructor")
    @org.mapstruct.Mapping(target = "course.syllabus", source = "syllabus")
    @org.mapstruct.Mapping(target = "course.enrolledCount", source = "enrolledCount")
    @org.mapstruct.Mapping(target = "course.version", ignore = true)
    @org.mapstruct.Mapping(target = "student", ignore = true)
    @org.mapstruct.Mapping(target = "version", ignore = true)
    Enrollment toDomain(com.growup.backend.model.EnrolledCourse dto);

    com.growup.backend.model.StudentStats toStatsDto(com.growup.backend.domain.model.StudentStats domain);
}
