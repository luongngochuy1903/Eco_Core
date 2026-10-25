package com.ecofood.core.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Public, unauthenticated response for GET /api/v1/tenants/domain-availability
 * — backs the tenant onboarding form's live "is this domain already taken"
 * check (mirrors DCMP's real live domain-availability validation), called
 * on every keystroke of the computed full domain (debounced client-side),
 * never the raw subdomain the user actually types.
 */
@Data
@AllArgsConstructor
@Builder
public class DomainAvailabilityResponse {
  private String domainUrl;
  private boolean available;
}
