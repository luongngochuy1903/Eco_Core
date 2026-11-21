package com.ecofood.core.dto;

import java.util.List;

public record PropositionOptionsResponse(
        boolean canCreate,
        List<PropositionTenantReference> brands,
        List<PropositionTenantReference> distributionPartners,
        String defaultCurrency,
        List<String> availableCurrencies) {}
