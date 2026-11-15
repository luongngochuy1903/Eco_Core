package com.ecofood.core.dto;
import java.math.BigDecimal;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.DecimalMax;
public record ProductCostingRequest(
    @DecimalMin("0") BigDecimal ingredientCost, @DecimalMin("0") BigDecimal packagingCost,
    @DecimalMin("0") BigDecimal laborCost, @DecimalMin("0") BigDecimal operationCost,
    @DecimalMin("0") BigDecimal marketingFee,
    @DecimalMin("0") @DecimalMax(value="100", inclusive=false) BigDecimal targetMargin,
    @DecimalMin("0") @DecimalMax("100") BigDecimal tax) {}
