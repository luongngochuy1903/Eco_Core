package com.ecofood.core.dto;

import com.ecofood.core.enums.AccessLevelEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Backs the Data Access Rules directory (GET /api/v1/data-access-rules/directory)
 * — deliberately narrow, matching exactly the columns the frontend table
 * shows, not the full DataAccessRuleResponse shape POST returns. businessEntityName
 * is read directly off the Group's own denormalized partyRelationships
 * (set at creation time), so listing never needs an extra tenant lookup.
 */
@Data
@AllArgsConstructor
@Builder
public class DataAccessRuleDirectoryResponse {
  private String id;
  private String code;
  private String ruleName;
  private String businessEntityName;
  private AccessLevelEnum accessLevel;
}
