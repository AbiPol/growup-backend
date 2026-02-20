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
 * DashboardStats
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-20T14:24:19.066966500Z[Atlantic/Canary]")
public class DashboardStats {

  private Integer totalStudents;

  private Integer activeCourses;

  private BigDecimal averageRating;

  private BigDecimal monthlyRevenue;

  private BigDecimal studentsGrowth;

  private BigDecimal revenueGrowth;

  public DashboardStats totalStudents(Integer totalStudents) {
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

  public DashboardStats activeCourses(Integer activeCourses) {
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

  public DashboardStats averageRating(BigDecimal averageRating) {
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

  public DashboardStats monthlyRevenue(BigDecimal monthlyRevenue) {
    this.monthlyRevenue = monthlyRevenue;
    return this;
  }

  /**
   * Ingresos mensuales
   * @return monthlyRevenue
  */
  @Valid 
  @Schema(name = "monthlyRevenue", description = "Ingresos mensuales", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("monthlyRevenue")
  public BigDecimal getMonthlyRevenue() {
    return monthlyRevenue;
  }

  public void setMonthlyRevenue(BigDecimal monthlyRevenue) {
    this.monthlyRevenue = monthlyRevenue;
  }

  public DashboardStats studentsGrowth(BigDecimal studentsGrowth) {
    this.studentsGrowth = studentsGrowth;
    return this;
  }

  /**
   * Crecimiento de estudiantes (%)
   * @return studentsGrowth
  */
  @Valid 
  @Schema(name = "studentsGrowth", description = "Crecimiento de estudiantes (%)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("studentsGrowth")
  public BigDecimal getStudentsGrowth() {
    return studentsGrowth;
  }

  public void setStudentsGrowth(BigDecimal studentsGrowth) {
    this.studentsGrowth = studentsGrowth;
  }

  public DashboardStats revenueGrowth(BigDecimal revenueGrowth) {
    this.revenueGrowth = revenueGrowth;
    return this;
  }

  /**
   * Crecimiento de ingresos (%)
   * @return revenueGrowth
  */
  @Valid 
  @Schema(name = "revenueGrowth", description = "Crecimiento de ingresos (%)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("revenueGrowth")
  public BigDecimal getRevenueGrowth() {
    return revenueGrowth;
  }

  public void setRevenueGrowth(BigDecimal revenueGrowth) {
    this.revenueGrowth = revenueGrowth;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DashboardStats dashboardStats = (DashboardStats) o;
    return Objects.equals(this.totalStudents, dashboardStats.totalStudents) &&
        Objects.equals(this.activeCourses, dashboardStats.activeCourses) &&
        Objects.equals(this.averageRating, dashboardStats.averageRating) &&
        Objects.equals(this.monthlyRevenue, dashboardStats.monthlyRevenue) &&
        Objects.equals(this.studentsGrowth, dashboardStats.studentsGrowth) &&
        Objects.equals(this.revenueGrowth, dashboardStats.revenueGrowth);
  }

  @Override
  public int hashCode() {
    return Objects.hash(totalStudents, activeCourses, averageRating, monthlyRevenue, studentsGrowth, revenueGrowth);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DashboardStats {\n");
    sb.append("    totalStudents: ").append(toIndentedString(totalStudents)).append("\n");
    sb.append("    activeCourses: ").append(toIndentedString(activeCourses)).append("\n");
    sb.append("    averageRating: ").append(toIndentedString(averageRating)).append("\n");
    sb.append("    monthlyRevenue: ").append(toIndentedString(monthlyRevenue)).append("\n");
    sb.append("    studentsGrowth: ").append(toIndentedString(studentsGrowth)).append("\n");
    sb.append("    revenueGrowth: ").append(toIndentedString(revenueGrowth)).append("\n");
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

