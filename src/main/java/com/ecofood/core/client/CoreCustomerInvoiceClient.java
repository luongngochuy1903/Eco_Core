package com.ecofood.core.client;

import com.ecofood.core.dto.CustomerIdentityScope;
import com.ecofood.core.dto.CustomerInvoiceReference;
import com.ecofood.core.service.CustomerInvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/** Cross-module delegate; ownership rules remain implemented by the customer module. */
@Service
@RequiredArgsConstructor
public class CoreCustomerInvoiceClient {
  private final CustomerInvoiceService service;

  public CustomerInvoiceReference requireOwned(CustomerIdentityScope actor, String invoiceId) {
    return service.requireOwned(actor, invoiceId);
  }
}
