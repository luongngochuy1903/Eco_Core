package com.ecofood.core.service;

import com.ecofood.core.dto.TenantLoginInfoResponse;
import com.ecofood.core.dto.TenantOnboardRequest;
import com.ecofood.core.dto.TenantOnboardResponse;
import com.ecofood.core.dto.TenantResponse;

/**
 * Plain same-module-facing interface, implemented by tenant's TenantServiceImpl.
 * getById returns TenantResponse (a DTO), never the raw tenant.entity.TenantEntity
 * — same cross-module-boundary rule as TenantQueryService.
 */
public interface TenantService {

  TenantOnboardResponse onboardTenant(TenantOnboardRequest request);

  TenantResponse getById(String tenantId);

  /** Resolves a frontend-supplied "domain" (hostname, or a dev stand-in) to its tenant's login config. */
  TenantLoginInfoResponse getLoginInfoByDomain(String domain);
}
