package com.ecofood.core.service;
import com.ecofood.core.dto.DashboardActor;
import com.ecofood.core.enums.AccessEntityTypeEnum;
import java.util.List;
public interface DashboardAccessQueryService {
  DashboardActor current();
  DashboardActor current(AccessEntityTypeEnum type, String tenantId);
  List<DashboardActor> authorizedTenants(AccessEntityTypeEnum type);
}
