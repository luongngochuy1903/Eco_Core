package com.ecofood.core.service;

import com.ecofood.core.dto.EnterpriseResponse;
import java.util.List;

/**
 * Plain same-module-facing interface, implemented by enterprise's
 * EnterpriseQueryServiceImpl. Returns EnterpriseResponse (a DTO), never the
 * raw enterprise.entity.EnterpriseEntity — same cross-module-boundary rule
 * as TenantQueryService/UserQueryService.
 */
public interface EnterpriseQueryService {

  EnterpriseResponse getById(String enterpriseId);

  /**
   * Enterprise ids this enterprise OWNs (its REGIONAL_ENTERPRISE children
   * attached via EnterpriseCreateRequest.relatedEnterpriseId at onboarding —
   * see EnterpriseServiceImpl.createEnterprise's reciprocal OWN relation).
   * Read-scope widening only, never a substitute for the strict single-id
   * ownership check a write/edit path still requires.
   */
  List<String> ownedEnterpriseIds(String enterpriseId);
}
