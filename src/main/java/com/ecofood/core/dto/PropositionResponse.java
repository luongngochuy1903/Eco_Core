package com.ecofood.core.dto;

import java.util.List;
import java.time.Instant;

public record PropositionResponse(
        String id,
        Long revision,
        String enterpriseId,
        String enterpriseName,
        String productId,
        int productVersion,
        String productProcessId,
        ProductProcessResponse sourceProcess,
        PropositionDefinition definition,
        String status,
        List<PlanResponse> plans,
        List<EconomicMetricsRequest> actualMetrics,
        List<PropositionTenantReference> eligibleTenants,
        List<String> availableCurrencies,
        Instant createdAt,
        Instant updatedAt,
        boolean canEdit,
        boolean canManagePlans,
        boolean canSubmit,
        boolean canApprove,
        String approvedBy,
        Instant approvedAt,
        boolean active) {}
