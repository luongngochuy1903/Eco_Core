package com.ecofood.core.dto;

import java.util.List;
import java.time.Instant;
import com.ecofood.core.enums.PlanStatusEnum;

public record PlanResponse(
        String id,
        int version,
        String name,
        String code,
        String description,
        List<String> regionIds,
        List<String> tenantIds,
        PlanProductOverrides productOverrides,
        MarketConfigurationResponse marketConfiguration,
        Instant startDate,
        Instant endDate,
        PlanStatusEnum status,
        String approvedBy,
        Instant approvedAt,
        Instant createdAt,
        Instant updatedAt,
        boolean canEdit,
        boolean canApprove,
        String previousVersionId,
        boolean canSubmit,
        boolean active,
        boolean canCreateVersion) {}
