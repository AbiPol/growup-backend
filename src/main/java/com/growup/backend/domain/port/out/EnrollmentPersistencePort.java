package com.growup.backend.domain.port.out;

import com.growup.backend.domain.model.Course;
import com.growup.backend.domain.model.Enrollment;
import com.growup.backend.domain.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Puerto de Salida para la persistencia de Inscripciones.
 */
public interface EnrollmentPersistencePort {
    Optional<Enrollment> findById(UUID id);

    List<Enrollment> findByStudentId(UUID studentId);

    Enrollment save(Enrollment enrollment);

    boolean existsByStudentIdAndCourseId(UUID studentId, UUID courseId);

    void deleteById(UUID id);

    Optional<Enrollment> findByUserAndCourse(User user, Course course);

    List<Enrollment> findByUserId(UUID userId);
}
