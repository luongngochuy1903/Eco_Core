package com.ecofood.core.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Public, unauthenticated response for GET /api/v1/tenants/login-info — lets
 * the frontend resolve which Keycloak realm/client to redirect to from a
 * "domain" identifier (the hostname it's running under, or a configured
 * stand-in for local development), before any login attempt. Mirrors
 * DCMP's real TenantController login-info / LoginConfig shape, trimmed to
 * the fields this project's frontend actually needs.
 */
@Data
@AllArgsConstructor
@Builder
public class TenantLoginInfoResponse {
  private String domain;
  private String realm;
  private String clientId;
  private String tenantId;
}
