package com.ecofood.core.dto;
import com.ecofood.core.enums.ProductTypeEnum;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;
public record ProductCreateRequest(
    @NotNull ProductTypeEnum type,
    @NotBlank String name,
    String description,
    String sourceProductId,
    List<@Valid ProductIngredientRequest> ingredients,
    @Valid ProductRecipeRequest recipe,
    @Valid ProductPricingRequest pricing,
    @NotBlank String code,
    @NotBlank String category,
    String imageUrl,
    List<@Valid ProductComponentRequest> componentProducts,
    @Valid ProductCostingRequest costing) {
  public ProductCreateRequest(ProductTypeEnum type,String name,String description,String sourceProductId,
      List<ProductIngredientRequest> ingredients,ProductRecipeRequest recipe,ProductPricingRequest pricing,
      String code,String category,String imageUrl,List<ProductComponentRequest> componentProducts) {
    this(type,name,description,sourceProductId,ingredients,recipe,pricing,code,category,imageUrl,componentProducts,null);
  }
}
