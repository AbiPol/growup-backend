package com.growup.backend.infrastructure.adapter.persistence.jpa.entity;

import com.growup.backend.model.EnrollmentStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * Entidad JPA para la persistencia de inscripciones.
 */
@Entity
@Table(name = "enrollments", uniqueConstraints = @UniqueConstraint(columnNames = { "user_id", "course_id" }))
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnrollmentJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @EqualsAndHashCode.Include
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserJpaEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false)
    private CourseJpaEntity course;

    @Builder.Default
    @Column(nullable = false)
    private Integer progress = 0;

    @Column(name = "last_access_date")
    private OffsetDateTime lastAccessDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "enrollment_status", nullable = false)
    @Builder.Default
    private EnrollmentStatus enrollmentStatus = EnrollmentStatus.ACTIVE;

    @Column(name = "next_lesson_id")
    private UUID nextLessonId;

    @PrePersist
    protected void onCreate() {
        if (lastAccessDate == null)
            lastAccessDate = OffsetDateTime.now();
        if (progress == null)
            progress = 0;
        if (enrollmentStatus == null)
            enrollmentStatus = EnrollmentStatus.ACTIVE;
    }

    @Version
    // @Column(name = "version", nullable = false, columnDefinition = "int default
    // 0")
    private Long version = 0L;
}
