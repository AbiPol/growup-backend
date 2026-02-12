package com.growup.backend.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.growup.backend.model.NotificationType;
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
 * Notification
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-12T11:59:11.015804600Z[Atlantic/Canary]")
public class Notification {

  private UUID id;

  private UUID userId;

  private String title;

  private String message;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime date;

  private Boolean read;

  private NotificationType type;

  private URI link;

  public Notification() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Notification(UUID id, UUID userId, String title, String message, OffsetDateTime date, Boolean read, NotificationType type) {
    this.id = id;
    this.userId = userId;
    this.title = title;
    this.message = message;
    this.date = date;
    this.read = read;
    this.type = type;
  }

  public Notification id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Identificador único de la notificación
   * @return id
  */
  @NotNull @Valid 
  @Schema(name = "id", description = "Identificador único de la notificación", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Notification userId(UUID userId) {
    this.userId = userId;
    return this;
  }

  /**
   * ID del usuario destinatario
   * @return userId
  */
  @NotNull @Valid 
  @Schema(name = "userId", description = "ID del usuario destinatario", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("userId")
  public UUID getUserId() {
    return userId;
  }

  public void setUserId(UUID userId) {
    this.userId = userId;
  }

  public Notification title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Título de la notificación
   * @return title
  */
  @NotNull 
  @Schema(name = "title", description = "Título de la notificación", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("title")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Notification message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Mensaje de la notificación
   * @return message
  */
  @NotNull 
  @Schema(name = "message", description = "Mensaje de la notificación", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("message")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Notification date(OffsetDateTime date) {
    this.date = date;
    return this;
  }

  /**
   * Fecha de la notificación
   * @return date
  */
  @NotNull @Valid 
  @Schema(name = "date", description = "Fecha de la notificación", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("date")
  public OffsetDateTime getDate() {
    return date;
  }

  public void setDate(OffsetDateTime date) {
    this.date = date;
  }

  public Notification read(Boolean read) {
    this.read = read;
    return this;
  }

  /**
   * Indica si la notificación ha sido leída
   * @return read
  */
  @NotNull 
  @Schema(name = "read", description = "Indica si la notificación ha sido leída", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("read")
  public Boolean getRead() {
    return read;
  }

  public void setRead(Boolean read) {
    this.read = read;
  }

  public Notification type(NotificationType type) {
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
  public NotificationType getType() {
    return type;
  }

  public void setType(NotificationType type) {
    this.type = type;
  }

  public Notification link(URI link) {
    this.link = link;
    return this;
  }

  /**
   * Enlace opcional a un recurso relacionado
   * @return link
  */
  @Valid 
  @Schema(name = "link", description = "Enlace opcional a un recurso relacionado", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("link")
  public URI getLink() {
    return link;
  }

  public void setLink(URI link) {
    this.link = link;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Notification notification = (Notification) o;
    return Objects.equals(this.id, notification.id) &&
        Objects.equals(this.userId, notification.userId) &&
        Objects.equals(this.title, notification.title) &&
        Objects.equals(this.message, notification.message) &&
        Objects.equals(this.date, notification.date) &&
        Objects.equals(this.read, notification.read) &&
        Objects.equals(this.type, notification.type) &&
        Objects.equals(this.link, notification.link);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, userId, title, message, date, read, type, link);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Notification {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    read: ").append(toIndentedString(read)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    link: ").append(toIndentedString(link)).append("\n");
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

