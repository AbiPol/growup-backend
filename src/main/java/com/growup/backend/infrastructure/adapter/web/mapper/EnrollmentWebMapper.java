package com.growup.backend.infrastructure.adapter.web.mapper;

import com.growup.backend.domain.model.Enrollment;
import com.growup.backend.model.CourseLevel;
import com.growup.backend.model.CourseStatus;
import com.growup.backend.model.EnrolledCourse;
import com.growup.backend.model.EnrollmentStatus;
import com.growup.backend.model.StudentStats;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Mapper manual para inscripciones y estadísticas de estudiante.
 */
@Component
@RequiredArgsConstructor
public class EnrollmentWebMapper {

    private final UserWebMapper userMapper;

    /** Dominio Enrollment -> DTO EnrolledCourse (aplanando datos del curso) */
    public EnrolledCourse toDto(Enrollment domain) {
        if (domain == null)
            return null;

        EnrolledCourse dto = new EnrolledCourse();
        dto.setId(domain.getId());
        dto.setProgress(domain.getProgress());
        dto.setLastAccessDate(domain.getLastAccessDate());
        dto.setEnrollmentStatus(mapToModelEnrollmentStatus(domain.getEnrollmentStatus()));
        dto.setNextLessonId(domain.getNextLessonId());

        if (domain.getCourse() != null) {
            dto.setName(domain.getCourse().getName());
            dto.setDescription(domain.getCourse().getDescription());
            dto.setImageUrl(domain.getCourse().getImageUrl());
            dto.setCategory(domain.getCourse().getCategory());
            dto.setLevel(mapToModelCourseLevel(domain.getCourse().getLevel()));
            dto.setPrice(domain.getCourse().getPrice());
            dto.setDuration(domain.getCourse().getDuration());
            dto.setStartDate(domain.getCourse().getStartDate());
            dto.setEndDate(domain.getCourse().getEndDate());
            dto.setPublicationStatus(mapToModelCourseStatus(domain.getCourse().getPublicationStatus()));
            dto.setCreatedAt(domain.getCourse().getCreatedAt());
            dto.setUpdatedAt(domain.getCourse().getUpdatedAt());
            dto.setInstructor(userMapper.toInstructorDto(domain.getCourse().getInstructor()));
            dto.setEnrolledCount(domain.getCourse().getEnrolledCount());
            dto.setSyllabus(new ArrayList<>());
        }

        return dto;
    }

    /** Dominio StudentStats -> DTO StudentStats */
    public StudentStats toStatsDto(com.growup.backend.domain.model.StudentStats domain) {
        if (domain == null)
            return null;

        StudentStats dto = new StudentStats();
        dto.setActiveCoursesCount(domain.getActiveCoursesCount());
        dto.setCompletedCoursesCount(domain.getCompletedCoursesCount());
        dto.setCertificatesEarned(domain.getCertificatesEarned());
        dto.setTotalHoursLearning(domain.getTotalHoursLearning());
        dto.setAverageScore(domain.getAverageScore());
        dto.setLearningStreakDays(domain.getLearningStreakDays());
        return dto;
    }

    // --- Auxiliares de conversión Enum ---

    private EnrollmentStatus mapToModelEnrollmentStatus(String status) {
        if (status == null)
            return null;
        try {
            return EnrollmentStatus.fromValue(status);
        } catch (Exception e) {
            return null;
        }
    }

    private CourseLevel mapToModelCourseLevel(String level) {
        if (level == null)
            return null;
        try {
            return CourseLevel.fromValue(level);
        } catch (Exception e) {
            return null;
        }
    }

    private CourseStatus mapToModelCourseStatus(String status) {
        if (status == null)
            return null;
        try {
            return CourseStatus.fromValue(status);
        } catch (Exception e) {
            return null;
        }
    }
}
