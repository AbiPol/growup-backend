package com.growup.backend.infrastructure.adapter.persistence.jpa.repository;

import com.growup.backend.infrastructure.adapter.persistence.jpa.entity.CourseJpaEntity;
import com.growup.backend.model.CourseLevel;
import com.growup.backend.model.CourseStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * Repositorio JPA para la entidad CourseJpaEntity.
 */
@Repository
public interface CourseJpaRepository extends JpaRepository<CourseJpaEntity, UUID> {

    List<CourseJpaEntity> findByCategory(String category);

    List<CourseJpaEntity> findByInstructorId(UUID instructorId);

    @Query("SELECT c FROM CourseJpaEntity c WHERE " +
            "(:instructorId IS NULL OR c.instructor.id = :instructorId) AND " +
            "(:category IS NULL OR c.category = :category) AND " +
            "(:level IS NULL OR c.level = :level) AND " +
            "(:status IS NULL OR c.publicationStatus = :status)")
    List<CourseJpaEntity> findWithFilters(
            @Param("instructorId") UUID instructorId,
            @Param("category") String category,
            @Param("level") CourseLevel level,
            @Param("status") CourseStatus status);
}
