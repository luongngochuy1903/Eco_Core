package com.ecofood.core.client;

import com.ecofood.core.dto.UserQueryResponse;
import com.ecofood.core.service.UserQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/** Cross-module entry point to UserQueryService — e.g. the auth module calls this, never userACL directly. */
@Service
@RequiredArgsConstructor
public class CoreUserQueryClient {

  private final UserQueryService userQueryService;

  public UserQueryResponse getById(String userId) {
    return userQueryService.getById(userId);
  }

  public UserQueryResponse getByEmail(String email) {
    return userQueryService.getByEmail(email);
  }
}
