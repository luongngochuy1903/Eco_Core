package com.ecofood.core.dto;

import com.ecofood.core.enums.UserCategoryEnum;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * POST /api/v1/users — creates a user and assigns them to one or more
 * tenants in the same call. userCategoryCode is a per-USER classification
 * (a user is fundamentally a tenant user or a customer, not several at
 * once) — it does NOT vary per tenant assignment, unlike tenantId/
 * relationshipTypeCode which do (see TenantAssignmentRequest), since a
 * single person can be assigned to multiple tenants (e.g. an agency admin
 * managing several client tenants), each mirrored into its own Keycloak
 * realm.
 *
 * Lives in common (not userACL) as part of UserService's public interface
 * contract, consumed by other modules via CoreUserClient.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCreateRequest {

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

  private UserCategoryEnum userCategoryCode;

  @NotEmpty
  @Valid
  private List<TenantAssignmentRequest> tenantAssignments;
}
