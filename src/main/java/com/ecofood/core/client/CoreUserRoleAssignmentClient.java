package com.ecofood.core.client;

import com.ecofood.core.service.UserRoleAssignmentService;
import com.ecofood.core.enums.PartnerTypeEnum;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

/** Cross-module entry point to UserRoleAssignmentService — e.g. the tenant module calls this, never userACL directly. */
@Service
@RequiredArgsConstructor
public class CoreUserRoleAssignmentClient {

  private final UserRoleAssignmentService userRoleAssignmentService;

  public void assignRoleForOnboarding(ObjectId userId, ObjectId tenantId, PartnerTypeEnum partnerType) {
    userRoleAssignmentService.assignRoleForOnboarding(userId, tenantId, partnerType);
  }
}
