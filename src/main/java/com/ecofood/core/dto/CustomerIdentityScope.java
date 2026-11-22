package com.ecofood.core.dto;

/** Verified customer identity supplied by the application's access guard. */
public interface CustomerIdentityScope {
  String userId();
  String tenantId();
}
