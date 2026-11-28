package com.ecofood.core.service;
import com.ecofood.core.dto.DashboardActor;
import com.ecofood.core.enums.AccessEntityTypeEnum;
import java.util.List;
public interface DashboardAccessQueryService {
  DashboardActor current();
  DashboardActor current(AccessEntityTypeEnum type, String tenantId);
  List<DashboardActor> tenantOptions(AccessEntityTypeEnum type);
  List<DashboardActor> authorizedTenants(AccessEntityTypeEnum type);
  /** Authorized own-data actors beneath the selected root, after validating every DAR edge. */
  List<DashboardActor> scopedTenants(AccessEntityTypeEnum type, String rootTenantId);
  /** Selection containers may be accessible via descendants even without an own-data grant. */
  List<com.ecofood.core.dto.DashboardDtos.Option> selectableTenants(AccessEntityTypeEnum type);
}
