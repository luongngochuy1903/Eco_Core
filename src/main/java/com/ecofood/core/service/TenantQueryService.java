package com.ecofood.core.service;

import com.ecofood.core.dto.TenantResponse;
import java.util.List;

/**
 * Plain same-module-facing interface, implemented by tenant's
 * TenantQueryServiceImpl. Returns TenantResponse (a DTO), never the raw
 * tenant.entity.TenantEntity — this is a cross-module contract, consumed
 * exclusively via CoreTenantQueryClient, so it must never leak a
 * tenant-module-only entity type.
 */
public interface TenantQueryService {

  TenantResponse getById(String tenantId);

  /** Every tenant hosted in this realm — a realm is shared by a MASTER_TENANT and all its SUB_TENANTs, so this is never a single tenant. */
  List<TenantResponse> getAllByRealm(String realm);

  /**
   * The given tenant's own id plus every tenant with a MASTER_TENANT-coded
   * relation pointing back at it — the same "self + sub-tenants" scope
   * TenantService.listTenantDirectory applies, exposed here so other
   * modules (e.g. userACL's user directory) can reuse the identical scoping
   * without duplicating the query.
   */
  List<String> getScopedTenantIds(String tenantId);
}
