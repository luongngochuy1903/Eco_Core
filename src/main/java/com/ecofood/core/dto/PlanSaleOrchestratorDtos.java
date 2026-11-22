package com.ecofood.core.dto;

import com.ecofood.core.enums.PlanSaleOrchestratorStatusEnum;
import com.ecofood.core.enums.PlanSaleWorkflowEnum;
import java.time.Instant;
import java.util.List;
import java.util.Set;

public final class PlanSaleOrchestratorDtos {
  private PlanSaleOrchestratorDtos() {}
  @com.fasterxml.jackson.annotation.JsonIgnoreProperties("posBindings")
  @org.springframework.data.annotation.TypeAlias("com.ecofood.app.orchestrator.PlanSaleOrchestrator$Configuration")
  public record Configuration(
      String name,
      String description,
      int maxItems,
      SalePayloadSchema payloadSchema,
      Set<PlanSaleWorkflowEnum> postWorkflows) {
    public Configuration {
      postWorkflows = postWorkflows == null ? Set.of() : Set.copyOf(postWorkflows);
    }
  }
  @org.springframework.data.annotation.TypeAlias("com.ecofood.app.orchestrator.PlanSaleOrchestrator$ConfigVersion")
  public record ConfigVersion(
      int version,
      PlanSaleOrchestratorStatusEnum status,
      Configuration configuration,
      Instant createdAt,
      String createdBy,
      Instant updatedAt,
      String updatedBy,
      Instant activatedAt,
      String activatedBy) {}
  @org.springframework.data.annotation.TypeAlias("com.ecofood.app.orchestrator.PlanSaleOrchestrator$Audit")
  public record Audit(String action, int version, Instant at, String actor) {}
  public record Save(Long expectedRevision, Configuration configuration) {}
  public record Revision(Long expectedRevision) {}
  public record Validation(boolean valid, List<String> errors) {}
}
