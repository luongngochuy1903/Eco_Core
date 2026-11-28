package com.ecofood.core.client;
import com.ecofood.core.dto.DashboardActor;
import com.ecofood.core.enums.AccessEntityTypeEnum;
import com.ecofood.core.service.DashboardAccessQueryService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@Service @RequiredArgsConstructor
public class CoreDashboardAccessClient {
  private final DashboardAccessQueryService service;
  public DashboardActor current() { return service.current(); }
  public DashboardActor current(AccessEntityTypeEnum type, String tenant) { return service.current(type, tenant); }
  public List<DashboardActor> tenantOptions(AccessEntityTypeEnum type) { return service.tenantOptions(type); }
  public List<DashboardActor> authorizedTenants(AccessEntityTypeEnum type) { return service.authorizedTenants(type); }
  public List<DashboardActor> scopedTenants(AccessEntityTypeEnum type, String root) { return service.scopedTenants(type, root); }
  public List<com.ecofood.core.dto.DashboardDtos.Option> selectableTenants(AccessEntityTypeEnum type) { return service.selectableTenants(type); }
}
