package com.growup.backend.application.service;

import com.growup.backend.domain.port.in.CourseInPort;
import com.growup.backend.domain.port.out.CoursePersistencePort;
import com.growup.backend.domain.port.out.UserPersistencePort;
import com.growup.backend.domain.model.Course;
import com.growup.backend.domain.model.User;
import com.growup.backend.infrastructure.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Servicio de Aplicación para Cursos.
 * Coordina la creación, actualización y consulta de cursos usando Puertos.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class CourseService implements CourseInPort {

    private final CoursePersistencePort coursePersistencePort;
    private final UserPersistencePort userPersistencePort;

    @Override
    public List<Course> getAllCourses(String category, String level, String status) {
        log.info("GrowUp-Log: CourseService - Listando cursos con filtros");
        return coursePersistencePort.findByFilters(category, level, status);
    }

    @Override
    public Course getCourseById(UUID id) {
        log.info("GrowUp-Log: CourseService - Buscando curso ID: {}", id);
        return coursePersistencePort.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Curso no encontrado con ID: " + id));
    }

    @Override
    public Course createCourse(Course course, UUID instructorId) {
        log.info("GrowUp-Log: CourseService - Creando curso: {} por instructor: {}", course.getName(), instructorId);

        User instructor = userPersistencePort.findById(instructorId)
                .orElseThrow(() -> new ResourceNotFoundException("Instructor no encontrado"));

        course.setInstructor(instructor);
        return coursePersistencePort.save(course);
    }

    @Override
    public Course updateCourse(UUID id, Course course) {
        log.info("GrowUp-Log: CourseService - Actualizando curso: {}", id);
        Course existing = getCourseById(id);

        // Mapeo manual de campos (o delegar en un mapper de dominio)
        existing.setName(course.getName());
        existing.setDescription(course.getDescription());
        existing.setImageUrl(course.getImageUrl());
        existing.setCategory(course.getCategory());
        existing.setLevel(course.getLevel());
        existing.setPrice(course.getPrice());
        existing.setDuration(course.getDuration());
        existing.setPublicationStatus(course.getPublicationStatus());
        existing.setStartDate(course.getStartDate());
        existing.setEndDate(course.getEndDate());
        existing.setSyllabus(course.getSyllabus());

        return coursePersistencePort.save(existing);
    }

    @Override
    public void deleteCourse(UUID id) {
        log.info("GrowUp-Log: CourseService - Eliminando curso: {}", id);
        coursePersistencePort.delete(id);
    }

    @Override
    public List<Course> getCoursesByInstructor(UUID instructorId) {
        log.info("GrowUp-Log: CourseService - Listando cursos del instructor: {}", instructorId);
        return coursePersistencePort.findByInstructorId(instructorId);
    }
}
