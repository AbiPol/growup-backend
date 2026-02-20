package com.growup.backend.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Modelo de dominio para un Tema (Topic).
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Topic {
    private String name;
    private String duration;
    private Boolean isFree;
}
