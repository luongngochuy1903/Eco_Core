package com.ecofood.core.dto;

import jakarta.validation.constraints.*;

/** Required when rejecting a Plan — mirrors ProductDecisionRequest + RevisionRequest's optimistic lock. */
public record PlanDecisionRequest(@NotNull @Min(0) Long expectedRevision, @NotBlank String reason) {}
