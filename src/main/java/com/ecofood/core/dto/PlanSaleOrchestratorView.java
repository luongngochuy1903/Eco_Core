package com.ecofood.core.dto;

import java.time.Instant;
import java.util.List;

/** Read-only response contract; persistence remains owned by the application. */
public interface PlanSaleOrchestratorView {
  String getId();
  Long getRevision();
  String getTenantId();
  String getPropositionId();
  String getPlanId();
  Integer getActiveVersion();
  Instant getCreatedAt();
  Instant getUpdatedAt();
  String getCreatedBy();
  String getUpdatedBy();
  List<PlanSaleOrchestratorDtos.ConfigVersion> getVersions();
  List<PlanSaleOrchestratorDtos.Audit> getAudit();
}
