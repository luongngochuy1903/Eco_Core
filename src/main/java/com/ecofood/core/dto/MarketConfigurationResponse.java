package com.ecofood.core.dto;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonFormat;

public record MarketConfigurationResponse(
        String currency,
        @JsonFormat(shape = JsonFormat.Shape.STRING) BigDecimal salePrice,
        @JsonFormat(shape = JsonFormat.Shape.STRING) BigDecimal taxRate,
        @JsonFormat(shape = JsonFormat.Shape.STRING) BigDecimal surcharge,
        @JsonFormat(shape = JsonFormat.Shape.STRING) BigDecimal taxAmount,
        @JsonFormat(shape = JsonFormat.Shape.STRING) BigDecimal totalPrice) {}
