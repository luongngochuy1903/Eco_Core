package com.ecofood.core.service;

import com.ecofood.core.dto.CustomerDtos;

/** Public module contract. Implementations and persistence belong to backend main. */
public interface CustomerService {
  CustomerDtos.Profile profile();
  CustomerDtos.Profile update(CustomerDtos.UpdateProfile request);
}
