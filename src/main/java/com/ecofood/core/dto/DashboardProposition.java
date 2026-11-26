package com.ecofood.core.dto;
import java.util.List;
public record DashboardProposition(String id, String name, String currency, List<EconomicMetricsRequest> actualMetrics) {}
