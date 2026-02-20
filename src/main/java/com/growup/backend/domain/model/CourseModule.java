package com.growup.backend.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

/**
 * Modelo de dominio para un Módulo de Curso.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseModule {
    private UUID id;
    private String title;
    private String description;
    private List<Topic> topics;
}
