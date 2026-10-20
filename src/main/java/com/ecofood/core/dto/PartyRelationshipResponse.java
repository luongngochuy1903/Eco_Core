package com.ecofood.core.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Cross-module read shape for one PartyToPartyRelationship entry — used
 * inside UserQueryResponse so a cross-module caller never has to import
 * userACL.entity.PartyToPartyRelationship directly.
 */
@Data
@AllArgsConstructor
@Builder
public class PartyRelationshipResponse {
  private String toPartyId;
  private String relationshipTypeCode;
  private String relationshipReferenceName;
}
