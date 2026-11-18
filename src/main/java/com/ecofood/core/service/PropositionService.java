package com.ecofood.core.service;

import com.ecofood.core.dto.*;

public interface PropositionService {
    PropositionResponse create(PropositionCreateRequest request);

    PropositionResponse update(String id, PropositionUpdateRequest request);

    PropositionResponse submit(String id, RevisionRequest request);

    PropositionResponse approve(String id, RevisionRequest request);

    PropositionResponse addPlan(String id, PlanRequest request);

    PropositionResponse updatePlan(String id, String planId, PlanRequest request);

    PropositionResponse removePlan(String id, String planId, RevisionRequest request);

    PropositionResponse approvePlan(String id, String planId, RevisionRequest request);

    PropositionResponse submitPlan(String id, String planId, RevisionRequest request);

    PropositionResponse versionPlan(String id, String planId, RevisionRequest request);

    PropositionCurrencySettingsResponse updateCurrencySettings(
            PropositionCurrencySettingsRequest request);
}
