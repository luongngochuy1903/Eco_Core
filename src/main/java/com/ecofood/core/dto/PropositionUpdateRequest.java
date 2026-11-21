package com.ecofood.core.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public record PropositionUpdateRequest(
        @NotNull @Min(0) Long expectedRevision, @NotNull @Valid PropositionDefinition definition) {}
