package com.growup.backend.infrastructure.adapter.persistence.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

/**
 * Clase Embeddable para temas de módulo.
 */
@Embeddable
@Getter
@Setter
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TopicJpaEntity {

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Integer duration;
}
