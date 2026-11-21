package com.ecofood.core.dto;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import java.math.BigDecimal;
import java.util.List;

/** Declarative schema shared with UC-015; never contains executable expressions. */
public record SalePayloadSchema(List<Field> fields) {
  public SalePayloadSchema {
    fields = fields == null ? List.of() : List.copyOf(fields);
  }

  @JsonAnySetter
  public void unknown(String key, Object value) {
    throw new IllegalArgumentException("Unsupported schema property: " + key);
  }

  public enum Type {
    STRING,
    NUMBER,
    BOOLEAN,
    DATE,
    OBJECT,
    ARRAY
  }

  public record Field(
      String name,
      Type type,
      Boolean required,
      Object defaultValue,
      BigDecimal min,
      BigDecimal max,
      String format,
      String description,
      List<Field> fields,
      Field items) {
    public Field {
      required = Boolean.TRUE.equals(required);
      fields = fields == null ? null : List.copyOf(fields);
    }

    @JsonAnySetter
    public void unknown(String key, Object value) {
      throw new IllegalArgumentException("Unsupported validation rule: " + key);
    }
  }
}
