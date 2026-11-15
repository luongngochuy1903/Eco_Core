package com.ecofood.core.dto;

import com.ecofood.core.enums.AccessEntityTypeEnum;
import com.ecofood.core.enums.AccessLevelEnum;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Backs GET /api/v1/data-access-rules/{id} — the "Edit Data Access Rule"
 * modal, same concept as TenantResponse/UserDetailResponse. editable is
 * server-computed (AuthenticationContext.getUserId() vs the rule's own
 * createdBy — only the rule's creator may edit it), so the frontend never
 * has to independently re-derive that authorization decision.
 */
@Data
@AllArgsConstructor
@Builder
public class DataAccessRuleDetailResponse {
  private String id;
  private String code;
  private String ruleName;
  private String description;
  private String businessEntityId;
  private String businessEntityName;
  private AccessLevelEnum accessLevel;
  private AccessEntityTypeEnum accessEntityType;
  private List<String> limitedEntityIds;
  private List<String> userIds;
  private boolean editable;
}
