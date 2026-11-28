package com.ecofood.core.dto;

import com.ecofood.core.enums.AccessEntityTypeEnum;
import com.ecofood.core.enums.AccessLevelEnum;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/** Data Access Rule contract supporting multiple dashboard entity types. */
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
  /** Legacy single-type field, retained for existing clients and records. */
  private AccessEntityTypeEnum accessEntityType;

  private java.util.List<AccessEntityTypeEnum> accessEntityTypes;
  private List<String> limitedEntityIds;
  private List<String> userIds;
  private boolean editable;
}
