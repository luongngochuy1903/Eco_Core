package com.ecofood.core.service;

import com.ecofood.core.dto.CustomerReceiptDtos;

/** Public module contract. Implementations and persistence belong to backend main. */
public interface CustomerReceiptService {
  CustomerReceiptDtos.Issued issue(String invoiceId, CustomerReceiptDtos.IssueRequest request);
  void revoke(String invoiceId);
  CustomerReceiptDtos.GuestInvoice view(String token);
  CustomerReceiptDtos.Claimed claim(String token);
}
