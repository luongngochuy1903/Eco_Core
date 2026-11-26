package com.ecofood.core.client;
import com.ecofood.core.dto.DashboardProposition;
import com.ecofood.core.service.DashboardPropositionQueryService;
import java.util.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@Service @RequiredArgsConstructor
public class CoreDashboardPropositionClient {
  private final DashboardPropositionQueryService service;
  public List<DashboardProposition> find(String tenant, Set<String> ids) { return service.find(tenant, ids); }
}
