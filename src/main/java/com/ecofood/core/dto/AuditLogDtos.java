package com.ecofood.core.dto;

import com.ecofood.core.enums.AuditAction;
import com.ecofood.core.enums.AuditOutcome;
import java.time.Instant;
import java.util.List;

public final class AuditLogDtos {
  private AuditLogDtos() {}

  public record Event(String actorId, String tenantId, AuditAction action, String controller,
                      Instant timestamp, AuditOutcome outcome, String requestId) {}
  public record Entry(String id, String actorId, AuditAction action, String module,
                      Instant timestamp, AuditOutcome outcome, String requestId) {}
  public record Filter(String actorId, AuditAction action, String module, Instant from, Instant to,
                       AuditOutcome outcome, int page, int size) {}
  public record Page(List<Entry> content, boolean hasNext) {}
}
