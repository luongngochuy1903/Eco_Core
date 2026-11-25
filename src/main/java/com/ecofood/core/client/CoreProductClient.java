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
  public ProductResponse approve(String id, int version) { return service.approve(id, version, null); }
  public ProductResponse reject(String id, int version, ProductDecisionRequest request) { return service.reject(id, version, request); }
  public ProductResponse newVersion(String id) { return service.newVersion(id); }
}
