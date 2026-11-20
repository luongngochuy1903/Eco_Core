package com.ecofood.core.service;

import com.ecofood.core.dto.PreparedSaleTransaction;
import java.util.Map;

/**
 * Internal UC-015 integration point. Caller must enforce TRANSACTION_SUBMIT and supply verified
 * token identity.
 */
public interface SaleOrchestratorRuntime {
  PreparedSaleTransaction prepare(
      String tenantId,
      String authenticatedSubject,
      String orchestratorId,
      Map<String, Object> payload);
}
