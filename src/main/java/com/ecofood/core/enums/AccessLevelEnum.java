package com.ecofood.core.enums;

/**
 * An Access Control Group's (Data Access Rule's) scope. Real DCMP's own
 * AccessControlLevelEnum has 4 tiers (NO_ACCESS/OPEN_ACCESS/FULL_ACCESS/
 * LIMITED_ACCESS) — deliberately narrowed to these 2 per explicit
 * instruction, matching the frontend's Access Level radio (see
 * DataAccessRuleDetailPage.jsx).
 *
 * Lives in common (not userACL) — see PartnerTypeEnum's javadoc for why.
 */
public enum AccessLevelEnum {
  FULL_ACCESS,
  LIMITED_ACCESS
}
