package com.ecofood.core.dto;

import com.ecofood.core.enums.ComplaintStatusEnum;
import com.ecofood.core.enums.ComplaintTypeEnum;
import jakarta.validation.constraints.*;
import java.time.Instant;
import java.util.List;

public final class ComplaintDtos {
  private ComplaintDtos() {}
  // No customerId, tenantId, status, route or assignee is accepted from Customer.
  public record Create(@NotNull ComplaintTypeEnum complaintType, String invoiceId,
      @NotBlank @Size(max=200) String subject, @NotBlank @Size(max=10000) String description,
      @NotBlank String requestId) {}
  public record Action(@NotNull Long revision, @NotBlank @Size(max=4000) String note,
      ComplaintStatusEnum status, String assignedTo) {}
  public record Reply(@NotNull Long revision, @NotBlank @Size(max=4000) String note) {}
  public record Page<T>(List<T> content, int page, int size, boolean hasNext) {}
  public record Assignee(String id, String name) {}
  public record Capabilities(String tenantId, List<ComplaintTypeEnum> types, boolean manage, boolean assign) {}
  public record Detail(ComplaintView complaint, String customerName, String invoiceNumber) {}
  @org.springframework.data.annotation.TypeAlias("com.ecofood.app.complaint.Complaint$Queue")
  public record Queue(String tenantId, String role) {}
  @org.springframework.data.annotation.TypeAlias("com.ecofood.app.complaint.Complaint$ComplaintEvent")
  public record ComplaintEvent(String id, String complaintId, String actorId, String eventType,
      ComplaintStatusEnum previousStatus, ComplaintStatusEnum newStatus, Instant createdAt, String note) {}
}
