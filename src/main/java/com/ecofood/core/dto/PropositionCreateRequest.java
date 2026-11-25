package com.ecofood.core.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public record PropositionCreateRequest(
        @NotBlank String productId,
        @NotNull @Valid PropositionDefinition definition) {}
