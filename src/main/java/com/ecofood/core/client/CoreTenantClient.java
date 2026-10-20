package com.ecofood.core.client;

import com.ecofood.core.dto.TenantOnboardRequest;
import com.ecofood.core.dto.TenantOnboardResponse;
import com.ecofood.core.dto.TenantResponse;
import com.ecofood.core.service.TenantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/** Cross-module entry point to TenantService — any OTHER module must call this, never tenant's package directly. */
@Service
@RequiredArgsConstructor
public class CoreTenantClient {

  private final TenantService tenantService;

  public TenantOnboardResponse onboardTenant(TenantOnboardRequest request) {
    return tenantService.onboardTenant(request);
  }

  public TenantResponse getById(String tenantId) {
    return tenantService.getById(tenantId);
  }
}
