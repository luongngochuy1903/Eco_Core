package com.ecofood.core.dto;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
public record ProductIngredientRequest(
    String ingredientId,
    @NotNull @DecimalMin(value = "0.0", inclusive = false) BigDecimal quantity,
    @NotBlank String unit,
    @NotBlank String name,
    String note) {
  public ProductIngredientRequest(String ingredientId, BigDecimal quantity, String unit) {
    this(ingredientId, quantity, unit, ingredientId, null);
  }
}
