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
 * RevenueData
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-12T11:59:11.015804600Z[Atlantic/Canary]")
public class RevenueData {

  private String month;

  private BigDecimal revenue;

  private Integer enrollments;

  public RevenueData month(String month) {
    this.month = month;
    return this;
  }

  /**
   * Mes
   * @return month
  */
  
  @Schema(name = "month", description = "Mes", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("month")
  public String getMonth() {
    return month;
  }

  public void setMonth(String month) {
    this.month = month;
  }

  public RevenueData revenue(BigDecimal revenue) {
    this.revenue = revenue;
    return this;
  }

  /**
   * Ingresos del mes
   * @return revenue
  */
  @Valid 
  @Schema(name = "revenue", description = "Ingresos del mes", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("revenue")
  public BigDecimal getRevenue() {
    return revenue;
  }

  public void setRevenue(BigDecimal revenue) {
    this.revenue = revenue;
  }

  public RevenueData enrollments(Integer enrollments) {
    this.enrollments = enrollments;
    return this;
  }

  /**
   * Inscripciones del mes
   * @return enrollments
  */
  
  @Schema(name = "enrollments", description = "Inscripciones del mes", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("enrollments")
  public Integer getEnrollments() {
    return enrollments;
  }

  public void setEnrollments(Integer enrollments) {
    this.enrollments = enrollments;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RevenueData revenueData = (RevenueData) o;
    return Objects.equals(this.month, revenueData.month) &&
        Objects.equals(this.revenue, revenueData.revenue) &&
        Objects.equals(this.enrollments, revenueData.enrollments);
  }

  @Override
  public int hashCode() {
    return Objects.hash(month, revenue, enrollments);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RevenueData {\n");
    sb.append("    month: ").append(toIndentedString(month)).append("\n");
    sb.append("    revenue: ").append(toIndentedString(revenue)).append("\n");
    sb.append("    enrollments: ").append(toIndentedString(enrollments)).append("\n");
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

