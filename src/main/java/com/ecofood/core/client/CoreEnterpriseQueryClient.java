package com.ecofood.core.client;

import com.ecofood.core.dto.EnterpriseResponse;
import com.ecofood.core.service.EnterpriseQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/** Cross-module entry point to EnterpriseQueryService — e.g. userACL calls this, never enterprise's package directly. */
@Service
@RequiredArgsConstructor
public class CoreEnterpriseQueryClient {

  private final EnterpriseQueryService enterpriseQueryService;

  public EnterpriseResponse getById(String enterpriseId) {
    return enterpriseQueryService.getById(enterpriseId);
  }
}
