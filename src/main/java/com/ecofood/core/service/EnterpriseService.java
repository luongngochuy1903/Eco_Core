package com.ecofood.core.service;

import com.ecofood.core.dto.EnterpriseCreateRequest;
import com.ecofood.core.dto.EnterpriseResponse;
import com.ecofood.core.enums.PartnerTypeEnum;
import java.util.List;

/**
 * Plain, same-module-facing contract for the enterprise module — implemented
 * only by EnterpriseServiceImpl. Cross-module callers (e.g. TenantServiceImpl)
 * go through CoreEnterpriseClient instead, per this project's module-boundary
 * pattern (see CoreUserClient/UserService).
 */
public interface EnterpriseService {

  EnterpriseResponse createEnterprise(EnterpriseCreateRequest request);

  /** Lists enterprises, optionally filtered to one category — e.g. ENTERPRISE, for the onboarding form's "related enterprise" picker. */
  List<EnterpriseResponse> listEnterprises(PartnerTypeEnum enterpriseCategoryCode);
}
