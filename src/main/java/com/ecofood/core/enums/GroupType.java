package com.ecofood.core.enums;

/**
 * Discriminates what a Group document actually represents — matches DCMP's
 * real Service_SecurityManagement GroupType exactly (confirmed by reading
 * that class directly). Both kinds live in the SAME "group" collection:
 * ROLE_GROUP is the existing role-hierarchy seed data ACLService.
 * getMaxLevel() reads (e.g. "MASTER_TENANT", "TENANT"); ACCESS_CONTROL_GROUP
 * is a Data Access Rule.
 *
 * Lives in common (not userACL) — see PartnerTypeEnum's javadoc for why.
 */
public enum GroupType {
  ROLE_GROUP,
  ACCESS_CONTROL_GROUP
}
