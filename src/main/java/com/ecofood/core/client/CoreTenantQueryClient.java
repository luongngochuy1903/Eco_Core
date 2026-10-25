package com.ecofood.core.client;

import com.ecofood.core.dto.TenantResponse;
import com.ecofood.core.service.TenantQueryService;
import java.util.List;
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

  public List<TenantResponse> getAllByRealm(String realm) {
    return tenantQueryService.getAllByRealm(realm);
  }

  public List<String> getScopedTenantIds(String tenantId) {
    return tenantQueryService.getScopedTenantIds(tenantId);
  }
}
