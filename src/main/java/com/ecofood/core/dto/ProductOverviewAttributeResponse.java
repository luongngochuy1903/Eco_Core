package com.ecofood.core.dto;
import java.math.BigDecimal;
import java.util.List;
public record ProductOverviewAttributeResponse(String id,String productProcessId,Long processRevision,
    String productName,String code,String category,String description,String imagesURL,
    List<ProductIngredientRequest> ingredients,List<ProductComponentRequest> componentProducts,ProductRecipeRequest recipe,
    BigDecimal ingredientCost,BigDecimal packagingCost,BigDecimal laborCost,BigDecimal operationCost,
    BigDecimal marketingFee,BigDecimal targetMargin,BigDecimal tax,BigDecimal totalCost,BigDecimal basePrice,
    BigDecimal sellingPrice,String currency,String note) {}
