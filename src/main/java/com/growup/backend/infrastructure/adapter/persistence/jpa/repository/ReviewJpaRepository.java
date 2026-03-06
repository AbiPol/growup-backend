package com.growup.backend.infrastructure.adapter.persistence.jpa.repository;

import com.growup.backend.infrastructure.adapter.persistence.jpa.entity.ReviewJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * Repositorio JPA para la entidad ReviewJpaEntity.
 */
@Repository
public interface ReviewJpaRepository extends JpaRepository<ReviewJpaEntity, UUID> {

    List<ReviewJpaEntity> findByCourseId(UUID courseId);

    List<ReviewJpaEntity> findByCourseInstructorId(UUID instructorId);

    @Query("SELECT AVG(r.rating) FROM ReviewJpaEntity r WHERE r.course.instructor.id = :instructorId")
    Double getAverageRatingByInstructor(@Param("instructorId") UUID instructorId);

    @Query("SELECT AVG(r.rating) FROM ReviewJpaEntity r WHERE r.course.id = :courseId")
    Double getAverageRatingByCourseId(@Param("courseId") UUID courseId);
}
