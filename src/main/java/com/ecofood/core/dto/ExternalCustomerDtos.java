package com.ecofood.core.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public final class ExternalCustomerDtos {
  private ExternalCustomerDtos() {}
  public record IssueRequest(@NotBlank @Email @Size(max = 320) String email) {}
  public record Issued(String email, String loginUrl, String qrPngBase64) {}
}
