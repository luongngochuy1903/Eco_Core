package com.ecofood.core.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public record ProductComponentRequest(
    @NotBlank String productId,
    @NotNull @DecimalMin(value = "0", inclusive = false) BigDecimal quantity) {}
