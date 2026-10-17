package com.ecofood.core.service;

import com.ecofood.core.dto.EnterpriseResponse;

/**
 * Plain same-module-facing interface, implemented by enterprise's
 * EnterpriseQueryServiceImpl. Returns EnterpriseResponse (a DTO), never the
 * raw enterprise.entity.EnterpriseEntity — same cross-module-boundary rule
 * as TenantQueryService/UserQueryService.
 */
public interface EnterpriseQueryService {

  EnterpriseResponse getById(String enterpriseId);
}
