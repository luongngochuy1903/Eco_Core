package com.ecofood.core.service;

import com.ecofood.core.dto.DomainAvailabilityResponse;
import com.ecofood.core.dto.PageResponse;
import com.ecofood.core.dto.TenantLoginInfoResponse;
import com.ecofood.core.dto.TenantOnboardRequest;
import com.ecofood.core.dto.TenantOnboardResponse;
import com.ecofood.core.dto.TenantResponse;
import com.ecofood.core.dto.TenantUpdateRequest;
import com.ecofood.core.enums.TenantTypeEnum;
import java.util.List;

/**
 * Plain same-module-facing interface, implemented by tenant's TenantServiceImpl.
 * getById returns TenantResponse (a DTO), never the raw tenant.entity.TenantEntity
 * — same cross-module-boundary rule as TenantQueryService.
 */
public interface TenantService {

  TenantOnboardResponse onboardTenant(TenantOnboardRequest request);

  /**
   * One tenant's full detail, by id — backs the directory table's row-click
   * popup (GET /api/v1/tenants/{id}). Not scoped by caller/role: any
   * authenticated caller can resolve any tenant id today, since this
   * predates listTenantDirectory's role-scoping and was never revisited —
   * a known gap, not a deliberate decision.
   */
  TenantResponse getById(String tenantId);

  /** Resolves a frontend-supplied "domain" (hostname, or a dev stand-in) to its tenant's login config. */
  TenantLoginInfoResponse getLoginInfoByDomain(String domain);

  /** Lists every tenant, optionally filtered to one tenantType — e.g. MASTER_TENANT, for the onboarding form's master-tenant picker. */
  List<TenantResponse> listTenants(TenantTypeEnum tenantType);

  /** Checks whether a full domain (e.g. "gamma.ecofood.com" or "master.ecofood.com/sub") is already taken by an existing tenant. */
  DomainAvailabilityResponse checkDomainAvailability(String domainUrl);

  /**
   * The platform's one ECO tenant — every other tenant's domain is a
   * subdomain of ITS domainUrl (see TenantOnboardingPage's rootDomain
   * usage). Throws if the platform hasn't been bootstrapped yet.
   */
  TenantResponse getRootTenant();

  /**
   * Backs the "Tenant" sub-tab directory — role-scoped via the caller's
   * ACLService.getMaxLevel(): SYSTEM sees every tenant platform-wide;
   * ENTERPRISE/MASTER_TENANT/TENANT see their own tenant plus every tenant
   * that belongs to it (a MASTER_TENANT-coded relation pointing back at it)
   * — for a TENANT-level caller this is always just itself, since a
   * sub-tenant can never have further sub-tenants of its own; CUSTOMER/NONE
   * are rejected (the "Tenant" sub-tab isn't meaningful for them). search,
   * when non-blank, is a case-insensitive regex "contains"
   * match on tenantName. sort is "field,direction" (e.g. "tenantName,asc"),
   * defaulting to "updatedAt,desc" when null/blank; only a small whitelist of
   * fields is accepted.
   */
  PageResponse<TenantResponse> listTenantDirectory(int page, int size, String sort, String search);

  /**
   * Updates exactly the fields the frontend's edit form exposes as editable
   * — tenantName and contact (see TenantUpdateRequest javadoc for why it's
   * this narrow). Role-scoped like listTenantDirectory: SYSTEM may update
   * any tenant; ENTERPRISE/MASTER_TENANT/TENANT may only update their own
   * tenant or (for ENTERPRISE/MASTER_TENANT) one of its sub-tenants —
   * unlike the read-only directory, a TENANT-level caller can ONLY ever
   * update itself, never a sub-tenant (it has none); CUSTOMER/NONE are
   * rejected entirely. Throws if the tenant doesn't exist or the caller
   * isn't allowed to touch it.
   */
  TenantResponse updateTenant(String tenantId, TenantUpdateRequest request);
}
