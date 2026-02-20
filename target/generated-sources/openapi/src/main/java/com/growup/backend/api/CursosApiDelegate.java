package com.growup.backend.api;

import com.growup.backend.model.Course;
import com.growup.backend.model.CourseLevel;
import com.growup.backend.model.CourseStatus;
import com.growup.backend.model.ErrorResponse;
import com.growup.backend.model.Syllabus;
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
 * A delegate to be called by the {@link CursosApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-20T14:24:19.066966500Z[Atlantic/Canary]")
public interface CursosApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /courses : Listar cursos
     * Obtener lista de cursos con filtros opcionales
     *
     * @param category Filtrar por categoría (optional)
     * @param level Filtrar por nivel (optional)
     * @param status Filtrar por estado de publicación (optional)
     * @return Lista de cursos (status code 200)
     * @see CursosApi#coursesGet
     */
    default ResponseEntity<List<Course>> coursesGet(String category,
        CourseLevel level,
        CourseStatus status) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"syllabus\" : [ { \"topics\" : [ { \"duration\" : 1, \"title\" : \"title\" }, { \"duration\" : 1, \"title\" : \"title\" } ], \"description\" : \"description\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"title\" : \"title\" }, { \"topics\" : [ { \"duration\" : 1, \"title\" : \"title\" }, { \"duration\" : 1, \"title\" : \"title\" } ], \"description\" : \"description\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"title\" : \"title\" } ], \"endDate\" : \"2000-01-23T04:56:07.000+00:00\", \"description\" : \"description\", \"version\" : 5, \"duration\" : 6.027456183070403, \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"deletedAt\" : \"2000-01-23T04:56:07.000+00:00\", \"instructor\" : { \"role\" : \"role\", \"avatarUrl\" : \"https://openapi-generator.tech\", \"name\" : \"name\", \"bio\" : \"bio\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" }, \"price\" : 0.8008281904610115, \"imageUrl\" : \"https://openapi-generator.tech\", \"name\" : \"name\", \"enrolledCount\" : 5, \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"category\" : \"category\", \"startDate\" : \"2000-01-23T04:56:07.000+00:00\", \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" }, { \"syllabus\" : [ { \"topics\" : [ { \"duration\" : 1, \"title\" : \"title\" }, { \"duration\" : 1, \"title\" : \"title\" } ], \"description\" : \"description\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"title\" : \"title\" }, { \"topics\" : [ { \"duration\" : 1, \"title\" : \"title\" }, { \"duration\" : 1, \"title\" : \"title\" } ], \"description\" : \"description\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"title\" : \"title\" } ], \"endDate\" : \"2000-01-23T04:56:07.000+00:00\", \"description\" : \"description\", \"version\" : 5, \"duration\" : 6.027456183070403, \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"deletedAt\" : \"2000-01-23T04:56:07.000+00:00\", \"instructor\" : { \"role\" : \"role\", \"avatarUrl\" : \"https://openapi-generator.tech\", \"name\" : \"name\", \"bio\" : \"bio\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" }, \"price\" : 0.8008281904610115, \"imageUrl\" : \"https://openapi-generator.tech\", \"name\" : \"name\", \"enrolledCount\" : 5, \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"category\" : \"category\", \"startDate\" : \"2000-01-23T04:56:07.000+00:00\", \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /courses/{id} : Eliminar curso
     * Eliminar un curso (soft delete)
     *
     * @param id ID del curso (required)
     * @return Curso eliminado exitosamente (status code 204)
     *         or Curso no encontrado (status code 404)
     * @see CursosApi#coursesIdDelete
     */
    default ResponseEntity<Void> coursesIdDelete(UUID id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /courses/{id} : Obtener detalles del curso
     * Obtener información completa de un curso
     *
     * @param id ID del curso (required)
     * @return Detalles del curso (status code 200)
     *         or Curso no encontrado (status code 404)
     * @see CursosApi#coursesIdGet
     */
    default ResponseEntity<Course> coursesIdGet(UUID id) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"syllabus\" : [ { \"topics\" : [ { \"duration\" : 1, \"title\" : \"title\" }, { \"duration\" : 1, \"title\" : \"title\" } ], \"description\" : \"description\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"title\" : \"title\" }, { \"topics\" : [ { \"duration\" : 1, \"title\" : \"title\" }, { \"duration\" : 1, \"title\" : \"title\" } ], \"description\" : \"description\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"title\" : \"title\" } ], \"endDate\" : \"2000-01-23T04:56:07.000+00:00\", \"description\" : \"description\", \"version\" : 5, \"duration\" : 6.027456183070403, \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"deletedAt\" : \"2000-01-23T04:56:07.000+00:00\", \"instructor\" : { \"role\" : \"role\", \"avatarUrl\" : \"https://openapi-generator.tech\", \"name\" : \"name\", \"bio\" : \"bio\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" }, \"price\" : 0.8008281904610115, \"imageUrl\" : \"https://openapi-generator.tech\", \"name\" : \"name\", \"enrolledCount\" : 5, \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"category\" : \"category\", \"startDate\" : \"2000-01-23T04:56:07.000+00:00\", \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /courses/{id} : Actualizar curso
     * Actualizar información de un curso
     *
     * @param id ID del curso (required)
     * @param course  (required)
     * @return Curso actualizado exitosamente (status code 200)
     *         or Curso no encontrado (status code 404)
     * @see CursosApi#coursesIdPut
     */
    default ResponseEntity<Course> coursesIdPut(UUID id,
        Course course) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"syllabus\" : [ { \"topics\" : [ { \"duration\" : 1, \"title\" : \"title\" }, { \"duration\" : 1, \"title\" : \"title\" } ], \"description\" : \"description\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"title\" : \"title\" }, { \"topics\" : [ { \"duration\" : 1, \"title\" : \"title\" }, { \"duration\" : 1, \"title\" : \"title\" } ], \"description\" : \"description\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"title\" : \"title\" } ], \"endDate\" : \"2000-01-23T04:56:07.000+00:00\", \"description\" : \"description\", \"version\" : 5, \"duration\" : 6.027456183070403, \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"deletedAt\" : \"2000-01-23T04:56:07.000+00:00\", \"instructor\" : { \"role\" : \"role\", \"avatarUrl\" : \"https://openapi-generator.tech\", \"name\" : \"name\", \"bio\" : \"bio\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" }, \"price\" : 0.8008281904610115, \"imageUrl\" : \"https://openapi-generator.tech\", \"name\" : \"name\", \"enrolledCount\" : 5, \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"category\" : \"category\", \"startDate\" : \"2000-01-23T04:56:07.000+00:00\", \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /courses/{id}/syllabus : Obtener temario del curso
     * Obtener el temario completo del curso
     *
     * @param id ID del curso (required)
     * @return Temario del curso (status code 200)
     *         or Curso no encontrado (status code 404)
     * @see CursosApi#coursesIdSyllabusGet
     */
    default ResponseEntity<List<Syllabus>> coursesIdSyllabusGet(UUID id) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"topics\" : [ { \"duration\" : 1, \"title\" : \"title\" }, { \"duration\" : 1, \"title\" : \"title\" } ], \"description\" : \"description\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"title\" : \"title\" }, { \"topics\" : [ { \"duration\" : 1, \"title\" : \"title\" }, { \"duration\" : 1, \"title\" : \"title\" } ], \"description\" : \"description\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"title\" : \"title\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /courses : Crear curso
     * Crear un nuevo curso (requiere rol TEACHER o ADMIN)
     *
     * @param course  (required)
     * @return Curso creado exitosamente (status code 201)
     *         or No autorizado (status code 403)
     * @see CursosApi#coursesPost
     */
    default ResponseEntity<Course> coursesPost(Course course) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"syllabus\" : [ { \"topics\" : [ { \"duration\" : 1, \"title\" : \"title\" }, { \"duration\" : 1, \"title\" : \"title\" } ], \"description\" : \"description\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"title\" : \"title\" }, { \"topics\" : [ { \"duration\" : 1, \"title\" : \"title\" }, { \"duration\" : 1, \"title\" : \"title\" } ], \"description\" : \"description\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"title\" : \"title\" } ], \"endDate\" : \"2000-01-23T04:56:07.000+00:00\", \"description\" : \"description\", \"version\" : 5, \"duration\" : 6.027456183070403, \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"deletedAt\" : \"2000-01-23T04:56:07.000+00:00\", \"instructor\" : { \"role\" : \"role\", \"avatarUrl\" : \"https://openapi-generator.tech\", \"name\" : \"name\", \"bio\" : \"bio\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" }, \"price\" : 0.8008281904610115, \"imageUrl\" : \"https://openapi-generator.tech\", \"name\" : \"name\", \"enrolledCount\" : 5, \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"category\" : \"category\", \"startDate\" : \"2000-01-23T04:56:07.000+00:00\", \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
