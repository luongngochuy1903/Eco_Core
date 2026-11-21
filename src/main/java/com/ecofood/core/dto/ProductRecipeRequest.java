package com.ecofood.core.dto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import java.util.List;
public record ProductRecipeRequest(boolean enabled, List<@Valid ProductRecipeStepRequest> steps,
    String name, @Min(0) Integer preparationMinutes, @Min(0) Integer cookingMinutes, String note) {
  public ProductRecipeRequest(boolean enabled, List<ProductRecipeStepRequest> steps) {
    this(enabled, steps, null, 0, 0, null);
  }
}
