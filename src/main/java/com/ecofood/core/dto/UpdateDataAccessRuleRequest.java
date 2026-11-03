package com.ecofood.core.dto;

import com.ecofood.core.enums.AccessEntityTypeEnum;
import com.ecofood.core.enums.AccessLevelEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.Data;

/**
 * PUT /api/v1/data-access-rules/{id}. businessEntityId is deliberately NOT
 * editable here (narrower than CreateDataAccessRuleRequest, same convention
 * as TenantUpdateRequest leaving domainUrl/realm/clientId out) — changing
 * which tenant a rule applies to is treated as a bigger operation than this
 * endpoint covers. Only the rule's own creator may call this — see
 * DataAccessRuleServiceImpl.update's ownership check.
 */
@Data
public class UpdateDataAccessRuleRequest {

  @NotBlank
  private String ruleName;

  @NotBlank
  private String description;

  private AccessEntityTypeEnum accessEntityType;

  @NotNull
  private AccessLevelEnum accessLevel;

  private List<String> limitedEntityIds;

  private List<String> userIds;
}
