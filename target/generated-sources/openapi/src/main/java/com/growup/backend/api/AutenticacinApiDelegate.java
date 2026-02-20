package com.growup.backend.api;

import com.growup.backend.model.AuthResponse;
import com.growup.backend.model.ErrorResponse;
import com.growup.backend.model.LoginRequest;
import com.growup.backend.model.RegisterRequest;
import com.growup.backend.model.UpdateUserRequest;
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
 * A delegate to be called by the {@link AutenticacinApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-20T14:24:19.066966500Z[Atlantic/Canary]")
public interface AutenticacinApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /auth/login : Iniciar sesión
     * Autenticar usuario con email y contraseña
     *
     * @param loginRequest  (required)
     * @return Inicio de sesión exitoso (status code 200)
     *         or Credenciales inválidas (status code 401)
     * @see AutenticacinApi#authLoginPost
     */
    default ResponseEntity<AuthResponse> authLoginPost(LoginRequest loginRequest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"user\" : { \"joinDate\" : \"2000-01-23T04:56:07.000+00:00\", \"name\" : \"name\", \"bio\" : \"bio\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"avatar\" : \"https://openapi-generator.tech\", \"isActive\" : true, \"version\" : 0, \"email\" : \"email\" }, \"token\" : \"token\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /auth/me : Obtener usuario actual
     * Obtener información del usuario autenticado
     *
     * @return Información del usuario actual (status code 200)
     *         or No autenticado (status code 401)
     * @see AutenticacinApi#authMeGet
     */
    default ResponseEntity<User> authMeGet() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"joinDate\" : \"2000-01-23T04:56:07.000+00:00\", \"name\" : \"name\", \"bio\" : \"bio\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"avatar\" : \"https://openapi-generator.tech\", \"isActive\" : true, \"version\" : 0, \"email\" : \"email\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /auth/me : Actualizar perfil propio
     * Actualizar nombre, bio, avatar o contraseña del usuario autenticado
     *
     * @param updateUserRequest  (required)
     * @return Perfil actualizado exitosamente (status code 200)
     *         or Datos inválidos (status code 400)
     * @see AutenticacinApi#authMePut
     */
    default ResponseEntity<User> authMePut(UpdateUserRequest updateUserRequest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"joinDate\" : \"2000-01-23T04:56:07.000+00:00\", \"name\" : \"name\", \"bio\" : \"bio\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"avatar\" : \"https://openapi-generator.tech\", \"isActive\" : true, \"version\" : 0, \"email\" : \"email\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /auth/register : Registrar nuevo usuario
     * Crear una nueva cuenta de usuario
     *
     * @param registerRequest  (required)
     * @return Usuario creado exitosamente (status code 201)
     *         or Datos inválidos o email ya registrado (status code 400)
     * @see AutenticacinApi#authRegisterPost
     */
    default ResponseEntity<AuthResponse> authRegisterPost(RegisterRequest registerRequest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"user\" : { \"joinDate\" : \"2000-01-23T04:56:07.000+00:00\", \"name\" : \"name\", \"bio\" : \"bio\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"avatar\" : \"https://openapi-generator.tech\", \"isActive\" : true, \"version\" : 0, \"email\" : \"email\" }, \"token\" : \"token\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
