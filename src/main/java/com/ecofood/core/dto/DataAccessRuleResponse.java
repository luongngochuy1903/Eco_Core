package com.ecofood.core.dto;

import com.ecofood.core.enums.AccessEntityTypeEnum;
import com.ecofood.core.enums.AccessLevelEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class DataAccessRuleResponse {
  private String id;
  private String code;
  private String ruleName;
  private String description;
  private String businessEntityId;
  private AccessLevelEnum accessLevel;
  private AccessEntityTypeEnum accessEntityType;
  private int assignedUserCount;
}
