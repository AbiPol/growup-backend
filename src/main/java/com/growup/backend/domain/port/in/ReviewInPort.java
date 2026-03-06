package com.growup.backend.domain.port.in;

import com.growup.backend.domain.model.Review;
import java.util.List;
import java.util.UUID;

/**
 * Puerto de entrada para el manejo de valoraciones (Reviews).
 */
public interface ReviewInPort {
    /**
     * Crea una nueva reseña.
     * 
     * @param review Reseña a crear
     * @return Reseña creada
     */
    Review createReview(Review review);

    /**
     * Obtiene todas las reseñas de los cursos de un instructor.
     * 
     * @param instructorId ID del instructor
     * @return Lista de reseñas
     */
    List<Review> getReviewsByInstructor(UUID instructorId);
}
