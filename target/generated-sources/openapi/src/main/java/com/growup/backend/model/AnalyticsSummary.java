package com.growup.backend.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.math.BigDecimal;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * AnalyticsSummary
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-12T11:59:11.015804600Z[Atlantic/Canary]")
public class AnalyticsSummary {

  private BigDecimal totalRevenue;

  private Integer totalStudents;

  private BigDecimal averageRating;

  private Integer activeCourses;

  public AnalyticsSummary totalRevenue(BigDecimal totalRevenue) {
    this.totalRevenue = totalRevenue;
    return this;
  }

  /**
   * Ingresos totales
   * @return totalRevenue
  */
  @Valid 
  @Schema(name = "totalRevenue", description = "Ingresos totales", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("totalRevenue")
  public BigDecimal getTotalRevenue() {
    return totalRevenue;
  }

  public void setTotalRevenue(BigDecimal totalRevenue) {
    this.totalRevenue = totalRevenue;
  }

  public AnalyticsSummary totalStudents(Integer totalStudents) {
    this.totalStudents = totalStudents;
    return this;
  }

  /**
   * Total de estudiantes
   * @return totalStudents
  */
  
  @Schema(name = "totalStudents", description = "Total de estudiantes", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("totalStudents")
  public Integer getTotalStudents() {
    return totalStudents;
  }

  public void setTotalStudents(Integer totalStudents) {
    this.totalStudents = totalStudents;
  }

  public AnalyticsSummary averageRating(BigDecimal averageRating) {
    this.averageRating = averageRating;
    return this;
  }

  /**
   * Calificación promedio
   * @return averageRating
  */
  @Valid 
  @Schema(name = "averageRating", description = "Calificación promedio", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("averageRating")
  public BigDecimal getAverageRating() {
    return averageRating;
  }

  public void setAverageRating(BigDecimal averageRating) {
    this.averageRating = averageRating;
  }

  public AnalyticsSummary activeCourses(Integer activeCourses) {
    this.activeCourses = activeCourses;
    return this;
  }

  /**
   * Cursos activos
   * @return activeCourses
  */
  
  @Schema(name = "activeCourses", description = "Cursos activos", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("activeCourses")
  public Integer getActiveCourses() {
    return activeCourses;
  }

  public void setActiveCourses(Integer activeCourses) {
    this.activeCourses = activeCourses;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AnalyticsSummary analyticsSummary = (AnalyticsSummary) o;
    return Objects.equals(this.totalRevenue, analyticsSummary.totalRevenue) &&
        Objects.equals(this.totalStudents, analyticsSummary.totalStudents) &&
        Objects.equals(this.averageRating, analyticsSummary.averageRating) &&
        Objects.equals(this.activeCourses, analyticsSummary.activeCourses);
  }

  @Override
  public int hashCode() {
    return Objects.hash(totalRevenue, totalStudents, averageRating, activeCourses);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AnalyticsSummary {\n");
    sb.append("    totalRevenue: ").append(toIndentedString(totalRevenue)).append("\n");
    sb.append("    totalStudents: ").append(toIndentedString(totalStudents)).append("\n");
    sb.append("    averageRating: ").append(toIndentedString(averageRating)).append("\n");
    sb.append("    activeCourses: ").append(toIndentedString(activeCourses)).append("\n");
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

