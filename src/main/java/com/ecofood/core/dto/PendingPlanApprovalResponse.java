package com.ecofood.core.dto;

/**
 * One row in the "Plans awaiting approval" popup shown when approving a
 * Product version — every Plan, across every Proposition sourced from this
 * Product (a Proposition carries no product version of its own; each Plan
 * independently picks which version it's bound to), that is currently
 * Pending Review and bound to the version about to be approved.
 */
public record PendingPlanApprovalResponse(
        String propositionId,
        String propositionName,
        String planId,
        String planCode,
        String planName) {}
