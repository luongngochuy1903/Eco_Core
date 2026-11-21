package com.ecofood.core.dto;

import java.time.Instant;

/** Read-only response contract; persistence remains owned by the application. */
public interface NotificationView {
  String getId();
  String getSubmissionId();
  String getTenantId();
  String getRuleId();
  String getType();
  String getChannel();
  long getRuleRevision();
  String getContent();
  String getSubject();
  String getSendFrom();
  String getSendTo();
  String getRecipientUserId();
  String getStatus();
  Instant getCreatedAt();
  Instant getSentAt();
  Instant getNextAttemptAt();
  Instant getLeaseUntil();
  int getRetryCount();
  int getTotalAttempts();
  String getLastError();
  boolean isDeliveryUncertain();
  String getManualRetryBy();
  Instant getManualRetryAt();
}
