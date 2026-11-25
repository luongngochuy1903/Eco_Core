package com.ecofood.core.service;

import com.ecofood.core.dto.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

public interface PropositionService {
    PropositionResponse create(PropositionCreateRequest request);

    PropositionResponse update(String id, PropositionUpdateRequest request);

    PropositionResponse addPlan(String id, PlanRequest request);

    PropositionResponse updatePlan(String id, String planId, PlanRequest request);

    PropositionResponse removePlan(String id, String planId, RevisionRequest request);

    PropositionResponse approvePlan(String id, String planId, RevisionRequest request);

    PropositionResponse rejectPlan(String id, String planId, PlanDecisionRequest request);

    PropositionResponse submitPlan(String id, String planId, RevisionRequest request);

    PropositionResponse versionPlan(String id, String planId, RevisionRequest request);

    PropositionCurrencySettingsResponse updateCurrencySettings(
            PropositionCurrencySettingsRequest request);

    /**
     * Called only from an already-authorized Product-approval flow (see
     * ProductServiceImpl.approve) — every Plan, across every Proposition
     * sourced from this Product, currently Pending Review and bound to this
     * version.
     */
    List<PendingPlanApprovalResponse> pendingPlanApprovals(String productId, int version);

    /**
     * System cascade: a Product version that was APPROVED and just got
     * demoted back to Pending Review (because a different version of the
     * same Product was just approved) takes any of its own APPROVED Plans
     * — across every Proposition sourced from this Product — back to
     * Pending Review with it. Called only from the already-authorized
     * Product-approval flow.
     */
    void demoteApprovedPlans(String productId, int version);

    /**
     * System cascade: approves exactly the given Plans (by id) — each must
     * still be Pending Review and bound to this Product version, across
     * every Proposition sourced from this Product — as chosen by the
     * caller in the pending-plan-approvals popup. Called only from the
     * already-authorized Product-approval flow.
     */
    void approvePlans(String productId, int version, List<String> planIds);

    /**
     * Legacy quarterly accumulator retained for existing integrations.
     * New sales write tenant/month/currency actuals atomically with their Invoices
     * through the backend's PropositionSalesMetrics; do not call both paths.
     *
     * @deprecated Use the backend's transactional PropositionSalesMetrics flow instead.
     *     This method is intended for removal after all legacy integrations have migrated.
     */
    @Deprecated(forRemoval = true)
    void recordActualSale(String propositionId, Instant occurredAt, BigDecimal totalSalesVolume,
            BigDecimal ingredientCost, BigDecimal platformCost, BigDecimal profit);
}
