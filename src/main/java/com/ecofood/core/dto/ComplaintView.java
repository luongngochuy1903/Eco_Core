package com.ecofood.core.dto;

import com.ecofood.core.enums.ComplaintStatusEnum;
import com.ecofood.core.enums.ComplaintTypeEnum;
import java.time.Instant;
import java.util.List;

/** Read-only response contract; persistence remains owned by the application. */
public interface ComplaintView {
  String getId();
  ComplaintTypeEnum getComplaintType();
  String getCustomerId();
  String getCustomerTenantId();
  String getInvoiceId();
  String getTenantId();
  String getSubject();
  String getDescription();
  String getAssignedTo();
  ComplaintStatusEnum getStatus();
  Instant getCreatedAt();
  Instant getUpdatedAt();
  Instant getResolvedAt();
  Instant getClosedAt();
  long getRevision();
  ComplaintDtos.Queue getQueue();
  List<ComplaintDtos.ComplaintEvent> getEvents();
}
