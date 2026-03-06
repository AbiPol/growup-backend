package com.growup.backend.infrastructure.adapter.persistence;

import com.growup.backend.domain.model.Review;
import com.growup.backend.domain.port.out.ReviewPersistencePort;
import com.growup.backend.infrastructure.adapter.persistence.jpa.repository.ReviewJpaRepository;
import com.growup.backend.infrastructure.adapter.persistence.jpa.repository.CourseJpaRepository;
import com.growup.backend.infrastructure.adapter.persistence.jpa.repository.UserJpaRepository;
import com.growup.backend.infrastructure.mapper.ReviewPersistenceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Adaptador de persistencia para Valoraciones (Reviews).
 */
@Component
@RequiredArgsConstructor
public class ReviewPersistenceAdapter implements ReviewPersistencePort {

    private final ReviewJpaRepository reviewRepository;
    private final CourseJpaRepository courseRepository;
    private final UserJpaRepository userRepository;
    private final ReviewPersistenceMapper reviewMapper;

    @Override
    public Review save(Review review) {
        var entity = reviewMapper.toEntity(review);

        // Asignar relaciones
        var course = courseRepository.getReferenceById(review.getCourseId());
        var user = userRepository.getReferenceById(review.getStudentId());
        entity.setCourse(course);
        entity.setUser(user);

        var savedEntity = reviewRepository.save(entity);
        return reviewMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Review> findById(UUID id) {
        return reviewRepository.findById(id).map(reviewMapper::toDomain);
    }

    @Override
    public List<Review> findByCourseId(UUID courseId) {
        return reviewRepository.findByCourseId(courseId).stream()
                .map(reviewMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Review> findByInstructorId(UUID instructorId) {
        return reviewRepository.findByCourseInstructorId(instructorId).stream()
                .map(reviewMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Double getAverageRatingByInstructor(UUID instructorId) {
        return reviewRepository.getAverageRatingByInstructor(instructorId);
    }

    @Override
    public Double getAverageRatingByCourseId(UUID courseId) {
        return reviewRepository.getAverageRatingByCourseId(courseId);
    }

    @Override
    public void deleteById(UUID id) {
        reviewRepository.deleteById(id);
    }
}
