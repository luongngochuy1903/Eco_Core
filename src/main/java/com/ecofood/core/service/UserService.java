package com.ecofood.core.service;

import com.ecofood.core.dto.AssignTenantRolesRequest;
import com.ecofood.core.dto.AssignTenantRolesResponse;
import com.ecofood.core.dto.UserCreateRequest;
import com.ecofood.core.dto.UserResponse;

/** Plain same-module-facing interface, implemented by userACL's UserServiceImpl. */
public interface UserService {

  UserResponse createUser(UserCreateRequest request);

  /** Grants an already-existing user a role on a tenant — never creates a new UserEntity or touches Keycloak. */
  AssignTenantRolesResponse assignTenantRoles(String userId, AssignTenantRolesRequest request);
}
