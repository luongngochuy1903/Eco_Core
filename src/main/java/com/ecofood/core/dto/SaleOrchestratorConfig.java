package com.ecofood.core.dto;

import java.util.Set;

/** Provider must resolve an authorized POS binding, never trust payload identity. */
public record SaleOrchestratorConfig(String tenantId, String posId,
    String distributionPartnerId, String planId, String propositionId,
    boolean active, boolean planActive, boolean propositionActive,
    Set<String> currencies, int maxItems) {}
