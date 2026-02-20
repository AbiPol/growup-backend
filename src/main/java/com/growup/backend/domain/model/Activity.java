package com.growup.backend.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * Modelo de dominio puro para la Actividad.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Activity {
    private UUID id;
    private User user;
    private String action;
    private String target;
    private OffsetDateTime time;
    private String type;
}
