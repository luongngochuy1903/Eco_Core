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
  /**
   * The platform admin tenant — not scoped to any Enterprise/Master/Tenant
   * hierarchy (see app/docs/ACL_ROLE_MODEL.md §1.1). Exactly one may ever
   * exist across the whole platform; see TenantServiceImpl.onboardTenant's
   * uniqueness guard.
   */
  ECO,
  ENTERPRISE,
  REGIONAL_ENTERPRISE,
  ECOSYSTEM_PARTNER,
  BRAND
}
