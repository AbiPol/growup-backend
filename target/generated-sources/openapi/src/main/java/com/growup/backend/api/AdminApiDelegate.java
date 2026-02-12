package com.growup.backend.api;

import com.growup.backend.model.AdminUsersIdStatusPatchRequest;
import com.growup.backend.model.ErrorResponse;
import com.growup.backend.model.Role;
import java.util.UUID;
import com.growup.backend.model.User;
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
 * A delegate to be called by the {@link AdminApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-12T11:59:11.015804600Z[Atlantic/Canary]")
public interface AdminApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /admin/users : Listar todos los usuarios
     * Obtener lista paginada de usuarios (Solo ADMIN)
     *
     * @param role Filtrar por rol (optional)
     * @param isActive Filtrar por estado (activo/inactivo) (optional)
     * @return Lista de usuarios (status code 200)
     *         or No autorizado (requiere rol ADMIN) (status code 403)
     * @see AdminApi#adminUsersGet
     */
    default ResponseEntity<List<User>> adminUsersGet(Role role,
        Boolean isActive) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"joinDate\" : \"2000-01-23T04:56:07.000+00:00\", \"name\" : \"name\", \"bio\" : \"bio\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"avatar\" : \"https://openapi-generator.tech\", \"isActive\" : true, \"email\" : \"email\" }, { \"joinDate\" : \"2000-01-23T04:56:07.000+00:00\", \"name\" : \"name\", \"bio\" : \"bio\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"avatar\" : \"https://openapi-generator.tech\", \"isActive\" : true, \"email\" : \"email\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /admin/users/{id} : Obtener detalles de usuario (Admin)
     * Obtener información completa de cualquier usuario por ID
     *
     * @param id ID del usuario (required)
     * @return Detalles del usuario (status code 200)
     * @see AdminApi#adminUsersIdGet
     */
    default ResponseEntity<User> adminUsersIdGet(UUID id) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"joinDate\" : \"2000-01-23T04:56:07.000+00:00\", \"name\" : \"name\", \"bio\" : \"bio\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"avatar\" : \"https://openapi-generator.tech\", \"isActive\" : true, \"email\" : \"email\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /admin/users/{id} : Modificar usuario (Admin)
     * Modificar datos de cualquier usuario (incluyendo rol)
     *
     * @param id ID del usuario (required)
     * @param user  (required)
     * @return Usuario modificado exitosamente (status code 200)
     * @see AdminApi#adminUsersIdPut
     */
    default ResponseEntity<User> adminUsersIdPut(UUID id,
        User user) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"joinDate\" : \"2000-01-23T04:56:07.000+00:00\", \"name\" : \"name\", \"bio\" : \"bio\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"avatar\" : \"https://openapi-generator.tech\", \"isActive\" : true, \"email\" : \"email\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PATCH /admin/users/{id}/status : Cambiar estado de usuario (Alta/Baja Lógica)
     * Activar o desactivar un usuario sin eliminarlo de la base de datos
     *
     * @param id ID del usuario (required)
     * @param adminUsersIdStatusPatchRequest  (required)
     * @return Estado del usuario actualizado (status code 200)
     *         or Usuario no encontrado (status code 404)
     * @see AdminApi#adminUsersIdStatusPatch
     */
    default ResponseEntity<User> adminUsersIdStatusPatch(UUID id,
        AdminUsersIdStatusPatchRequest adminUsersIdStatusPatchRequest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"joinDate\" : \"2000-01-23T04:56:07.000+00:00\", \"name\" : \"name\", \"bio\" : \"bio\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"avatar\" : \"https://openapi-generator.tech\", \"isActive\" : true, \"email\" : \"email\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
