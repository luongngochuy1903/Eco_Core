package com.ecofood.core.service;

import com.ecofood.core.dto.CustomerIdentityDtos;
import com.ecofood.core.dto.ExternalCustomerDtos;

/**
 * Pre-transaction customer identification: a distribution partner issues a
 * QR for an externalId it generated (no invoice/transaction exists yet); the
 * customer scans it, signs in/up, and that externalId is recorded on their
 * Customer account. A later submit-transaction whose Sale Orchestrator has
 * {@code createCustomer} enabled and whose invoiceHolder carries the same
 * externalId then auto-links the new Invoice to that Customer.
 *
 * <p>Public module contract. Implementations and persistence belong to
 * backend main.
 */
public interface ExternalCustomerService {
  ExternalCustomerDtos.Issued issue(ExternalCustomerDtos.IssueRequest request);
  void revoke(String externalId);
  CustomerIdentityDtos.LoginConfig view(String token);
  ExternalCustomerDtos.Linked link(String token);
}
