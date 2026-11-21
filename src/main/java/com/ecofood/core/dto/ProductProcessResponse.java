package com.ecofood.core.dto;
import java.time.Instant;
import com.ecofood.core.enums.ProductStatusEnum;
public record ProductProcessResponse(String id,String productId,int version,Long revision,
    ProductStatusEnum status,String processElementName,
    ProductProcessElementResponse<ProductDefinitionAttributeResponse> definition,
    ProductProcessElementResponse<ProductCostingAttributeResponse> costing,
    ProductProcessElementResponse<ProductOverviewAttributeResponse> overview,
    boolean legacy,String rejectionReason,String approvedBy,Instant approvedAt,Instant createdAt,Instant updatedAt) {}
