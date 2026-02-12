package com.growup.backend.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.net.URI;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * UpdateUserRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-12T11:59:11.015804600Z[Atlantic/Canary]")
public class UpdateUserRequest {

  private String name;

  private String email;

  private URI avatar;

  private String bio;

  private String password;

  public UpdateUserRequest name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Nombre completo del usuario
   * @return name
  */
  
  @Schema(name = "name", description = "Nombre completo del usuario", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public UpdateUserRequest email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Correo electrónico
   * @return email
  */
  @jakarta.validation.constraints.Email 
  @Schema(name = "email", description = "Correo electrónico", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public UpdateUserRequest avatar(URI avatar) {
    this.avatar = avatar;
    return this;
  }

  /**
   * URL del avatar
   * @return avatar
  */
  @Valid 
  @Schema(name = "avatar", description = "URL del avatar", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("avatar")
  public URI getAvatar() {
    return avatar;
  }

  public void setAvatar(URI avatar) {
    this.avatar = avatar;
  }

  public UpdateUserRequest bio(String bio) {
    this.bio = bio;
    return this;
  }

  /**
   * Biografía (opcional, para profesores)
   * @return bio
  */
  
  @Schema(name = "bio", description = "Biografía (opcional, para profesores)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("bio")
  public String getBio() {
    return bio;
  }

  public void setBio(String bio) {
    this.bio = bio;
  }

  public UpdateUserRequest password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Nueva contraseña (opcional)
   * @return password
  */
  
  @Schema(name = "password", description = "Nueva contraseña (opcional)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("password")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateUserRequest updateUserRequest = (UpdateUserRequest) o;
    return Objects.equals(this.name, updateUserRequest.name) &&
        Objects.equals(this.email, updateUserRequest.email) &&
        Objects.equals(this.avatar, updateUserRequest.avatar) &&
        Objects.equals(this.bio, updateUserRequest.bio) &&
        Objects.equals(this.password, updateUserRequest.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, email, avatar, bio, password);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateUserRequest {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    avatar: ").append(toIndentedString(avatar)).append("\n");
    sb.append("    bio: ").append(toIndentedString(bio)).append("\n");
    sb.append("    password: ").append("*").append("\n");
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

