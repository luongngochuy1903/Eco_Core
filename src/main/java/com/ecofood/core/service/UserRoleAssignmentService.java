package com.ecofood.core.service;

import com.ecofood.core.enums.PartnerTypeEnum;
import org.bson.types.ObjectId;

/** Plain same-module-facing interface, implemented by userACL's UserRoleAssignmentServiceImpl. */
public interface UserRoleAssignmentService {

  void assignRoleForOnboarding(ObjectId userId, ObjectId tenantId, PartnerTypeEnum partnerType);
}
