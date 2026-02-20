package com.growup.backend.infrastructure.adapter.persistence.jpa.entity;

import com.growup.backend.domain.model.Role;
import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * Entidad JPA para la persistencia de usuarios.
 */
@Entity
@Table(name = "users")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @EqualsAndHashCode.Include
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Builder.Default
    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column(length = 1000)
    private String bio;

    @Column(name = "avatar_url")
    private String avatar;

    @Column(name = "join_date", updatable = false)
    private OffsetDateTime joinDate;

    @PrePersist
    protected void onCreate() {
        if (joinDate == null) {
            joinDate = OffsetDateTime.now();
        }
        if (isActive == null) {
            isActive = true;
        }
    }

    @Version
    // @Column(name = "version", nullable = false, columnDefinition = "int default
    // 0")
    private Long version = 0L;
}
