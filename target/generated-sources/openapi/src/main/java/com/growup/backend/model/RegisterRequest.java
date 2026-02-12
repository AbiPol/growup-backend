package com.growup.backend.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.growup.backend.model.Role;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * RegisterRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-12T11:59:11.015804600Z[Atlantic/Canary]")
public class RegisterRequest {

  private String name;

  private String email;

  private String password;

  private Role role;

  public RegisterRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public RegisterRequest(String name, String email, String password, Role role) {
    this.name = name;
    this.email = email;
    this.password = password;
    this.role = role;
  }

  public RegisterRequest name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Nombre completo del usuario
   * @return name
  */
  @NotNull 
  @Schema(name = "name", description = "Nombre completo del usuario", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public RegisterRequest email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Correo electrónico
   * @return email
  */
  @NotNull @jakarta.validation.constraints.Email 
  @Schema(name = "email", description = "Correo electrónico", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public RegisterRequest password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Contraseña
   * @return password
  */
  @NotNull 
  @Schema(name = "password", description = "Contraseña", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("password")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public RegisterRequest role(Role role) {
    this.role = role;
    return this;
  }

  /**
   * Get role
   * @return role
  */
  @NotNull @Valid 
  @Schema(name = "role", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("role")
  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RegisterRequest registerRequest = (RegisterRequest) o;
    return Objects.equals(this.name, registerRequest.name) &&
        Objects.equals(this.email, registerRequest.email) &&
        Objects.equals(this.password, registerRequest.password) &&
        Objects.equals(this.role, registerRequest.role);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, email, password, role);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RegisterRequest {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    password: ").append("*").append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

