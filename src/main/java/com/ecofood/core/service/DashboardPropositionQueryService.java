package com.ecofood.core.service;
import com.ecofood.core.dto.DashboardProposition;
import java.util.*;
public interface DashboardPropositionQueryService {
  List<DashboardProposition> find(String tenantId, Set<String> propositionIds);
}
