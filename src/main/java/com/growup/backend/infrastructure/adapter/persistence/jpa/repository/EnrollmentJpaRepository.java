package com.growup.backend.infrastructure.adapter.persistence.jpa.repository;

import com.growup.backend.infrastructure.adapter.persistence.jpa.entity.EnrollmentJpaEntity;
import com.growup.backend.infrastructure.adapter.persistence.jpa.entity.UserJpaEntity;
import com.growup.backend.infrastructure.adapter.persistence.jpa.entity.CourseJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repositorio JPA para la entidad EnrollmentJpaEntity.
 */
@Repository
public interface EnrollmentJpaRepository extends JpaRepository<EnrollmentJpaEntity, UUID> {

    List<EnrollmentJpaEntity> findByUserId(UUID userId);

    Optional<EnrollmentJpaEntity> findByUserAndCourse(UserJpaEntity user, CourseJpaEntity course);

    // Alias para mayor claridad si se prefiere, pero apuntando al campo 'user'
    default List<EnrollmentJpaEntity> findByStudentId(UUID studentId) {
        return findByUserId(studentId);
    }

    boolean existsByUserIdAndCourseId(UUID userId, UUID courseId);
}
