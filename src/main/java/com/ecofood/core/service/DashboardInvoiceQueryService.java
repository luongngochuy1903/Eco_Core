package com.ecofood.core.service;
import com.ecofood.core.dto.DashboardInvoice;
import java.util.Set;
import org.springframework.data.domain.Page;
public interface DashboardInvoiceQueryService {
  com.ecofood.core.dto.DashboardInvoiceDetail dashboardDetail(String tenant, String id);
  Page<DashboardInvoice> dashboard(String tenant, Set<String> ids, int page, int size);
}
