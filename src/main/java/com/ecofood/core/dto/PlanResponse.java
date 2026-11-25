package com.ecofood.core.dto;

import java.util.List;
import java.time.Instant;
import com.ecofood.core.enums.PlanStatusEnum;

public record PlanResponse(
        String id,
        int version,
        int productVersion,
        String code,
        String name,
        String description,
        String category,
        String imageUrl,
        List<ProductIngredientRequest> ingredients,
        ProductRecipeRequest recipe,
        ProductCostingAttributeResponse costing,
        List<String> regionIds,
        List<String> tenantIds,
        Instant startDate,
        Instant endDate,
        PlanStatusEnum status,
        String approvedBy,
        Instant approvedAt,
        String rejectionReason,
        Instant createdAt,
        Instant updatedAt,
        boolean canEdit,
        boolean canApprove,
        String previousVersionId,
        boolean canSubmit,
        boolean active,
        boolean canCreateVersion) {}
