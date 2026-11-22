package com.ecofood.core.service;

import com.ecofood.core.dto.CustomerIdentityDtos;

/** Public module contract. Implementations and persistence belong to backend main. */
public interface CustomerIdentityService {
  CustomerIdentityDtos.LoginConfig config(String tenantId);
  String bootstrap(CustomerIdentityDtos.Bootstrap request);
}
