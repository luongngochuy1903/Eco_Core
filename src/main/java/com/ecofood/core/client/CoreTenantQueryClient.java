package com.ecofood.core.client;

import com.ecofood.core.dto.TenantResponse;
import com.ecofood.core.service.TenantQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/** Cross-module entry point to TenantQueryService — e.g. userACL/auth call this, never tenant's package directly. */
@Service
@RequiredArgsConstructor
public class CoreTenantQueryClient {

  private final TenantQueryService tenantQueryService;

  public TenantResponse getById(String tenantId) {
    return tenantQueryService.getById(tenantId);
  }

  public TenantResponse getByRealm(String realm) {
    return tenantQueryService.getByRealm(realm);
  }
}
