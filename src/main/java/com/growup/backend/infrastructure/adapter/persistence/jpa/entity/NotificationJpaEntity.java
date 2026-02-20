package com.growup.backend.infrastructure.adapter.persistence.jpa.entity;

import com.growup.backend.model.NotificationType;
import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * Entidad JPA para la persistencia de notificaciones.
 */
@Entity
@Table(name = "notifications")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotificationJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @EqualsAndHashCode.Include
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserJpaEntity user;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 1000)
    private String message;

    @Column(nullable = false)
    private OffsetDateTime date;

    @Builder.Default
    @Column(nullable = false)
    private Boolean read = false;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NotificationType type;

    private String link;

    @PrePersist
    protected void onCreate() {
        if (date == null)
            date = OffsetDateTime.now();
        if (read == null)
            read = false;
    }
}
