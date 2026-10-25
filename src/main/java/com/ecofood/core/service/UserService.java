package com.ecofood.core.service;

import com.ecofood.core.dto.AssignTenantRolesRequest;
import com.ecofood.core.dto.AssignTenantRolesResponse;
import com.ecofood.core.dto.EligibleTenantResponse;
import com.ecofood.core.dto.PageResponse;
import com.ecofood.core.dto.UserCreateRequest;
import com.ecofood.core.dto.UserDirectoryResponse;
import com.ecofood.core.dto.UserResponse;
import java.util.List;

/** Plain same-module-facing interface, implemented by userACL's UserServiceImpl. */
public interface UserService {

  UserResponse createUser(UserCreateRequest request);

  /** Grants an already-existing user a role on a tenant — never creates a new UserEntity or touches Keycloak. */
  AssignTenantRolesResponse assignTenantRoles(String userId, AssignTenantRolesRequest request);

  /** Tenants the given user has a direct TENANT relationship to — the tenants they're allowed to switch into. */
  List<EligibleTenantResponse> getEligibleTenants(String userId);

  /**
   * Backs the "Users" sub-tab directory — role-scoped via the caller's
   * ACLService.getMaxLevel(), the exact same policy as TenantService.
   * listTenantDirectory: SYSTEM sees every user platform-wide; ENTERPRISE/
   * MASTER_TENANT see every user with a TENANT-coded relation to their own
   * tenant or one of its sub-tenants; TENANT sees only users related to its
   * own tenant; CUSTOMER/NONE are rejected. search, when non-blank, is a
   * case-insensitive regex "contains" match across firstName/lastName/
   * email. sort is "field,direction", defaulting to "updatedAt,desc".
   */
  PageResponse<UserDirectoryResponse> listUserDirectory(int page, int size, String sort, String search);
}
