package com.ecofood.core.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Read shape for tenant.entity.Contact's nested Communication — every field
 * except `preferred` (boolean), per explicit instruction.
 */
@Data
@AllArgsConstructor
@Builder
public class CommunicationResponse {
  private String communicationChannelName;
  private List<CommunicationDetailResponse> communicationDetails;
}
