package com.ecofood.core.dto;

import java.util.List;
import jakarta.validation.constraints.*;

public record PropositionCurrencySettingsRequest(
        @Min(0) Long expectedRevision,
        @NotEmpty List<@NotBlank String> availableCurrencies,
        @NotBlank String defaultCurrency) {}
