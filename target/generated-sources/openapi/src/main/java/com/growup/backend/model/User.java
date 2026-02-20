package com.growup.backend.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.growup.backend.model.Role;
import java.net.URI;
import java.time.OffsetDateTime;
import java.util.UUID;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * User
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-20T14:24:19.066966500Z[Atlantic/Canary]")
public class User {

  private UUID id;

  private String name;

  private String email;

  private Boolean isActive;

  private Role role;

  private URI avatar;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime joinDate;

  private String bio;

  private Long version;

  public User() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public User(UUID id, String name, String email, Boolean isActive, Role role, Long version) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.isActive = isActive;
    this.role = role;
    this.version = version;
  }

  public User id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Identificador único del usuario
   * @return id
  */
  @NotNull @Valid 
  @Schema(name = "id", description = "Identificador único del usuario", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public User name(String name) {
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

  public User email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Correo electrónico del usuario
   * @return email
  */
  @NotNull @jakarta.validation.constraints.Email 
  @Schema(name = "email", description = "Correo electrónico del usuario", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public User isActive(Boolean isActive) {
    this.isActive = isActive;
    return this;
  }

  /**
   * Indica si el usuario está activo (Baja lógica si es false)
   * @return isActive
  */
  @NotNull 
  @Schema(name = "isActive", description = "Indica si el usuario está activo (Baja lógica si es false)", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("isActive")
  public Boolean getIsActive() {
    return isActive;
  }

  public void setIsActive(Boolean isActive) {
    this.isActive = isActive;
  }

  public User role(Role role) {
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

  public User avatar(URI avatar) {
    this.avatar = avatar;
    return this;
  }

  /**
   * URL del avatar del usuario
   * @return avatar
  */
  @Valid 
  @Schema(name = "avatar", description = "URL del avatar del usuario", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("avatar")
  public URI getAvatar() {
    return avatar;
  }

  public void setAvatar(URI avatar) {
    this.avatar = avatar;
  }

  public User joinDate(OffsetDateTime joinDate) {
    this.joinDate = joinDate;
    return this;
  }

  /**
   * Fecha de registro del usuario
   * @return joinDate
  */
  @Valid 
  @Schema(name = "joinDate", description = "Fecha de registro del usuario", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("joinDate")
  public OffsetDateTime getJoinDate() {
    return joinDate;
  }

  public void setJoinDate(OffsetDateTime joinDate) {
    this.joinDate = joinDate;
  }

  public User bio(String bio) {
    this.bio = bio;
    return this;
  }

  /**
   * Biografía del usuario (opcional)
   * @return bio
  */
  
  @Schema(name = "bio", description = "Biografía del usuario (opcional)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("bio")
  public String getBio() {
    return bio;
  }

  public void setBio(String bio) {
    this.bio = bio;
  }

  public User version(Long version) {
    this.version = version;
    return this;
  }

  /**
   * Versión de control de concurrencia
   * @return version
  */
  @NotNull 
  @Schema(name = "version", description = "Versión de control de concurrencia", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("version")
  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(this.id, user.id) &&
        Objects.equals(this.name, user.name) &&
        Objects.equals(this.email, user.email) &&
        Objects.equals(this.isActive, user.isActive) &&
        Objects.equals(this.role, user.role) &&
        Objects.equals(this.avatar, user.avatar) &&
        Objects.equals(this.joinDate, user.joinDate) &&
        Objects.equals(this.bio, user.bio) &&
        Objects.equals(this.version, user.version);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, email, isActive, role, avatar, joinDate, bio, version);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    isActive: ").append(toIndentedString(isActive)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    avatar: ").append(toIndentedString(avatar)).append("\n");
    sb.append("    joinDate: ").append(toIndentedString(joinDate)).append("\n");
    sb.append("    bio: ").append(toIndentedString(bio)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
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

