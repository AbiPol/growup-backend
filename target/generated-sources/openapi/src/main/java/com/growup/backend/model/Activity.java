package com.growup.backend.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.growup.backend.model.ActivityType;
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
 * Activity
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-20T14:24:19.066966500Z[Atlantic/Canary]")
public class Activity {

  private UUID id;

  private String user;

  private String action;

  private String target;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime time;

  private ActivityType type;

  public Activity() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Activity(UUID id, String user, String action, String target, OffsetDateTime time, ActivityType type) {
    this.id = id;
    this.user = user;
    this.action = action;
    this.target = target;
    this.time = time;
    this.type = type;
  }

  public Activity id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Identificador de la actividad
   * @return id
  */
  @NotNull @Valid 
  @Schema(name = "id", description = "Identificador de la actividad", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Activity user(String user) {
    this.user = user;
    return this;
  }

  /**
   * Usuario que realizó la actividad
   * @return user
  */
  @NotNull 
  @Schema(name = "user", description = "Usuario que realizó la actividad", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("user")
  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public Activity action(String action) {
    this.action = action;
    return this;
  }

  /**
   * Descripción de la acción
   * @return action
  */
  @NotNull 
  @Schema(name = "action", description = "Descripción de la acción", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("action")
  public String getAction() {
    return action;
  }

  public void setAction(String action) {
    this.action = action;
  }

  public Activity target(String target) {
    this.target = target;
    return this;
  }

  /**
   * Objetivo de la acción
   * @return target
  */
  @NotNull 
  @Schema(name = "target", description = "Objetivo de la acción", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("target")
  public String getTarget() {
    return target;
  }

  public void setTarget(String target) {
    this.target = target;
  }

  public Activity time(OffsetDateTime time) {
    this.time = time;
    return this;
  }

  /**
   * Momento de la actividad
   * @return time
  */
  @NotNull @Valid 
  @Schema(name = "time", description = "Momento de la actividad", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("time")
  public OffsetDateTime getTime() {
    return time;
  }

  public void setTime(OffsetDateTime time) {
    this.time = time;
  }

  public Activity type(ActivityType type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
  */
  @NotNull @Valid 
  @Schema(name = "type", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("type")
  public ActivityType getType() {
    return type;
  }

  public void setType(ActivityType type) {
    this.type = type;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Activity activity = (Activity) o;
    return Objects.equals(this.id, activity.id) &&
        Objects.equals(this.user, activity.user) &&
        Objects.equals(this.action, activity.action) &&
        Objects.equals(this.target, activity.target) &&
        Objects.equals(this.time, activity.time) &&
        Objects.equals(this.type, activity.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, user, action, target, time, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Activity {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
    sb.append("    action: ").append(toIndentedString(action)).append("\n");
    sb.append("    target: ").append(toIndentedString(target)).append("\n");
    sb.append("    time: ").append(toIndentedString(time)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

