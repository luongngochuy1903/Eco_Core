package com.ecofood.core.dto;

import com.ecofood.core.enums.PartnerTypeEnum;
import com.ecofood.core.enums.TenantTypeEnum;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.util.List;
import lombok.Data;

/**
 * POST /api/v1/tenants — onboards a brand-new tenant (its own Keycloak
 * realm + public client) AND its first user in one call, delegating to the
 * same UserServiceImpl.createUser(...) path POST /api/v1/users uses.
 *
 * contact is required for every partnerTypeCode — every tenant has a
 * primary contact, stored on TenantEntity.contact. For ENTERPRISE/
 * REGIONAL_ENTERPRISE it is ALSO copied onto the companion EnterpriseEntity
 * created alongside the tenant (see TenantServiceImpl.onboardTenant).
 * relatedEnterpriseId only matters for ENTERPRISE/REGIONAL_ENTERPRISE —
 * ignored otherwise. It is the TENANT id of the already-existing
 * ENTERPRISE/REGIONAL_ENTERPRISE this one belongs to — the SAME id space as
 * partyRelationships[].toTenantId, never a raw Enterprise-collection id;
 * TenantServiceImpl.resolveRelatedEnterpriseId translates it into that
 * tenant's own EnterpriseEntity id before it reaches
 * EnterpriseCreateRequest.relatedEnterpriseId. See EnterpriseServiceImpl for
 * the resulting BELONGTO("BL")/OWN("OW") relation pair.
 *
 * Lives in common as part of TenantService's public interface contract.
 */
@Data
public class TenantOnboardRequest {

  @NotBlank
  private String tenantName;

  // Keycloak's own username validator rejects whitespace (error-username-
  // invalid-character) — catching it here gives a clear 400 instead of a
  // cryptic failure deep inside the Keycloak Admin API call.
  @NotBlank
  @Pattern(regexp = "\\S+", message = "must not contain whitespace")
  private String username;

  @NotBlank
  @Email
  private String email;

  private String firstName;

  private String lastName;

  private String domainUrl;

  /** Defaults to STANDALONE server-side when omitted — see TenantServiceImpl.onboardTenant. */
  private TenantTypeEnum tenantType;

  @NotNull
  private PartnerTypeEnum partnerTypeCode;

  private String partnerTypeDescription;

  @Valid
  private List<TenantPartyRelationshipRequest> partyRelationships;

  @NotNull
  @Valid
  private EnterpriseContactRequest contact;

  private String relatedEnterpriseId;
}
