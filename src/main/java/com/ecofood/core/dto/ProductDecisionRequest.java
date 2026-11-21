package com.ecofood.core.dto;
import jakarta.validation.constraints.NotBlank;
/** Required when rejecting; approve does not require a body. */
public record ProductDecisionRequest(@NotBlank String reason) {}
