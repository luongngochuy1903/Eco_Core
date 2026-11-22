package com.ecofood.core.dto;

public final class CustomerIdentityDtos {
  private CustomerIdentityDtos() {}
  public record LoginConfig(String tenantId, String realm, String clientId, boolean registrationEnabled) {}
  public record Bootstrap(String accessToken, String tenantId, boolean register) {}
}
