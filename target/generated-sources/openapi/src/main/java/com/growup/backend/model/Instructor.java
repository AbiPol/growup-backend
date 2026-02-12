package com.growup.backend.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.net.URI;
import java.util.UUID;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Instructor
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-12T11:59:11.015804600Z[Atlantic/Canary]")
public class Instructor {

  private UUID id;

  private String name;

  private String role;

  private URI avatarUrl;

  private String bio;

  public Instructor() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Instructor(UUID id, String name, String role) {
    this.id = id;
    this.name = name;
    this.role = role;
  }

  public Instructor id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Identificador único del instructor
   * @return id
  */
  @NotNull @Valid 
  @Schema(name = "id", description = "Identificador único del instructor", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Instructor name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Nombre completo del instructor
   * @return name
  */
  @NotNull 
  @Schema(name = "name", description = "Nombre completo del instructor", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Instructor role(String role) {
    this.role = role;
    return this;
  }

  /**
   * Rol o título del instructor
   * @return role
  */
  @NotNull 
  @Schema(name = "role", description = "Rol o título del instructor", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("role")
  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public Instructor avatarUrl(URI avatarUrl) {
    this.avatarUrl = avatarUrl;
    return this;
  }

  /**
   * URL del avatar del instructor
   * @return avatarUrl
  */
  @Valid 
  @Schema(name = "avatarUrl", description = "URL del avatar del instructor", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("avatarUrl")
  public URI getAvatarUrl() {
    return avatarUrl;
  }

  public void setAvatarUrl(URI avatarUrl) {
    this.avatarUrl = avatarUrl;
  }

  public Instructor bio(String bio) {
    this.bio = bio;
    return this;
  }

  /**
   * Biografía del instructor
   * @return bio
  */
  
  @Schema(name = "bio", description = "Biografía del instructor", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("bio")
  public String getBio() {
    return bio;
  }

  public void setBio(String bio) {
    this.bio = bio;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Instructor instructor = (Instructor) o;
    return Objects.equals(this.id, instructor.id) &&
        Objects.equals(this.name, instructor.name) &&
        Objects.equals(this.role, instructor.role) &&
        Objects.equals(this.avatarUrl, instructor.avatarUrl) &&
        Objects.equals(this.bio, instructor.bio);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, role, avatarUrl, bio);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Instructor {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    avatarUrl: ").append(toIndentedString(avatarUrl)).append("\n");
    sb.append("    bio: ").append(toIndentedString(bio)).append("\n");
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

