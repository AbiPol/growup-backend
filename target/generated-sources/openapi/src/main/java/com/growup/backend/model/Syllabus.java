package com.growup.backend.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.growup.backend.model.Topic;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Syllabus
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-20T14:24:19.066966500Z[Atlantic/Canary]")
public class Syllabus {

  private UUID id;

  private String title;

  private String description;

  @Valid
  private List<@Valid Topic> topics = new ArrayList<>();

  public Syllabus() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Syllabus(String title, String description, List<@Valid Topic> topics) {
    this.title = title;
    this.description = description;
    this.topics = topics;
  }

  public Syllabus id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Identificador único del módulo
   * @return id
  */
  @Valid 
  @Schema(name = "id", description = "Identificador único del módulo", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Syllabus title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Título del módulo
   * @return title
  */
  @NotNull 
  @Schema(name = "title", description = "Título del módulo", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("title")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Syllabus description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Descripción del módulo
   * @return description
  */
  @NotNull 
  @Schema(name = "description", description = "Descripción del módulo", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Syllabus topics(List<@Valid Topic> topics) {
    this.topics = topics;
    return this;
  }

  public Syllabus addTopicsItem(Topic topicsItem) {
    if (this.topics == null) {
      this.topics = new ArrayList<>();
    }
    this.topics.add(topicsItem);
    return this;
  }

  /**
   * Lista de temas del módulo
   * @return topics
  */
  @NotNull @Valid 
  @Schema(name = "topics", description = "Lista de temas del módulo", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("topics")
  public List<@Valid Topic> getTopics() {
    return topics;
  }

  public void setTopics(List<@Valid Topic> topics) {
    this.topics = topics;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Syllabus syllabus = (Syllabus) o;
    return Objects.equals(this.id, syllabus.id) &&
        Objects.equals(this.title, syllabus.title) &&
        Objects.equals(this.description, syllabus.description) &&
        Objects.equals(this.topics, syllabus.topics);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, description, topics);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Syllabus {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    topics: ").append(toIndentedString(topics)).append("\n");
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

