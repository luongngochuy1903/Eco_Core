package com.ecofood.core.dto;

import java.util.List;

/** UML CatalogOrchestrator: catalog composition, not publication lifecycle or sale execution. */
@org.springframework.data.annotation.TypeAlias("com.ecofood.app.catalog.CatalogOrchestrator")
public record CatalogOrchestrator(String id, List<CustomField> customField, List<String> planId) {
  /** Display metadata only; never a Mongo field path, expression or DTO field selector. */
  @org.springframework.data.annotation.TypeAlias("com.ecofood.app.catalog.CatalogOrchestrator$CustomField")
  public record CustomField(String key, String value) {}
}
