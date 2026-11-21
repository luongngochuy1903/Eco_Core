package com.ecofood.core.client;
import com.ecofood.core.dto.*;
import com.ecofood.core.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
/** Public cross-module delegate. Do not import product.service implementation directly. */
@Service @RequiredArgsConstructor
public class CoreProductClient {
  private final ProductService service;
  public ProductResponse create(ProductCreateRequest request) { return service.create(request); }
  public ProductResponse update(String id, ProductUpdateRequest request) { return service.update(id, request); }
  public ProductResponse submit(String id) { return service.submit(id); }
  public ProductResponse approve(String id) { return service.approve(id); }
  public ProductResponse reject(String id, ProductDecisionRequest request) { return service.reject(id, request); }
  public ProductResponse newVersion(String id) { return service.newVersion(id); }
}
