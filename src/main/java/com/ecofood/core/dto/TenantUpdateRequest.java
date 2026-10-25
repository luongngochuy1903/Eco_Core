package com.ecofood.core.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * Backs PUT /api/v1/tenants/{id} — deliberately narrow: only the fields the
 * frontend's edit form actually exposes as editable (tenantName + contact).
 * domainUrl/realm/clientId/partnerTypeCode/tenantType are NOT here — they
 * stay immutable through this endpoint, matching the form's disabled fields.
 *
 * contact reuses EnterpriseContactRequest (already exists, already mapped by
 * TenantServiceImpl.mapContact for onboarding) rather than a second
 * tenant-specific contact DTO. Null contact means "leave the existing
 * contact untouched"; a present contact fully replaces it (PUT semantics,
 * matching how the frontend always sends its whole seeded draft, never a
 * partial patch).
 */
@Data
public class TenantUpdateRequest {

  @NotBlank
  private String tenantName;

  @Valid
  private EnterpriseContactRequest contact;
}
