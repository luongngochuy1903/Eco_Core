package com.ecofood.core.service;
import com.ecofood.core.dto.*;
public interface ProductService {
  ProductResponse create(ProductCreateRequest request);
  ProductResponse update(String productId, ProductUpdateRequest request);
  ProductResponse submit(String productId);
  ProductResponse approve(String productId);
  ProductResponse reject(String productId, ProductDecisionRequest request);
  ProductResponse newVersion(String productId);
}
