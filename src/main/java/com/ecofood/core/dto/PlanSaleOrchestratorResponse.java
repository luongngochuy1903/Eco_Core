package com.ecofood.core.dto;

import java.time.Instant;
import java.util.List;

/**
 * No status/version history — a Sale Orchestrator is one current,
 * always-editable configuration, same lifecycle shape as a Draft Plan.
 * `plans` resolves each covered Plan's own display fields (name/code/status)
 * for the editor UI, same convention PlanResponse's siblings use elsewhere.
 * `planItems`/`additionalInfoFields`/`invoiceHolder` are this Orchestrator's
 * own configured field lists — see PlanSaleOrchestratorRequest for what each
 * one means. `canEdit` is false when the viewer can see this Orchestrator
 * (same Proposition) but didn't create it and isn't the owning Enterprise —
 * view access is scoped to "same Proposition," edit access stays scoped to
 * the creating Tenant (or Enterprise).
 */
public record PlanSaleOrchestratorResponse(
        String id,
        Long revision,
        String propositionId,
        String name,
        String description,
        List<PlanRef> plans,
        List<SaleConfigurationField> planItems,
        List<SaleConfigurationField> additionalInfoFields,
        List<SaleConfigurationField> invoiceHolder,
        Instant createdAt,
        Instant updatedAt,
        String createdBy,
        String updatedBy,
        boolean canEdit) {
    public record PlanRef(String planId, String planCode, String planName, com.ecofood.core.enums.PlanStatusEnum planStatus) {}
}
