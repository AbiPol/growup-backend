package com.growup.backend.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Tipo de actividad en el sistema
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-27T09:40:28.900756900Z[Atlantic/Canary]")
public enum ActivityType {
  
  ENROLLMENT("enrollment"),
  
  QUESTION("question"),
  
  REVIEW("review");

  private String value;

  ActivityType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static ActivityType fromValue(String value) {
    for (ActivityType b : ActivityType.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

