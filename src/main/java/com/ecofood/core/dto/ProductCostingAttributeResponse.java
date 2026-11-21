package com.ecofood.core.dto;
import java.math.BigDecimal;
public record ProductCostingAttributeResponse(String id,String productProcessId,Long processRevision,
    BigDecimal ingredientCost,BigDecimal packagingCost,BigDecimal laborCost,BigDecimal operationCost,
    BigDecimal marketingFee,BigDecimal targetMargin,BigDecimal tax,BigDecimal totalCost,BigDecimal basePrice,
    BigDecimal sellingPrice,String currency,String note) {}
