package com.ecofood.core.service;

import com.ecofood.core.dto.CustomerDtos;

/** Public module contract. Implementations and persistence belong to backend main. */
public interface CustomerQueryService {
  CustomerDtos.Page<CustomerDtos.OwnedInvoice> invoices(int page, int size);
  CustomerDtos.OwnedInvoice detail(String id);
}
