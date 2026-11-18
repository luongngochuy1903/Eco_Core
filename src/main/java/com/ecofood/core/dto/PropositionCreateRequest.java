package com.ecofood.core.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public record PropositionCreateRequest(
        @NotBlank String productId,
        @Min(1) int productVersion,
        @NotBlank String productProcessId,
        @NotNull @Valid PropositionDefinition definition) {}
