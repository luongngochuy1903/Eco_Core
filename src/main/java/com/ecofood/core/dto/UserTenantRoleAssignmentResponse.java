package com.ecofood.core.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * One (tenant, roles) pairing the user currently holds — backs the "Edit
 * User" modal's Access & Permissions section (see UserDetailResponse). One
 * entry per UserRole document the user has (the user_role collection is
 * already tenant-scoped, one document per (user, tenant) pair).
 */
@Data
@AllArgsConstructor
@Builder
public class UserTenantRoleAssignmentResponse {
  private String tenantId;
  private String tenantName;
  private List<RoleSummaryResponse> roles;
}
