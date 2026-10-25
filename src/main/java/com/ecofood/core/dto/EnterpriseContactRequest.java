package com.ecofood.core.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import java.util.List;
import lombok.Data;

/**
 * Mirrors enterprise.entity.Contact — minus contactPartyId, which is an
 * internal party reference, never set directly by a create request.
 */
@Data
public class EnterpriseContactRequest {

  @NotBlank
  private String contactPartyName;

  @NotBlank
  private String contactPartyLastName;

  private String contactDepartment;
  private String contactDesignation;

  @Valid
  private List<EnterpriseCommunicationRequest> communications;
}
