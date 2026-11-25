package com.ecofood.core.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;

/**
 * Create and update both use this shape — a Sale Orchestrator has no
 * version/status lifecycle, just a current, always-editable configuration
 * (name/description + the Plans it covers). `expectedRevision` is only
 * checked on update (the orchestrator's own optimistic-lock revision); it's
 * ignored on create, since nothing exists yet to protect.
 *
 * <p>Three independent, user-editable field lists describe the whole
 * submit-transaction shape this Orchestrator accepts:
 * <ul>
 *   <li>{@code planItems} — the item's own planId/quantity/actualPrice
 *       fields (always exactly those three keys; only their
 *       description/shortName/dataType/required are configurable — see
 *       PlanSaleOrchestratorServiceImpl.PLAN_ITEM_KEYS).
 *   <li>{@code additionalInfoFields} — extra, free-form keys a submitted
 *       item's additionalInfo may (or, if required, must) carry.
 *   <li>{@code invoiceHolder} — the buyer's own info, carried once per
 *       invoice (sibling to invoiceNumber/items on a Receipt), not per item.
 * </ul>
 * Left null/empty on create, each defaults server-side (planId/quantity
 * required, actualPrice optional; firstName/lastName/email/phoneNumber/
 * address all optional for invoiceHolder).
 */
public record PlanSaleOrchestratorRequest(
        Long expectedRevision,
        @NotBlank @Size(max = 200) String name,
        @Size(max = 2000) String description,
        @NotEmpty @Size(max = 500) List<@NotBlank String> planIds,
        @Size(max = 100) List<@Valid SaleConfigurationField> planItems,
        @Size(max = 100) List<@Valid SaleConfigurationField> additionalInfoFields,
        @Size(max = 100) List<@Valid SaleConfigurationField> invoiceHolder) {}
