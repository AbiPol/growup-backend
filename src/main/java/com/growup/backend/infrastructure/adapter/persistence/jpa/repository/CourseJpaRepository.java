package com.growup.backend.infrastructure.adapter.persistence.jpa.repository;

import com.growup.backend.infrastructure.adapter.persistence.jpa.entity.CourseJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
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
}
