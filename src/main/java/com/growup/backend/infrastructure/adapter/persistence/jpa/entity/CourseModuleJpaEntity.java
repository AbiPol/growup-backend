package com.growup.backend.infrastructure.adapter.persistence.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Entidad JPA para módulos de curso.
 */
@Entity
@Table(name = "course_modules")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseModuleJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @EqualsAndHashCode.Include
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 1000)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false)
    private CourseJpaEntity course;

    @ElementCollection
    @CollectionTable(name = "module_topics", joinColumns = @JoinColumn(name = "module_id"))
    @Builder.Default
    private List<TopicJpaEntity> topics = new ArrayList<>();
}
