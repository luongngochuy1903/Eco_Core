package com.ecofood.core.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Read shape for tenant.entity.TenantEntity's Contact — every field except
 * boolean ones (see CommunicationResponse/CommunicationDetailResponse for
 * the nested `preferred` exclusions; Contact itself has no boolean fields
 * of its own).
 */
@Data
@AllArgsConstructor
@Builder
public class ContactResponse {
  private String contactPartyId;
  private String contactPartyName;
  private String contactPartyLastName;
  private String contactDepartment;
  private String contactDesignation;
  private List<CommunicationResponse> communications;
}
