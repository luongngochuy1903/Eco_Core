package com.ecofood.core.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.Instant;

public final class ExternalCustomerDtos {
  private ExternalCustomerDtos() {}
  public record IssueRequest(@NotBlank @Size(max = 200) String externalId) {}
  public record TokenRequest(String token) {}
  public record Issued(String id, String externalId, String url, String qrPngBase64, Instant expiresAt) {}
  public record Linked(String externalId) {}
}
