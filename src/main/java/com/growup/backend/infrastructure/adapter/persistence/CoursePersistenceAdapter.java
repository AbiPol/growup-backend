package com.growup.backend.infrastructure.adapter.persistence;

import com.growup.backend.domain.port.out.CoursePersistencePort;
import com.growup.backend.domain.model.Course;
import com.growup.backend.model.CourseLevel;
import com.growup.backend.model.CourseStatus;
import com.growup.backend.infrastructure.adapter.persistence.jpa.repository.CourseJpaRepository;
import com.growup.backend.infrastructure.exception.ResourceNotFoundException;
import com.growup.backend.infrastructure.mapper.CoursePersistenceMapper;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Adaptador de persistencia para cursos.
 */
@Component
@RequiredArgsConstructor
public class CoursePersistenceAdapter implements CoursePersistencePort {

    private final CourseJpaRepository courseRepository;
    private final CoursePersistenceMapper courseMapper;

    @Override
    public Course save(Course course) {
        var entity = courseMapper.toEntity(course);
        if (entity == null) {
            throw new ResourceNotFoundException("Curso no encontrado en BBDD");
        }
        var savedEntity = courseRepository.save(entity);
        return courseMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Course> findById(UUID id) {
        return courseRepository.findById(id).map(courseMapper::toDomain);
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll().stream()
                .map(courseMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Course> findByCategory(String category) {
        return courseRepository.findByCategory(category).stream()
                .map(courseMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Course> findByInstructorId(UUID instructorId) {
        return courseRepository.findByInstructorId(instructorId).stream()
                .map(courseMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) {
        if (id != null) {
            // Gracias a las anotaciones @SQLDelete en CourseJpaEntity, esto realiza un
            // borrado lógico.
            courseRepository.deleteById(id);
        }
    }

    @Override
    public List<Course> findByFilters(UUID instructorId, String category, String level, String status) {
        CourseLevel levelEnum = null;
        if (level != null && !level.isEmpty()) {
            levelEnum = CourseLevel.fromValue(level);
        }

        CourseStatus statusEnum = null;
        if (status != null && !status.isEmpty()) {
            statusEnum = CourseStatus.fromValue(status);
        }

        return courseRepository.findWithFilters(instructorId, category, levelEnum, statusEnum).stream()
                .map(courseMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(UUID id) {
        if (id != null) {
            deleteById(id);
        }
    }
}
