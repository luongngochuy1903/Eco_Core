package com.ecofood.core.enums;

/**
 * Matches DCMP's real Service_Core UserCategoryEnum exactly (constants,
 * code, and description — confirmed by reading that class directly).
 *
 * Lives in common (not userACL) — see PartnerTypeEnum's javadoc for why.
 */
public enum UserCategoryEnum {
  CUSTOMER("CUSTOMER", "Customer user"),
  PARTNER("PARTNER", "Partner user");

  private final String code;
  private final String description;

  UserCategoryEnum(String code, String description) {
    this.code = code;
    this.description = description;
  }

  public String getCode() {
    return code;
  }

  public String getDescription() {
    return description;
  }
}
