package com.growup.backend.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Topic
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-20T14:24:19.066966500Z[Atlantic/Canary]")
public class Topic {

  private String title;

  private Integer duration;

  public Topic() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Topic(String title, Integer duration) {
    this.title = title;
    this.duration = duration;
  }

  public Topic title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Título del tema
   * @return title
  */
  @NotNull 
  @Schema(name = "title", description = "Título del tema", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("title")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Topic duration(Integer duration) {
    this.duration = duration;
    return this;
  }

  /**
   * Duración en minutos
   * @return duration
  */
  @NotNull 
  @Schema(name = "duration", description = "Duración en minutos", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("duration")
  public Integer getDuration() {
    return duration;
  }

  public void setDuration(Integer duration) {
    this.duration = duration;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Topic topic = (Topic) o;
    return Objects.equals(this.title, topic.title) &&
        Objects.equals(this.duration, topic.duration);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, duration);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Topic {\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
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

