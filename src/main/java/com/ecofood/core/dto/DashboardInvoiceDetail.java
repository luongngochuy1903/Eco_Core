package com.ecofood.core.dto;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

/** Read-only Invoice detail shared with Manager; internal payloads and costing snapshots stay private. */
public record DashboardInvoiceDetail(
    DashboardInvoice invoice, String posId, String submittedBy, String distributionPartnerId,
    String planId, Instant receivedAt,
    List<InvoiceItemDto> items, List<PlanLine> planLines, String tenantCode, List<DashboardDtos.Option> propositions) {
  public DashboardInvoiceDetail(DashboardInvoice invoice, String posId, String submittedBy, String distributionPartnerId,
      String planId, Instant receivedAt, List<InvoiceItemDto> items, List<PlanLine> planLines) {
    this(invoice, posId, submittedBy, distributionPartnerId, planId, receivedAt, items, planLines, null, List.of());
  }
  public record PlanLine(String lineId, String planId, String planName, long quantity,
                         BigDecimal unitPrice, BigDecimal amount) {}
}
