package com.ecofood.core.dto;

import java.time.Instant;
import java.util.List;

/**
 * Backs the "Sale Orchestrator" directory tab (GET
 * /api/v1/propositions/{propositionId}/sale-orchestrators/directory) — one
 * row per Sale Orchestrator, same "table of records, click a row to open its
 * own edit page" convention as the Plans directory. A Sale Orchestrator can
 * cover many Plans at once, so `planNames` is a joined display list rather
 * than a single Plan reference.
 */
public record PlanSaleOrchestratorDirectoryResponse(
        String id,
        String name,
        String description,
        List<String> planIds,
        List<String> planNames,
        Instant updatedAt) {}
