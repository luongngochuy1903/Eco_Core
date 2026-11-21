package com.ecofood.core.dto;

import java.math.BigDecimal;
import jakarta.validation.constraints.*;

public record MarketConfigurationRequest(
        String currency,
        @NotNull @DecimalMin("0") @Digits(integer = 15, fraction = 4) BigDecimal salePrice,
        @DecimalMin("0") @DecimalMax("100") @Digits(integer = 3, fraction = 4) BigDecimal taxRate,
        @DecimalMin("0") @Digits(integer = 15, fraction = 4) BigDecimal surcharge) {}
