package com.growup.backend.infrastructure.adapter.persistence.jpa.entity;

import com.growup.backend.model.ActivityType;
import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * Entidad JPA para el registro de actividades.
 */
@Entity
@Table(name = "activities")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActivityJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @EqualsAndHashCode.Include
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserJpaEntity user;

    @Column(nullable = false)
    private String action;

    @Column(nullable = false)
    private String target;

    @Column(nullable = false)
    private OffsetDateTime time;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ActivityType type;

    @PrePersist
    protected void onCreate() {
        if (time == null) {
            time = OffsetDateTime.now();
        }
    }
}
