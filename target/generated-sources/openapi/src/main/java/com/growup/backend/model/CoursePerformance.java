package com.growup.backend.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.growup.backend.model.CourseStatus;
import java.math.BigDecimal;
import java.util.UUID;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * CoursePerformance
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-12T11:59:11.015804600Z[Atlantic/Canary]")
public class CoursePerformance {

  private UUID courseId;

  private String courseName;

  private Integer students;

  private BigDecimal revenue;

  private BigDecimal rating;

  private CourseStatus status;

  public CoursePerformance courseId(UUID courseId) {
    this.courseId = courseId;
    return this;
  }

  /**
   * ID del curso
   * @return courseId
  */
  @Valid 
  @Schema(name = "courseId", description = "ID del curso", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("courseId")
  public UUID getCourseId() {
    return courseId;
  }

  public void setCourseId(UUID courseId) {
    this.courseId = courseId;
  }

  public CoursePerformance courseName(String courseName) {
    this.courseName = courseName;
    return this;
  }

  /**
   * Nombre del curso
   * @return courseName
  */
  
  @Schema(name = "courseName", description = "Nombre del curso", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("courseName")
  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

  public CoursePerformance students(Integer students) {
    this.students = students;
    return this;
  }

  /**
   * Número de estudiantes
   * @return students
  */
  
  @Schema(name = "students", description = "Número de estudiantes", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("students")
  public Integer getStudents() {
    return students;
  }

  public void setStudents(Integer students) {
    this.students = students;
  }

  public CoursePerformance revenue(BigDecimal revenue) {
    this.revenue = revenue;
    return this;
  }

  /**
   * Ingresos generados
   * @return revenue
  */
  @Valid 
  @Schema(name = "revenue", description = "Ingresos generados", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("revenue")
  public BigDecimal getRevenue() {
    return revenue;
  }

  public void setRevenue(BigDecimal revenue) {
    this.revenue = revenue;
  }

  public CoursePerformance rating(BigDecimal rating) {
    this.rating = rating;
    return this;
  }

  /**
   * Calificación del curso
   * @return rating
  */
  @Valid 
  @Schema(name = "rating", description = "Calificación del curso", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("rating")
  public BigDecimal getRating() {
    return rating;
  }

  public void setRating(BigDecimal rating) {
    this.rating = rating;
  }

  public CoursePerformance status(CourseStatus status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  */
  @Valid 
  @Schema(name = "status", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("status")
  public CourseStatus getStatus() {
    return status;
  }

  public void setStatus(CourseStatus status) {
    this.status = status;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CoursePerformance coursePerformance = (CoursePerformance) o;
    return Objects.equals(this.courseId, coursePerformance.courseId) &&
        Objects.equals(this.courseName, coursePerformance.courseName) &&
        Objects.equals(this.students, coursePerformance.students) &&
        Objects.equals(this.revenue, coursePerformance.revenue) &&
        Objects.equals(this.rating, coursePerformance.rating) &&
        Objects.equals(this.status, coursePerformance.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(courseId, courseName, students, revenue, rating, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CoursePerformance {\n");
    sb.append("    courseId: ").append(toIndentedString(courseId)).append("\n");
    sb.append("    courseName: ").append(toIndentedString(courseName)).append("\n");
    sb.append("    students: ").append(toIndentedString(students)).append("\n");
    sb.append("    revenue: ").append(toIndentedString(revenue)).append("\n");
    sb.append("    rating: ").append(toIndentedString(rating)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

