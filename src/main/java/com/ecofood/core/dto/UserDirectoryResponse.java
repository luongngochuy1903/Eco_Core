package com.ecofood.core.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Backs the "Users" sub-tab directory (GET /api/v1/users/directory) —
 * deliberately narrow, matching exactly the columns the frontend table
 * shows (first name, last name, email, relationship), not the full
 * UserResponse shape used elsewhere.
 *
 * relationship is the relationshipTypeCode of the TENANT-coded
 * PartyToPartyRelationship that put this user in the caller's scope (see
 * UserService.listUserDirectory) — null for a SYSTEM-level caller's result
 * row when that user has no TENANT-type relation at all (e.g. a pure
 * CUSTOMER).
 */
@Data
@AllArgsConstructor
@Builder
public class UserDirectoryResponse {
  private String id;
  private String firstName;
  private String lastName;
  private String email;
  private String relationship;
}
