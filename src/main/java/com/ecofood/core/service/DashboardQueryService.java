package com.ecofood.core.service;

import com.ecofood.core.dto.DashboardDtos;

import java.util.List;

/** Public module contract. Implementations and persistence belong to backend main. */
public interface DashboardQueryService {
  DashboardDtos.Summary summary(DashboardDtos.Selection selection);
  List<DashboardDtos.Summary> trends(DashboardDtos.Selection selection);
  DashboardDtos.Comparison comparison(DashboardDtos.Selection selection);
  DashboardDtos.Filters filters();
}
