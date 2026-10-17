package com.ecofood.core.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Cross-module read shape for a tenant — returned by TenantQueryService/
 * TenantService's getById/getByRealm (via CoreTenantQueryClient/
 * CoreTenantClient), never the raw tenant.entity.TenantEntity. Covers every
 * field other modules actually read off that entity today (see
 * InternalTokenService, UserServiceImpl).
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
}
