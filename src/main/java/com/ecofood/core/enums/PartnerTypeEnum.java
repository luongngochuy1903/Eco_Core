package com.ecofood.core.enums;

/**
 * NOT a DCMP-sourced enum — confirmed by research that real DCMP's role
 * eligibility is driven by tenantCategory/relationship-type, not any
 * partnerType field. This is this project's own business rule: a tenant's
 * partnerType at onboarding decides which admin role its first user gets
 * (see UserRoleAssignmentService).
 *
 * Lives in common (not userACL) since it's part of the public cross-module
 * contract (TenantOnboardRequest, EnterpriseCreateRequest, Core*Client
 * method signatures) — moving it here keeps those contracts free of any
 * userACL-module import, ahead of common/ being split into its own artifact.
 */
public enum PartnerTypeEnum {
  ENTERPRISE,
  REGIONAL_ENTERPRISE,
  ECOSYSTEM_PARTNER,
  BRAND
}
