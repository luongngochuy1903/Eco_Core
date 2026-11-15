package com.ecofood.core.service;
import com.ecofood.core.dto.*;
import com.ecofood.core.enums.*;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
public interface ProductQueryService {
  Page<ProductResponse> list(String search, ProductTypeEnum type, ProductStatusEnum status, Pageable pageable);
  ProductResponse getById(String productId);
  List<ProductVersionResponse> versions(String productId);
  List<ProductProcessResponse> processes(String productId);
  ProductResponse getVersion(String productId,int version);
  /** Public cross-module query: inspect the approved version for future Proposition creation. */
  ProductResponse getApprovedVersion(String productId, int version);
}
