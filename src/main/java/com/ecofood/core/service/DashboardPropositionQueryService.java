package com.ecofood.core.service;
import com.ecofood.core.dto.DashboardProposition;
import java.util.*;
public interface DashboardPropositionQueryService {
  List<com.ecofood.core.dto.DashboardDtos.Option> invoiceReferences(Set<String> ids);
  List<DashboardProposition> find(String tenantId, Set<String> propositionIds);
}
