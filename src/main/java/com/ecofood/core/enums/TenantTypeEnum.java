package com.ecofood.core.enums;

/**
 * Classifies a tenant's standing in the tenant hierarchy, independent of
 * the generic partyRelationships list — a tenant with tenantType=SUB_TENANT
 * is expected to also carry a partyRelationships entry whose
 * relationshipTypeCode is RelationshipTypeEnum.MASTER_TENANT, pointing at
 * the master tenant it belongs to (see TenantOnboardRequest/
 * TenantServiceImpl.onboardTenant). STANDALONE is the default for a tenant
 * with no such relation.
 *
 * Lives in common since it's part of TenantOnboardRequest/TenantResponse's
 * public cross-module contract.
 */
public enum TenantTypeEnum {
  STANDALONE,
  MASTER_TENANT,
  SUB_TENANT
}
