package com.ecofood.core.service;

import com.ecofood.core.dto.ProductFamilySaveRequest;
import com.ecofood.core.dto.ProductProcessResponse;

/**
 * Writes/reads a version-1 product process + its 3 attributes for a family
 * id that has no real Product document behind it — today, a Proposition's
 * Plan, which clones a Product's shape (name/description/category/image/
 * ingredients/recipe/costing) but keeps its own identity embedded in its
 * Proposition rather than as a row in the `product` collection. Reuses the
 * exact same `product_process`/attribute collections and CAS-safe write
 * path a real Product uses.
 */
public interface ProductProcessWriteService {
    ProductProcessResponse save(String familyId, ProductFamilySaveRequest request);

    ProductProcessResponse get(String familyId);
}
