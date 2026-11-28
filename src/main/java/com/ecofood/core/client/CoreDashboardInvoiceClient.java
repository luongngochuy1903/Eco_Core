package com.ecofood.core.client;
import com.ecofood.core.dto.DashboardInvoice;
import com.ecofood.core.service.DashboardInvoiceQueryService;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
@Service @RequiredArgsConstructor
public class CoreDashboardInvoiceClient {
  private final DashboardInvoiceQueryService service;
  public com.ecofood.core.dto.DashboardInvoiceDetail detail(String tenant, String id) { return service.dashboardDetail(tenant, id); }
  public Page<DashboardInvoice> dashboard(String tenant, Set<String> ids, int page, int size) { return service.dashboard(tenant, ids, page, size); }
  public Page<DashboardInvoice> dashboard(java.util.Map<String, Set<String>> tenants, int page, int size) { return service.dashboard(tenants, page, size); }
}
