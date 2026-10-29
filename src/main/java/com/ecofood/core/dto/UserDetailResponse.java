package com.ecofood.core.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Backs GET /api/v1/users/{id} — the "Edit User" modal. Basic fields plus
 * tenantAssignments, the Access & Permissions section's current state (one
 * entry per UserRole document the user has — see UserTenantRoleAssignmentResponse).
 */
@Data
@AllArgsConstructor
@Builder
public class UserDetailResponse {
  private String id;
  private String username;
  private String email;
  private String firstName;
  private String lastName;
  private String userCategoryCode;
  private List<UserTenantRoleAssignmentResponse> tenantAssignments;
}
