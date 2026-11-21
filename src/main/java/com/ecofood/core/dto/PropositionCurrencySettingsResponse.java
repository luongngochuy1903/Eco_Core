package com.ecofood.core.dto;

import java.util.List;

public record PropositionCurrencySettingsResponse(
        Long revision, List<String> availableCurrencies, String defaultCurrency) {}
