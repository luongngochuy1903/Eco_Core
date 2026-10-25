package com.ecofood.core.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Read shape for tenant.entity.Contact's nested Communication.CommunicationDetail
 * — every field except `preferred` (boolean), per explicit instruction: this
 * response only ever carries non-boolean fields.
 */
@Data
@AllArgsConstructor
@Builder
public class CommunicationDetailResponse {
  private String locationType;
  private String addressLine1;
  private String addressLine2;
  private String isoCityCode;
  private String isoCountryCode;
  private String postalCode;
  private String internationalTelecomCountryCode;
  private String phoneNumber;
  private String emailAddress;
}
