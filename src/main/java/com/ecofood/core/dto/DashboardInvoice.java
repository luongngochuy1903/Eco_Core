package com.ecofood.core.dto;
import java.math.BigDecimal;
import java.time.Instant;
public record DashboardInvoice(String id, String tenantId, String invoiceNumber, String propositionId,
    Instant transactionTime, BigDecimal totalAmount, String currency, String status) {}
