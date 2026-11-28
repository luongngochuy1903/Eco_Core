package com.ecofood.core.service;

import com.ecofood.core.dto.CreateDataAccessRuleRequest;
import com.ecofood.core.dto.DataAccessRuleDetailResponse;
import com.ecofood.core.dto.DataAccessRuleDirectoryResponse;
import com.ecofood.core.dto.DataAccessRuleResponse;
import com.ecofood.core.dto.PageResponse;
import com.ecofood.core.dto.UpdateDataAccessRuleRequest;

/**
 * Plain same-module-facing interface, implemented by userACL's
 * DataAccessRuleServiceImpl — same convention as TenantService/UserService.
 */
public interface DataAccessRuleService {

  /** DAR-specific Business Entity picker, including Regional children connected by OW/BL. */
  java.util.List<com.ecofood.core.dto.DashboardDtos.Option> eligibleTenants();

  java.util.List<com.ecofood.core.dto.UserDirectoryResponse> eligibleUsers(String tenantId);

  /** Deletes a rule and revokes its assignments; only its creator may delete. */
  void delete(String id);

  DataAccessRuleResponse create(CreateDataAccessRuleRequest request);

  /** Backs the "Edit Data Access Rule" modal — see DataAccessRuleDetailResponse's javadoc on the editable flag. */
  DataAccessRuleDetailResponse getById(String id);

  /** Only the rule's own creator may call this — see DataAccessRuleServiceImpl.update's ownership check. */
  DataAccessRuleDetailResponse update(String id, UpdateDataAccessRuleRequest request);

  /**
   * Backs the "Data Access Rules" list — role-scoped via the caller's
   * ACLService.getMaxLevel(): SYSTEM sees every
   * rule platform-wide; ENTERPRISE/MASTER_TENANT see every rule whose
   * business entity is their own tenant, a direct MT child, or a Regional
   * child connected by OW/BL (specific to DAR; the Tenant directory is unchanged); TENANT
   * sees only rules for its own tenant; CUSTOMER/NONE are rejected. search,
   * when non-blank, is a case-insensitive regex "contains" match on the
   * rule name. sort is "field,direction", defaulting to "updatedAt,desc".
   */
  PageResponse<DataAccessRuleDirectoryResponse> listDirectory(int page, int size, String sort, String search);
}
