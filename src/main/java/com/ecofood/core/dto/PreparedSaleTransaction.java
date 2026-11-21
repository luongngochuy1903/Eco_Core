package com.ecofood.core.dto;

import java.util.Map;
import java.util.Set;

/**
 * Schema/DTO-validated Active snapshot. UC-015 still owns totals, idempotency and Invoice
 * persistence.
 */
public record PreparedSaleTransaction(
    String orchestratorId,
    int orchestratorVersion,
    SaleOrchestratorConfig binding,
    SubmitTransactionRequest transaction,
    Map<String, Object> payload,
    Set<String> postWorkflows) {}
