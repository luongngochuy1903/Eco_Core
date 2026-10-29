package com.ecofood.core.enums;

/**
 * Which kind of record an Access Control Group (Data Access Rule) governs.
 * Real DCMP's own AccessControlGroupEntityTypeEnum only has one value
 * (PRODUCT) today; this project's domain has 3 — kept as exactly the 3
 * values the frontend's Entity Type checkbox dropdown already uses (see
 * DataAccessRuleDetailPage.jsx's ENTITY_TYPE_OPTIONS), so no extra mapping
 * is needed between what the frontend sends and this enum's constant names.
 *
 * Lives in common (not userACL) — see PartnerTypeEnum's javadoc for why.
 */
public enum AccessEntityTypeEnum {
  Dashboard_bills,
  Dashboard_Customer,
  Product
}
