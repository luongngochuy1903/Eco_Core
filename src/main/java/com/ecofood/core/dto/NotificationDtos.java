package com.ecofood.core.dto;

import java.time.Instant;
import java.util.List;

public final class NotificationDtos {
  private NotificationDtos() {}
  @org.springframework.data.annotation.TypeAlias("com.ecofood.app.notification.NotificationRule$Recipients")
  public record Recipients(List<String> userIds, List<String> roles, List<String> permissions,
                           boolean invoiceCustomer, List<String> emails, Boolean complaintCustomer) {
    public Recipients(List<String> userIds, List<String> roles, List<String> permissions, boolean invoiceCustomer, List<String> emails) {
      this(userIds,roles,permissions,invoiceCustomer,emails,false);
    }
  }
  @org.springframework.data.annotation.TypeAlias("com.ecofood.app.notification.NotificationRule$Change")
  public record Change(long revision, Instant at, String actor, String action) {}
  @com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
  public record RuleRequest(String name, String eventType, boolean enabled, NotificationDtos.Recipients recipients,
                            String subject, String content, Long revision) {}
  public record EnabledRequest(boolean enabled, long revision) {}
  public record RetryRequest(boolean acknowledgeDuplicateRisk) {}
  public record Page<T>(List<T> content, int page, int size, boolean hasNext) {}
}
