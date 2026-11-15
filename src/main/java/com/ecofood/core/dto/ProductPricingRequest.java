package com.ecofood.core.dto;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
/** Phase 1: fixed pricing only; no user-supplied executable expressions. */
public record ProductPricingRequest(
    @NotNull @DecimalMin("0.00") BigDecimal sellingPrice,
    @DecimalMin("0.00") BigDecimal costPrice,
    String currency, String note) {
  public ProductPricingRequest(BigDecimal sellingPrice, BigDecimal costPrice, String currency) {
    this(sellingPrice, costPrice, currency, null);
  }
}
