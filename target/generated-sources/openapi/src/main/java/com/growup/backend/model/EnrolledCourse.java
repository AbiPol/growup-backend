package com.growup.backend.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.growup.backend.model.CourseLevel;
import com.growup.backend.model.CourseStatus;
import com.growup.backend.model.EnrollmentStatus;
import com.growup.backend.model.Instructor;
import com.growup.backend.model.Syllabus;
import java.math.BigDecimal;
import java.net.URI;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.openapitools.jackson.nullable.JsonNullable;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.NoSuchElementException;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * EnrolledCourse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-20T14:24:19.066966500Z[Atlantic/Canary]")
public class EnrolledCourse {

  private UUID id;

  private String name;

  private String description;

  private URI imageUrl;

  private String category;

  private CourseLevel level;

  private Double price;

  private BigDecimal duration;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime startDate;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime endDate;

  private CourseStatus publicationStatus;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime createdAt;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime updatedAt;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private JsonNullable<OffsetDateTime> deletedAt = JsonNullable.<OffsetDateTime>undefined();

  private Instructor instructor;

  @Valid
  private List<@Valid Syllabus> syllabus;

  private Integer enrolledCount;

  private Long version;

  private Integer progress;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime lastAccessDate;

  private EnrollmentStatus enrollmentStatus;

  private UUID nextLessonId;

  public EnrolledCourse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public EnrolledCourse(UUID id, String name, String category, Double price, CourseStatus publicationStatus, Long version) {
    this.id = id;
    this.name = name;
    this.category = category;
    this.price = price;
    this.publicationStatus = publicationStatus;
    this.version = version;
  }

  public EnrolledCourse id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Identificador único del curso
   * @return id
  */
  @NotNull @Valid 
  @Schema(name = "id", description = "Identificador único del curso", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public EnrolledCourse name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Nombre del curso
   * @return name
  */
  @NotNull 
  @Schema(name = "name", description = "Nombre del curso", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public EnrolledCourse description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Descripción del curso
   * @return description
  */
  
  @Schema(name = "description", description = "Descripción del curso", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public EnrolledCourse imageUrl(URI imageUrl) {
    this.imageUrl = imageUrl;
    return this;
  }

  /**
   * URL de la imagen del curso
   * @return imageUrl
  */
  @Valid 
  @Schema(name = "imageUrl", description = "URL de la imagen del curso", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("imageUrl")
  public URI getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(URI imageUrl) {
    this.imageUrl = imageUrl;
  }

  public EnrolledCourse category(String category) {
    this.category = category;
    return this;
  }

  /**
   * Categoría del curso (ej. DISEÑO WEB, DESARROLLO, ARQUITECTURA, MARKETING)
   * @return category
  */
  @NotNull 
  @Schema(name = "category", description = "Categoría del curso (ej. DISEÑO WEB, DESARROLLO, ARQUITECTURA, MARKETING)", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("category")
  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public EnrolledCourse level(CourseLevel level) {
    this.level = level;
    return this;
  }

  /**
   * Get level
   * @return level
  */
  @Valid 
  @Schema(name = "level", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("level")
  public CourseLevel getLevel() {
    return level;
  }

  public void setLevel(CourseLevel level) {
    this.level = level;
  }

  public EnrolledCourse price(Double price) {
    this.price = price;
    return this;
  }

  /**
   * Precio del curso
   * @return price
  */
  @NotNull 
  @Schema(name = "price", description = "Precio del curso", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("price")
  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public EnrolledCourse duration(BigDecimal duration) {
    this.duration = duration;
    return this;
  }

  /**
   * Duración total en horas
   * @return duration
  */
  @Valid 
  @Schema(name = "duration", description = "Duración total en horas", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("duration")
  public BigDecimal getDuration() {
    return duration;
  }

  public void setDuration(BigDecimal duration) {
    this.duration = duration;
  }

  public EnrolledCourse startDate(OffsetDateTime startDate) {
    this.startDate = startDate;
    return this;
  }

  /**
   * Fecha de inicio del curso
   * @return startDate
  */
  @Valid 
  @Schema(name = "startDate", description = "Fecha de inicio del curso", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("startDate")
  public OffsetDateTime getStartDate() {
    return startDate;
  }

  public void setStartDate(OffsetDateTime startDate) {
    this.startDate = startDate;
  }

  public EnrolledCourse endDate(OffsetDateTime endDate) {
    this.endDate = endDate;
    return this;
  }

  /**
   * Fecha de finalización del curso
   * @return endDate
  */
  @Valid 
  @Schema(name = "endDate", description = "Fecha de finalización del curso", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("endDate")
  public OffsetDateTime getEndDate() {
    return endDate;
  }

  public void setEndDate(OffsetDateTime endDate) {
    this.endDate = endDate;
  }

  public EnrolledCourse publicationStatus(CourseStatus publicationStatus) {
    this.publicationStatus = publicationStatus;
    return this;
  }

  /**
   * Get publicationStatus
   * @return publicationStatus
  */
  @NotNull @Valid 
  @Schema(name = "publicationStatus", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("publicationStatus")
  public CourseStatus getPublicationStatus() {
    return publicationStatus;
  }

  public void setPublicationStatus(CourseStatus publicationStatus) {
    this.publicationStatus = publicationStatus;
  }

  public EnrolledCourse createdAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  /**
   * Fecha de creación del curso
   * @return createdAt
  */
  @Valid 
  @Schema(name = "createdAt", description = "Fecha de creación del curso", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("createdAt")
  public OffsetDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public EnrolledCourse updatedAt(OffsetDateTime updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

  /**
   * Fecha de última actualización
   * @return updatedAt
  */
  @Valid 
  @Schema(name = "updatedAt", description = "Fecha de última actualización", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("updatedAt")
  public OffsetDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(OffsetDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  public EnrolledCourse deletedAt(OffsetDateTime deletedAt) {
    this.deletedAt = JsonNullable.of(deletedAt);
    return this;
  }

  /**
   * Fecha de eliminación (soft delete)
   * @return deletedAt
  */
  @Valid 
  @Schema(name = "deletedAt", description = "Fecha de eliminación (soft delete)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("deletedAt")
  public JsonNullable<OffsetDateTime> getDeletedAt() {
    return deletedAt;
  }

  public void setDeletedAt(JsonNullable<OffsetDateTime> deletedAt) {
    this.deletedAt = deletedAt;
  }

  public EnrolledCourse instructor(Instructor instructor) {
    this.instructor = instructor;
    return this;
  }

  /**
   * Get instructor
   * @return instructor
  */
  @Valid 
  @Schema(name = "instructor", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("instructor")
  public Instructor getInstructor() {
    return instructor;
  }

  public void setInstructor(Instructor instructor) {
    this.instructor = instructor;
  }

  public EnrolledCourse syllabus(List<@Valid Syllabus> syllabus) {
    this.syllabus = syllabus;
    return this;
  }

  public EnrolledCourse addSyllabusItem(Syllabus syllabusItem) {
    if (this.syllabus == null) {
      this.syllabus = new ArrayList<>();
    }
    this.syllabus.add(syllabusItem);
    return this;
  }

  /**
   * Temario del curso
   * @return syllabus
  */
  @Valid 
  @Schema(name = "syllabus", description = "Temario del curso", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("syllabus")
  public List<@Valid Syllabus> getSyllabus() {
    return syllabus;
  }

  public void setSyllabus(List<@Valid Syllabus> syllabus) {
    this.syllabus = syllabus;
  }

  public EnrolledCourse enrolledCount(Integer enrolledCount) {
    this.enrolledCount = enrolledCount;
    return this;
  }

  /**
   * Número de estudiantes inscritos
   * @return enrolledCount
  */
  
  @Schema(name = "enrolledCount", description = "Número de estudiantes inscritos", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("enrolledCount")
  public Integer getEnrolledCount() {
    return enrolledCount;
  }

  public void setEnrolledCount(Integer enrolledCount) {
    this.enrolledCount = enrolledCount;
  }

  public EnrolledCourse version(Long version) {
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

  public EnrolledCourse progress(Integer progress) {
    this.progress = progress;
    return this;
  }

  /**
   * Porcentaje de progreso del estudiante
   * minimum: 0
   * maximum: 100
   * @return progress
  */
  @Min(0) @Max(100) 
  @Schema(name = "progress", description = "Porcentaje de progreso del estudiante", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("progress")
  public Integer getProgress() {
    return progress;
  }

  public void setProgress(Integer progress) {
    this.progress = progress;
  }

  public EnrolledCourse lastAccessDate(OffsetDateTime lastAccessDate) {
    this.lastAccessDate = lastAccessDate;
    return this;
  }

  /**
   * Fecha del último acceso al curso
   * @return lastAccessDate
  */
  @Valid 
  @Schema(name = "lastAccessDate", description = "Fecha del último acceso al curso", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("lastAccessDate")
  public OffsetDateTime getLastAccessDate() {
    return lastAccessDate;
  }

  public void setLastAccessDate(OffsetDateTime lastAccessDate) {
    this.lastAccessDate = lastAccessDate;
  }

  public EnrolledCourse enrollmentStatus(EnrollmentStatus enrollmentStatus) {
    this.enrollmentStatus = enrollmentStatus;
    return this;
  }

  /**
   * Get enrollmentStatus
   * @return enrollmentStatus
  */
  @Valid 
  @Schema(name = "enrollmentStatus", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("enrollmentStatus")
  public EnrollmentStatus getEnrollmentStatus() {
    return enrollmentStatus;
  }

  public void setEnrollmentStatus(EnrollmentStatus enrollmentStatus) {
    this.enrollmentStatus = enrollmentStatus;
  }

  public EnrolledCourse nextLessonId(UUID nextLessonId) {
    this.nextLessonId = nextLessonId;
    return this;
  }

  /**
   * ID de la siguiente lección
   * @return nextLessonId
  */
  @Valid 
  @Schema(name = "nextLessonId", description = "ID de la siguiente lección", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("nextLessonId")
  public UUID getNextLessonId() {
    return nextLessonId;
  }

  public void setNextLessonId(UUID nextLessonId) {
    this.nextLessonId = nextLessonId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EnrolledCourse enrolledCourse = (EnrolledCourse) o;
    return Objects.equals(this.id, enrolledCourse.id) &&
        Objects.equals(this.name, enrolledCourse.name) &&
        Objects.equals(this.description, enrolledCourse.description) &&
        Objects.equals(this.imageUrl, enrolledCourse.imageUrl) &&
        Objects.equals(this.category, enrolledCourse.category) &&
        Objects.equals(this.level, enrolledCourse.level) &&
        Objects.equals(this.price, enrolledCourse.price) &&
        Objects.equals(this.duration, enrolledCourse.duration) &&
        Objects.equals(this.startDate, enrolledCourse.startDate) &&
        Objects.equals(this.endDate, enrolledCourse.endDate) &&
        Objects.equals(this.publicationStatus, enrolledCourse.publicationStatus) &&
        Objects.equals(this.createdAt, enrolledCourse.createdAt) &&
        Objects.equals(this.updatedAt, enrolledCourse.updatedAt) &&
        equalsNullable(this.deletedAt, enrolledCourse.deletedAt) &&
        Objects.equals(this.instructor, enrolledCourse.instructor) &&
        Objects.equals(this.syllabus, enrolledCourse.syllabus) &&
        Objects.equals(this.enrolledCount, enrolledCourse.enrolledCount) &&
        Objects.equals(this.version, enrolledCourse.version) &&
        Objects.equals(this.progress, enrolledCourse.progress) &&
        Objects.equals(this.lastAccessDate, enrolledCourse.lastAccessDate) &&
        Objects.equals(this.enrollmentStatus, enrolledCourse.enrollmentStatus) &&
        Objects.equals(this.nextLessonId, enrolledCourse.nextLessonId);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, description, imageUrl, category, level, price, duration, startDate, endDate, publicationStatus, createdAt, updatedAt, hashCodeNullable(deletedAt), instructor, syllabus, enrolledCount, version, progress, lastAccessDate, enrollmentStatus, nextLessonId);
  }

  private static <T> int hashCodeNullable(JsonNullable<T> a) {
    if (a == null) {
      return 1;
    }
    return a.isPresent() ? Arrays.deepHashCode(new Object[]{a.get()}) : 31;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EnrolledCourse {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    imageUrl: ").append(toIndentedString(imageUrl)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    level: ").append(toIndentedString(level)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    publicationStatus: ").append(toIndentedString(publicationStatus)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
    sb.append("    deletedAt: ").append(toIndentedString(deletedAt)).append("\n");
    sb.append("    instructor: ").append(toIndentedString(instructor)).append("\n");
    sb.append("    syllabus: ").append(toIndentedString(syllabus)).append("\n");
    sb.append("    enrolledCount: ").append(toIndentedString(enrolledCount)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    progress: ").append(toIndentedString(progress)).append("\n");
    sb.append("    lastAccessDate: ").append(toIndentedString(lastAccessDate)).append("\n");
    sb.append("    enrollmentStatus: ").append(toIndentedString(enrollmentStatus)).append("\n");
    sb.append("    nextLessonId: ").append(toIndentedString(nextLessonId)).append("\n");
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

