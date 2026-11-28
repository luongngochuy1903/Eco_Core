package com.ecofood.core.dto;

import com.ecofood.core.enums.AccessEntityTypeEnum;
import com.ecofood.core.enums.AccessLevelEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.Data;

/** Data Access Rule contract supporting multiple dashboard entity types. */
@Data
public class CreateDataAccessRuleRequest {

  @NotBlank
  private String businessEntityId;

  @NotBlank
  private String ruleName;

  @NotBlank
  private String description;

  /** Legacy single-type field, retained for existing clients and records. */
  private AccessEntityTypeEnum accessEntityType;

  private java.util.List<AccessEntityTypeEnum> accessEntityTypes;

  @NotNull
  private AccessLevelEnum accessLevel;

  private List<String> limitedEntityIds;

  private List<String> userIds;
}
