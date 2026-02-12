package com.growup.backend.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * AdminUsersIdStatusPatchRequest
 */

@JsonTypeName("_admin_users__id__status_patch_request")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-12T11:59:11.015804600Z[Atlantic/Canary]")
public class AdminUsersIdStatusPatchRequest {

  private Boolean isActive;

  public AdminUsersIdStatusPatchRequest isActive(Boolean isActive) {
    this.isActive = isActive;
    return this;
  }

  /**
   * Nuevo estado (true = activo, false = inactivo/baja lógica)
   * @return isActive
  */
  
  @Schema(name = "isActive", description = "Nuevo estado (true = activo, false = inactivo/baja lógica)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("isActive")
  public Boolean getIsActive() {
    return isActive;
  }

  public void setIsActive(Boolean isActive) {
    this.isActive = isActive;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AdminUsersIdStatusPatchRequest adminUsersIdStatusPatchRequest = (AdminUsersIdStatusPatchRequest) o;
    return Objects.equals(this.isActive, adminUsersIdStatusPatchRequest.isActive);
  }

  @Override
  public int hashCode() {
    return Objects.hash(isActive);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AdminUsersIdStatusPatchRequest {\n");
    sb.append("    isActive: ").append(toIndentedString(isActive)).append("\n");
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

