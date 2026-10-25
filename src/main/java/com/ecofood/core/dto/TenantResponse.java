package com.ecofood.core.dto;

import com.ecofood.core.enums.PartnerTypeEnum;
import com.ecofood.core.enums.TenantTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Cross-module read shape for a tenant — returned by TenantQueryService's
 * getById/getAllByRealm (via CoreTenantQueryClient), never the raw
 * tenant.entity.TenantEntity. Covers every field other modules actually read
 * off that entity today (see InternalTokenService, UserServiceImpl).
 */
@Data
@AllArgsConstructor
@Builder
public class TenantResponse {
  private String id;
  private String tenantName;
  private String realm;
  private String clientId;

  /** Null unless this tenant's partnerType is ENTERPRISE/REGIONAL_ENTERPRISE — see TenantEntity.enterpriseId. */
  private String enterpriseId;

  /** Null unless set at onboarding — the actual origin this tenant's frontend is served from. */
  private String domainUrl;

  private TenantTypeEnum tenantType;

  private PartnerTypeEnum partnerTypeCode;

  /** This tenant's primary point of contact — every non-boolean field off TenantEntity.contact. */
  private ContactResponse contact;
}
