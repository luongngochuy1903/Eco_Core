package com.ecofood.core.client;

import com.ecofood.core.dto.*;
import com.ecofood.core.service.PropositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CorePropositionClient {
    private final PropositionService service;

    public PropositionResponse create(PropositionCreateRequest r) {
        return service.create(r);
    }

    public PropositionResponse update(String id, PropositionUpdateRequest r) {
        return service.update(id, r);
    }

    public PropositionResponse submit(String id, RevisionRequest r) {
        return service.submit(id, r);
    }

    public PropositionResponse approve(String id, RevisionRequest r) {
        return service.approve(id, r);
    }

    public PropositionResponse addPlan(String id, PlanRequest r) {
        return service.addPlan(id, r);
    }

    public PropositionResponse updatePlan(String id, String plan, PlanRequest r) {
        return service.updatePlan(id, plan, r);
    }

    public PropositionResponse removePlan(String id, String plan, RevisionRequest r) {
        return service.removePlan(id, plan, r);
    }

    public PropositionResponse approvePlan(String id, String plan, RevisionRequest r) {
        return service.approvePlan(id, plan, r);
    }

    public PropositionResponse submitPlan(String id, String plan, RevisionRequest r) {
        return service.submitPlan(id, plan, r);
    }

    public PropositionResponse versionPlan(String id, String plan, RevisionRequest r) {
        return service.versionPlan(id, plan, r);
    }

    public PropositionCurrencySettingsResponse updateCurrencySettings(
            PropositionCurrencySettingsRequest r) {
        return service.updateCurrencySettings(r);
    }
}
