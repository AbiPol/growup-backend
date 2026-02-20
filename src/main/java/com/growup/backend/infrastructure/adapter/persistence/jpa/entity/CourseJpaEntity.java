package com.growup.backend.infrastructure.adapter.persistence.jpa.entity;

import com.growup.backend.model.CourseLevel;
import com.growup.backend.model.CourseStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Entidad JPA para la persistencia de cursos.
 */
@Entity
@Table(name = "courses")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @EqualsAndHashCode.Include
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(length = 2000)
    private String description;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(nullable = false)
    private String category;

    @Enumerated(EnumType.STRING)
    private CourseLevel level;

    @Column(nullable = false)
    private Double price;

    private BigDecimal duration;

    @Column(name = "start_date")
    private OffsetDateTime startDate;

    @Column(name = "end_date")
    private OffsetDateTime endDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "publication_status", nullable = false)
    private CourseStatus publicationStatus;

    @Column(name = "created_at", updatable = false)
    private OffsetDateTime createdAt;

    @Column(name = "updated_at")
    private OffsetDateTime updatedAt;

    @Column(name = "deleted_at")
    private OffsetDateTime deletedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instructor_id")
    private UserJpaEntity instructor;

    @Builder.Default
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CourseModuleJpaEntity> syllabus = new ArrayList<>();

    @Builder.Default
    @Column(name = "enrolled_count")
    private Integer enrolledCount = 0;

    @PrePersist
    protected void onCreate() {
        createdAt = OffsetDateTime.now();
        updatedAt = OffsetDateTime.now();
        if (enrolledCount == null)
            enrolledCount = 0;
        if (publicationStatus == null)
            publicationStatus = CourseStatus.BORRADOR;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = OffsetDateTime.now();
    }

    @Version
    // @Column(name = "version", nullable = false, columnDefinition = "int default
    // 0")
    private Long version = 0L;
}
