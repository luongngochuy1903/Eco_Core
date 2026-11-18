package com.ecofood.core.dto;

import java.util.List;
import java.time.Instant;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public record PlanRequest(
        @NotNull @Min(0) Long expectedRevision,
        @NotBlank String name,
        String code,
        String description,
        @NotEmpty List<@NotBlank String> regionIds,
        @NotEmpty List<@NotBlank String> tenantIds,
        @Valid PlanProductOverrides productOverrides,
        @Valid MarketConfigurationRequest marketConfiguration,
        Instant startDate,
        Instant endDate) {}
