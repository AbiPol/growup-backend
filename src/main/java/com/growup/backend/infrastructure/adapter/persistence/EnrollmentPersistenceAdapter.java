package com.growup.backend.infrastructure.adapter.persistence;

import com.growup.backend.domain.port.out.EnrollmentPersistencePort;
import com.growup.backend.domain.model.Course;
import com.growup.backend.domain.model.Enrollment;
import com.growup.backend.domain.model.User;
import com.growup.backend.infrastructure.adapter.persistence.jpa.repository.EnrollmentJpaRepository;
import com.growup.backend.infrastructure.mapper.CoursePersistenceMapper;
import com.growup.backend.infrastructure.mapper.EnrollmentPersistenceMapper;
import com.growup.backend.infrastructure.mapper.UserPersistenceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Adaptador de persistencia para inscripciones.
 */
@Component
@RequiredArgsConstructor
public class EnrollmentPersistenceAdapter implements EnrollmentPersistencePort {

    private final EnrollmentJpaRepository enrollmentRepository;
    private final EnrollmentPersistenceMapper enrollmentMapper;
    private final UserPersistenceMapper userMapper;
    private final CoursePersistenceMapper courseMapper;

    @Override
    public Enrollment save(Enrollment enrollment) {
        var entity = enrollmentMapper.toEntity(enrollment);
        var savedEntity = enrollmentRepository.save(entity);
        return enrollmentMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Enrollment> findById(UUID id) {
        return enrollmentRepository.findById(id).map(enrollmentMapper::toDomain);
    }

    @Override
    public List<Enrollment> findByUserId(UUID userId) {
        return enrollmentRepository.findByUserId(userId).stream()
                .map(enrollmentMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Enrollment> findByUserAndCourse(User user, Course course) {
        var userEntity = userMapper.toEntity(user);
        var courseEntity = courseMapper.toEntity(course);
        return enrollmentRepository.findByUserAndCourse(userEntity, courseEntity)
                .map(enrollmentMapper::toDomain);
    }

    @Override
    public void deleteById(UUID id) {
        enrollmentRepository.deleteById(id);
    }

    @Override
    public List<Enrollment> findByStudentId(UUID studentId) {
        return enrollmentRepository.findByUserId(studentId).stream()
                .map(enrollmentMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public boolean existsByStudentIdAndCourseId(UUID studentId, UUID courseId) {
        return enrollmentRepository.existsByUserIdAndCourseId(studentId, courseId);
    }
}
