package com.ecofood.core.service;

import com.ecofood.core.dto.SaleOrchestratorConfig;
import java.util.Optional;

public interface SaleOrchestratorConfigProvider {
  Optional<SaleOrchestratorConfig> findForPos(String tenantId, String authenticatedSubject);
}
