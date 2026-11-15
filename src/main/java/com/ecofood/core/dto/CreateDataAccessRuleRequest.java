package com.ecofood.core.dto;

import com.ecofood.core.enums.AccessEntityTypeEnum;
import com.ecofood.core.enums.AccessLevelEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.Data;

/**
 * POST /api/v1/data-access-rules — mirrors DataAccessRuleDetailPage.jsx's
 * payload exactly. businessEntityId is the tenant this rule applies for.
 * accessEntityType is a SINGLE value — a rule governs exactly one kind of
 * record (explicit instruction: "fix entity Type that we can only choose
 * 1"; this used to be a list supporting several entity types per rule, each
 * getting its own GroupEntity row — DataAccessRuleServiceImpl now creates
 * just one). limitedEntityIds is only meaningful when accessLevel is
 * LIMITED_ACCESS (ignored otherwise, same convention as the frontend's own
 * handleSave). userIds is who gets this rule — writes to each user's own
 * UserGroupEntity document, not a members list on the rule itself (see
 * DataAccessRuleServiceImpl).
 */
@Data
public class CreateDataAccessRuleRequest {

  @NotBlank
  private String businessEntityId;

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
