package com.ecofood.core.service;

import com.ecofood.core.dto.ExternalCustomerDtos;

/**
 * Pre-transaction customer identification: a distribution partner hands us a
 * customer's email; we create (or reuse, if already created) a Customer
 * account under a fixed, operator-configured onboarding tenant via the same
 * user-creation path used for tenant onboarding (see CoreUserClient), then
 * hand back a QR encoding that tenant's existing /customer/login page so the
 * Customer can sign in and set their Keycloak password (new admin-created
 * users already require VERIFY_EMAIL + UPDATE_PASSWORD on first login).
 *
 * <p>A later submit-transaction whose Sale Orchestrator has
 * {@code createCustomer} enabled and whose invoiceHolder carries that same
 * email auto-links the new Invoice to that Customer account — matching is by
 * email, not by anything the distribution partner needs to store.
 *
 * <p>Public module contract. Implementations and persistence belong to
 * backend main.
 */
public interface ExternalCustomerService {
  ExternalCustomerDtos.Issued issue(ExternalCustomerDtos.IssueRequest request);
}
