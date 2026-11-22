package com.ecofood.core.dto;

import java.time.Instant;
import java.util.List;

public final class CustomerReceiptDtos {
  private CustomerReceiptDtos() {}
  public record IssueRequest(String requestId) {}
  public record TokenRequest(String token) {}
  public record Issued(String receiptId, String invoiceId, String receiptUrl, String qrPngBase64, Instant expiresAt) {}
  public record GuestInvoice(String invoiceNumber, Instant transactionTime, String currency,
      @com.fasterxml.jackson.annotation.JsonFormat(shape = com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING) java.math.BigDecimal totalAmount,
      List<CustomerDtos.Item> items, CustomerIdentityDtos.LoginConfig login) {}
  public record Claimed(CustomerDtos.OwnedInvoice invoice, String emailStatus) {}
}
