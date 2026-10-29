package com.ecofood.core.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/** A role as embedded on a UserRole/GroupRole — id/code/name only, resolved at read time. */
@Data
@AllArgsConstructor
@Builder
public class RoleSummaryResponse {
  private String id;
  private String code;
  private String name;
}
