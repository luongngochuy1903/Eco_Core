package com.ecofood.core.dto;
import com.ecofood.core.enums.ProductTypeEnum;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;
// code is deliberately absent — it's server-generated at creation time
// (sequence-based, e.g. PR00001), same pattern as TenantEntity's onboarding
// code. Never user-provided, see ProductServiceImpl.create().
// sourceProductId/componentProducts are gone — only STANDALONE products
// exist now, so there's no base/component product relationship to express.
public record ProductCreateRequest(
    @NotNull ProductTypeEnum type,
    @NotBlank String name,
    String description,
    List<@Valid ProductIngredientRequest> ingredients,
    @Valid ProductRecipeRequest recipe,
    @Valid ProductPricingRequest pricing,
    @NotBlank String category,
    String imageUrl,
    @Valid ProductCostingRequest costing) {
  public ProductCreateRequest(ProductTypeEnum type,String name,String description,
      List<ProductIngredientRequest> ingredients,ProductRecipeRequest recipe,ProductPricingRequest pricing,
      String category,String imageUrl) {
    this(type,name,description,ingredients,recipe,pricing,category,imageUrl,null);
  }
}
