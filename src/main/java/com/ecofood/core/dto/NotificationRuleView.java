package com.ecofood.core.dto;

import java.time.Instant;
import java.util.List;

/** Read-only response contract; persistence remains owned by the application. */
public interface NotificationRuleView {
  String getId();
  String getTenantId();
  String getName();
  String getEventType();
  String getChannel();
  boolean isEnabled();
  NotificationDtos.Recipients getRecipients();
  String getSubject();
  String getContent();
  long getRevision();
  Instant getCreatedAt();
  Instant getUpdatedAt();
  String getCreatedBy();
  String getUpdatedBy();
  List<NotificationDtos.Change> getAudit();
}
