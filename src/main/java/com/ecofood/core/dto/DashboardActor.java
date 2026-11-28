package com.ecofood.core.dto;
import java.util.Set;
public record DashboardActor(String userId, PropositionTenantReference tenant, Set<String> tenantScope,
    boolean partners, Set<String> entityIds) {}
