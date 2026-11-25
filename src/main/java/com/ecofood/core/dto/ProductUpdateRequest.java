package com.ecofood.core.dto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;
public record ProductUpdateRequest(
    @NotBlank String name,
    String description,
    List<@Valid ProductIngredientRequest> ingredients,
    @Valid ProductRecipeRequest recipe,
    @Valid ProductPricingRequest pricing,
    @NotNull Long expectedRevision,
    @NotBlank String code,
    @NotBlank String category,
    String imageUrl,
    @Valid ProductCostingRequest costing) {
  public ProductUpdateRequest(String name,String description,List<ProductIngredientRequest> ingredients,
      ProductRecipeRequest recipe,ProductPricingRequest pricing,Long expectedRevision,
      String code,String category,String imageUrl) {
    this(name,description,ingredients,recipe,pricing,expectedRevision,code,category,imageUrl,null);
  }
}
