package com.growup.backend.api;

import com.growup.backend.model.EnrolledCourse;
import com.growup.backend.model.ErrorResponse;
import com.growup.backend.model.Notification;
import com.growup.backend.model.StudentStats;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

/**
 * A delegate to be called by the {@link EstudianteApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-12T11:59:11.015804600Z[Atlantic/Canary]")
public interface EstudianteApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /courses/{id}/enroll : Inscribirse en un curso
     * Inscribir al estudiante autenticado en un curso
     *
     * @param id ID del curso (required)
     * @return Inscripción exitosa (status code 200)
     *         or Curso no encontrado (status code 404)
     *         or Ya inscrito en el curso (status code 409)
     * @see EstudianteApi#coursesIdEnrollPost
     */
    default ResponseEntity<EnrolledCourse> coursesIdEnrollPost(UUID id) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "null";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /student/enrollments : Obtener mis inscripciones
     * Obtener lista de cursos en los que está inscrito el estudiante
     *
     * @return Lista de cursos inscritos (status code 200)
     * @see EstudianteApi#studentEnrollmentsGet
     */
    default ResponseEntity<List<EnrolledCourse>> studentEnrollmentsGet() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ null, null ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /student/notifications : Obtener notificaciones
     * Obtener lista de notificaciones del estudiante
     *
     * @param unreadOnly Mostrar solo notificaciones no leídas (optional, default to false)
     * @return Lista de notificaciones (status code 200)
     * @see EstudianteApi#studentNotificationsGet
     */
    default ResponseEntity<List<Notification>> studentNotificationsGet(Boolean unreadOnly) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"date\" : \"2000-01-23T04:56:07.000+00:00\", \"read\" : true, \"link\" : \"https://openapi-generator.tech\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"title\" : \"title\", \"message\" : \"message\", \"userId\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" }, { \"date\" : \"2000-01-23T04:56:07.000+00:00\", \"read\" : true, \"link\" : \"https://openapi-generator.tech\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"title\" : \"title\", \"message\" : \"message\", \"userId\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /student/notifications/{id}/read : Marcar notificación como leída
     * Marcar una notificación específica como leída
     *
     * @param id ID de la notificación (required)
     * @return Notificación marcada como leída (status code 200)
     *         or Notificación no encontrada (status code 404)
     * @see EstudianteApi#studentNotificationsIdReadPut
     */
    default ResponseEntity<Void> studentNotificationsIdReadPut(UUID id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /student/stats : Obtener estadísticas del estudiante
     * Obtener estadísticas de aprendizaje del estudiante autenticado
     *
     * @return Estadísticas del estudiante (status code 200)
     * @see EstudianteApi#studentStatsGet
     */
    default ResponseEntity<StudentStats> studentStatsGet() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"completedCoursesCount\" : 6, \"activeCoursesCount\" : 0, \"learningStreakDays\" : 2, \"totalHoursLearning\" : 5.962133916683182, \"certificatesEarned\" : 1, \"averageScore\" : 56.37376656633328 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
