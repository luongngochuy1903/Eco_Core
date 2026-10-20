package com.ecofood.core.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * One tenant the current internal-token holder is allowed to switch into —
 * returned by GET /api/v1/users/eligible-tenants. Mirrors DCMP's real
 * EligibleTenant shape (tenantId/tenantName/tenantCode), trimmed to the
 * fields this project's frontend actually needs (no favicon/logo yet).
 */
@Data
@AllArgsConstructor
@Builder
public class EligibleTenantResponse {
  private String tenantId;
  private String tenantName;
  private String tenantCode;

  /** The origin this tenant's frontend is actually served from — where the frontend navigates to on switch. */
  private String domainUrl;
}
