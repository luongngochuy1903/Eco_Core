package com.ecofood.core.dto;
import java.util.List;
public record ProductDefinitionAttributeResponse(String id,String productProcessId,Long processRevision,
    String productName,String code,String category,String description,String imagesURL,
    List<ProductIngredientRequest> ingredients,List<ProductComponentRequest> componentProducts,ProductRecipeRequest recipe) {}
