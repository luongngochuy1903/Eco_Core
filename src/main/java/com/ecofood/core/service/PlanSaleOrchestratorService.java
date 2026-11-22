package com.ecofood.core.service;

import com.ecofood.core.dto.PlanSaleOrchestratorDtos;
import com.ecofood.core.dto.PlanSaleOrchestratorView;

import java.util.Optional;

/** Public module contract. Implementations and persistence belong to backend main. */
public interface PlanSaleOrchestratorService {
  Optional<? extends PlanSaleOrchestratorView> get(String proposition, String plan);
  PlanSaleOrchestratorView create(String proposition, String plan, PlanSaleOrchestratorDtos.Save request);
  PlanSaleOrchestratorView edit(String proposition, String plan, PlanSaleOrchestratorDtos.Save request);
  PlanSaleOrchestratorView version(String proposition, String plan, PlanSaleOrchestratorDtos.Revision request);
  PlanSaleOrchestratorDtos.Validation validate(String proposition, String plan, PlanSaleOrchestratorDtos.Revision request);
  PlanSaleOrchestratorView activate(String proposition, String plan, PlanSaleOrchestratorDtos.Revision request);
}
