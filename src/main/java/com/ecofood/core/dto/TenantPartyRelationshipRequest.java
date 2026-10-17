package com.ecofood.core.dto;

import com.ecofood.core.enums.RelationshipTypeEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * One tenant-to-tenant relationship to record at onboarding time — e.g. this
 * new tenant is a sub-tenant of an already-existing master tenant. Maps onto
 * a PartyToPartyRelationship (the same class UserEntity uses), discriminated
 * by RelationshipTypeEnum's MASTER_TENANT("MT")/SUB_TENANT("ST")/
 * BELONGTO("BL")/OWN("OW") codes.
 *
 * Lives in common as part of TenantService's public interface contract.
 */
@Data
public class TenantPartyRelationshipRequest {

  @NotBlank
  private String toTenantId;

  @NotNull
  private RelationshipTypeEnum relationshipTypeCode;
}
