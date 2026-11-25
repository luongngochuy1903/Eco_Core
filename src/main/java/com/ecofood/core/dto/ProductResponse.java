package com.ecofood.core.dto;
import com.ecofood.core.enums.ProductStatusEnum;
import com.ecofood.core.enums.ProductTypeEnum;
import java.time.Instant;
import java.util.List;
public record ProductResponse(
    String id, String enterpriseId, String enterpriseName, ProductTypeEnum type,
    int version, Long revision, ProductStatusEnum status,
    String name, String description, List<ProductIngredientRequest> ingredients,
    ProductRecipeRequest recipe, ProductPricingRequest pricing,
    String rejectionReason, String approvedBy, Instant approvedAt,
    Instant createdAt, Instant updatedAt,
    String code, String category, String imageUrl,
    ProductCostingAttributeResponse costing,List<ProductProcessResponse> productProcess) {
  public ProductResponse(String id,String enterpriseId,String enterpriseName,ProductTypeEnum type,
      int version,Long revision,ProductStatusEnum status,String name,String description,
      List<ProductIngredientRequest> ingredients,ProductRecipeRequest recipe,ProductPricingRequest pricing,
      String rejectionReason,String approvedBy,Instant approvedAt,Instant createdAt,Instant updatedAt,
      String code,String category,String imageUrl) {
    this(id,enterpriseId,enterpriseName,type,version,revision,status,name,description,ingredients,recipe,pricing,
        rejectionReason,approvedBy,approvedAt,createdAt,updatedAt,code,category,imageUrl,null,List.of());
  }
}
