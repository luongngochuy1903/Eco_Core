package com.ecofood.core.dto;

import java.util.List;

/**
 * What CoreProductProcessClient.save needs to (re)write a version-1 product
 * process + its definition/costing/overview attributes for a family id that
 * isn't a real Product — today, a Proposition's Plan. Mirrors the same
 * fields ProductCreateRequest/ProductUpdateRequest carry, minus the parts
 * only a real Product has (type, server-generated code, expectedRevision —
 * the caller's own aggregate, e.g. the Proposition, owns concurrency control).
 */
public record ProductFamilySaveRequest(
        String name,
        String description,
        String category,
        String imageUrl,
        List<ProductIngredientRequest> ingredients,
        ProductRecipeRequest recipe,
        ProductCostingRequest costing,
        ProductPricingRequest pricing) {}
