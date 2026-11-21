package com.ecofood.core.client;

import com.ecofood.core.dto.*;
import com.ecofood.core.service.PropositionQueryService;
import org.springframework.data.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CorePropositionQueryClient {
    private final PropositionQueryService service;

    public Page<PropositionResponse> list(String search, Pageable page) {
        return service.list(search, page);
    }

    public PropositionResponse getById(String id) {
        return service.getById(id);
    }

    public PlanResponse getPlan(String id, String plan) {
        return service.getPlan(id, plan);
    }

    public PropositionOptionsResponse options() {
        return service.options();
    }

    public PropositionCurrencySettingsResponse currencySettings() {
        return service.currencySettings();
    }

    public Page<ApprovedProductProcessReference> approvedProcesses(String search, Pageable page) {
        return service.approvedProcesses(search, page);
    }
}
