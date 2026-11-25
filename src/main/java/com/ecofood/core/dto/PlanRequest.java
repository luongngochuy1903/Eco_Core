package com.ecofood.core.dto;

import java.util.List;
import java.time.Instant;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * A Plan is a full clone of its Proposition's approved source product —
 * "every field editable" — not a sparse set of overrides, so this carries
 * the same shape ProductCreateRequest/ProductUpdateRequest do (minus type/
 * code/expectedRevision, which a Plan either doesn't have or whose
 * concurrency is governed by the parent Proposition's own revision).
 */
public record PlanRequest(
        @NotNull @Min(0) Long expectedRevision,
        @NotNull @Min(1) Integer productVersion,
        @NotBlank String name,
        String description,
        String category,
        String imageUrl,
        List<@Valid ProductIngredientRequest> ingredients,
        @Valid ProductRecipeRequest recipe,
        @Valid ProductCostingRequest costing,
        @Valid ProductPricingRequest pricing,
        @NotEmpty List<@NotBlank String> regionIds,
        @NotEmpty List<@NotBlank String> tenantIds,
        Instant startDate,
        Instant endDate) {}
