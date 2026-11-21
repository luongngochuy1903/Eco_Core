package com.ecofood.core.service;

import com.ecofood.core.dto.*;
import org.springframework.data.domain.*;

public interface PropositionQueryService {
    Page<PropositionResponse> list(String search, Pageable page);

    PropositionResponse getById(String id);

    PlanResponse getPlan(String id, String planId);

    PropositionOptionsResponse options();

    PropositionCurrencySettingsResponse currencySettings();

    Page<ApprovedProductProcessReference> approvedProcesses(String search, Pageable page);
}
