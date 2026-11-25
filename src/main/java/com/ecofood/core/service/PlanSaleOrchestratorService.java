package com.ecofood.core.service;

import com.ecofood.core.dto.PageResponse;
import com.ecofood.core.dto.PlanSaleOrchestratorDirectoryResponse;
import com.ecofood.core.dto.PlanSaleOrchestratorRequest;
import com.ecofood.core.dto.PlanSaleOrchestratorResponse;

/** Public module contract. Implementations and persistence belong to backend main. */
public interface PlanSaleOrchestratorService {
    PlanSaleOrchestratorResponse get(String propositionId, String id);

    PlanSaleOrchestratorResponse create(String propositionId, PlanSaleOrchestratorRequest request);

    PlanSaleOrchestratorResponse update(String propositionId, String id, PlanSaleOrchestratorRequest request);

    /** One row per Sale Orchestrator visible to the caller's own Tenant in this Proposition. */
    PageResponse<PlanSaleOrchestratorDirectoryResponse> directory(
            String propositionId, int page, int size, String sort, String search);
}
