package com.ecofood.core.dto;
import java.math.BigDecimal;
import java.time.Instant;
public record DashboardInvoice(String id, String tenantId, String propositionId,
    Instant transactionTime, BigDecimal totalAmount, String currency, String status,
    java.util.List<DashboardDtos.Option> propositions, Instant receivedAt) {
  public DashboardInvoice(String id, String tenantId, String propositionId,
      Instant transactionTime, BigDecimal totalAmount, String currency, String status,
      java.util.List<DashboardDtos.Option> propositions) {
    this(id, tenantId, propositionId, transactionTime, totalAmount, currency, status, propositions, null);
  }
  public DashboardInvoice(String id, String tenantId, String propositionId,
      Instant transactionTime, BigDecimal totalAmount, String currency, String status) {
    this(id, tenantId, propositionId, transactionTime, totalAmount, currency, status, java.util.List.of());
  }
}
