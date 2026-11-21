package com.ecofood.core.dto;

/** Minimal invoice reference exposed to modules after an ownership check. */
public interface CustomerInvoiceReference {
  String getId();
  String getTenantId();
}
