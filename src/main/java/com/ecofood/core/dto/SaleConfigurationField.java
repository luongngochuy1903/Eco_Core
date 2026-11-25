package com.ecofood.core.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * One configurable "Additional Info" field a Sale Orchestrator accepts
 * alongside its fixed planId/quantity/actualPrice item shape — mirrors
 * DCMP's own SaleConfigurationField, trimmed to what this platform needs
 * (no premium/endorsement/PII metadata, none of which applies here).
 * `dataType` is one of STRING, NUMBER, BOOLEAN, DATE. When `required` is
 * true, a submitted item's additionalInfo must carry a non-null value for
 * this key (see BatchSalePlanResolver).
 */
public record SaleConfigurationField(
        @NotBlank @Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9]*$") @Size(max = 100) String key,
        @NotBlank @Size(max = 20) String dataType,
        @Size(max = 100) String shortName,
        @Size(max = 500) String description,
        boolean required) {}
