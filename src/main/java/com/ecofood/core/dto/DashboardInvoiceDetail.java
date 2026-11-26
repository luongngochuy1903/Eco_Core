package com.ecofood.core.dto;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

/** Read-only Invoice detail shared with Manager; internal payloads and costing snapshots stay private. */
public record DashboardInvoiceDetail(
    DashboardInvoice invoice, String posId, String submittedBy, String distributionPartnerId,
    String planId, String type, String paymentStatus, Instant receivedAt,
    List<InvoiceItemDto> items, List<PlanLine> planLines) {
  public record PlanLine(String lineId, String planId, String planName, long quantity,
                         BigDecimal unitPrice, BigDecimal amount) {}
}
