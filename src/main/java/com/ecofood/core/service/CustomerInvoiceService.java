package com.ecofood.core.service;

import com.ecofood.core.dto.CustomerIdentityScope;
import com.ecofood.core.dto.CustomerInvoiceReference;

public interface CustomerInvoiceService {
  CustomerInvoiceReference requireOwned(CustomerIdentityScope actor, String invoiceId);
}
