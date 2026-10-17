package com.ecofood.core.service;

import com.ecofood.core.dto.TenantResponse;

/**
 * Plain same-module-facing interface, implemented by tenant's
 * TenantQueryServiceImpl. Returns TenantResponse (a DTO), never the raw
 * tenant.entity.TenantEntity — this is a cross-module contract, consumed
 * exclusively via CoreTenantQueryClient, so it must never leak a
 * tenant-module-only entity type.
 */
public interface TenantQueryService {

  TenantResponse getById(String tenantId);

  TenantResponse getByRealm(String realm);
}
