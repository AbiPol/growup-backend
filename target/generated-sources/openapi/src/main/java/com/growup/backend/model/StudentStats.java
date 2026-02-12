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
 * StudentStats
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-12T11:59:11.015804600Z[Atlantic/Canary]")
public class StudentStats {

  private Integer activeCoursesCount;

  private Integer completedCoursesCount;

  private Integer certificatesEarned;

  private BigDecimal totalHoursLearning;

  private BigDecimal averageScore;

  private Integer learningStreakDays;

  public StudentStats activeCoursesCount(Integer activeCoursesCount) {
    this.activeCoursesCount = activeCoursesCount;
    return this;
  }

  /**
   * Número de cursos activos
   * @return activeCoursesCount
  */
  
  @Schema(name = "activeCoursesCount", description = "Número de cursos activos", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("activeCoursesCount")
  public Integer getActiveCoursesCount() {
    return activeCoursesCount;
  }

  public void setActiveCoursesCount(Integer activeCoursesCount) {
    this.activeCoursesCount = activeCoursesCount;
  }

  public StudentStats completedCoursesCount(Integer completedCoursesCount) {
    this.completedCoursesCount = completedCoursesCount;
    return this;
  }

  /**
   * Número de cursos completados
   * @return completedCoursesCount
  */
  
  @Schema(name = "completedCoursesCount", description = "Número de cursos completados", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("completedCoursesCount")
  public Integer getCompletedCoursesCount() {
    return completedCoursesCount;
  }

  public void setCompletedCoursesCount(Integer completedCoursesCount) {
    this.completedCoursesCount = completedCoursesCount;
  }

  public StudentStats certificatesEarned(Integer certificatesEarned) {
    this.certificatesEarned = certificatesEarned;
    return this;
  }

  /**
   * Número de certificados obtenidos
   * @return certificatesEarned
  */
  
  @Schema(name = "certificatesEarned", description = "Número de certificados obtenidos", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("certificatesEarned")
  public Integer getCertificatesEarned() {
    return certificatesEarned;
  }

  public void setCertificatesEarned(Integer certificatesEarned) {
    this.certificatesEarned = certificatesEarned;
  }

  public StudentStats totalHoursLearning(BigDecimal totalHoursLearning) {
    this.totalHoursLearning = totalHoursLearning;
    return this;
  }

  /**
   * Total de horas de aprendizaje
   * @return totalHoursLearning
  */
  @Valid 
  @Schema(name = "totalHoursLearning", description = "Total de horas de aprendizaje", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("totalHoursLearning")
  public BigDecimal getTotalHoursLearning() {
    return totalHoursLearning;
  }

  public void setTotalHoursLearning(BigDecimal totalHoursLearning) {
    this.totalHoursLearning = totalHoursLearning;
  }

  public StudentStats averageScore(BigDecimal averageScore) {
    this.averageScore = averageScore;
    return this;
  }

  /**
   * Puntuación promedio
   * minimum: 0
   * maximum: 100
   * @return averageScore
  */
  @Valid @DecimalMin("0") @DecimalMax("100") 
  @Schema(name = "averageScore", description = "Puntuación promedio", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("averageScore")
  public BigDecimal getAverageScore() {
    return averageScore;
  }

  public void setAverageScore(BigDecimal averageScore) {
    this.averageScore = averageScore;
  }

  public StudentStats learningStreakDays(Integer learningStreakDays) {
    this.learningStreakDays = learningStreakDays;
    return this;
  }

  /**
   * Días consecutivos de aprendizaje
   * @return learningStreakDays
  */
  
  @Schema(name = "learningStreakDays", description = "Días consecutivos de aprendizaje", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("learningStreakDays")
  public Integer getLearningStreakDays() {
    return learningStreakDays;
  }

  public void setLearningStreakDays(Integer learningStreakDays) {
    this.learningStreakDays = learningStreakDays;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StudentStats studentStats = (StudentStats) o;
    return Objects.equals(this.activeCoursesCount, studentStats.activeCoursesCount) &&
        Objects.equals(this.completedCoursesCount, studentStats.completedCoursesCount) &&
        Objects.equals(this.certificatesEarned, studentStats.certificatesEarned) &&
        Objects.equals(this.totalHoursLearning, studentStats.totalHoursLearning) &&
        Objects.equals(this.averageScore, studentStats.averageScore) &&
        Objects.equals(this.learningStreakDays, studentStats.learningStreakDays);
  }

  @Override
  public int hashCode() {
    return Objects.hash(activeCoursesCount, completedCoursesCount, certificatesEarned, totalHoursLearning, averageScore, learningStreakDays);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StudentStats {\n");
    sb.append("    activeCoursesCount: ").append(toIndentedString(activeCoursesCount)).append("\n");
    sb.append("    completedCoursesCount: ").append(toIndentedString(completedCoursesCount)).append("\n");
    sb.append("    certificatesEarned: ").append(toIndentedString(certificatesEarned)).append("\n");
    sb.append("    totalHoursLearning: ").append(toIndentedString(totalHoursLearning)).append("\n");
    sb.append("    averageScore: ").append(toIndentedString(averageScore)).append("\n");
    sb.append("    learningStreakDays: ").append(toIndentedString(learningStreakDays)).append("\n");
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

