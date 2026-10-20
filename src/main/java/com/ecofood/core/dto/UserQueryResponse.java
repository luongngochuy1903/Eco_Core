package com.ecofood.core.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Cross-module read shape for a user — returned by UserQueryService's
 * getById/getByUsername (via CoreUserQueryClient), never the raw
 * userACL.entity.UserEntity. Covers every field other modules actually read
 * off that entity today (see InternalTokenService), including the full
 * partyRelationships list needed to verify tenant membership.
 */
@Data
@AllArgsConstructor
@Builder
public class UserQueryResponse {
  private String id;
  private String username;
  private String email;
  private String externalLoginId;
  private List<PartyRelationshipResponse> partyRelationships;
}
