package com.ecofood.core.service;

import com.ecofood.core.dto.*;
import org.springframework.data.domain.*;

public interface PropositionQueryService {
    Page<PropositionResponse> list(String search, Pageable page);

    PropositionResponse getById(String id);

    PlanResponse getPlan(String id, String planId);

    /** One row per Plan visible to the caller — backs the "Plans & Market Configuration" directory tab. */
    PageResponse<PlanResponse> planDirectory(String id, int page, int size, String sort, String search);

    PropositionOptionsResponse options();

    PropositionCurrencySettingsResponse currencySettings();

    Page<ApprovedProductProcessReference> approvedProcesses(String search, Pageable page);
}
