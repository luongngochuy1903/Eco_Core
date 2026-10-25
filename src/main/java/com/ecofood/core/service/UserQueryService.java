package com.ecofood.core.service;

import com.ecofood.core.dto.UserQueryResponse;

/**
 * Plain same-module-facing interface, implemented by userACL's
 * UserQueryServiceImpl. Returns UserQueryResponse (a DTO), never the raw
 * userACL.entity.UserEntity — this is a cross-module contract, consumed
 * exclusively via CoreUserQueryClient, so it must never leak a
 * userACL-module-only entity type.
 */
public interface UserQueryService {

  UserQueryResponse getById(String userId);

  /** Resolves by email (case-insensitive) — the identifier the Keycloak login flow is resolved back by, not username. */
  UserQueryResponse getByEmail(String email);
}
