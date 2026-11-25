package com.ecofood.core.dto;

import java.util.List;

/**
 * Body for approving a Product version. `approvePlanIds` is which of the
 * Plans listed by the pending-plan-approvals preview (bound to the version
 * being approved, currently Pending Review, across every Proposition
 * sourced from this Product) should also become Approved as part of this
 * same action — left null/empty, none are, and they stay Pending Review.
 */
public record ProductApproveRequest(List<String> approvePlanIds) {}
