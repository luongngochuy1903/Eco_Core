package com.ecofood.core.client;
import com.ecofood.core.dto.*;
import com.ecofood.core.enums.*;
import com.ecofood.core.service.ProductQueryService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
@Service @RequiredArgsConstructor
public class CoreProductQueryClient {
  private final ProductQueryService service;
  public Page<ProductResponse> list(String search, ProductTypeEnum type, ProductStatusEnum status, Pageable page) {
    return service.list(search,type,status,page);
  }
  public ProductResponse getById(String id) { return service.getById(id); }
  public List<ProductVersionResponse> versions(String id) { return service.versions(id); }
  public List<ProductProcessResponse> processes(String id) { return service.processes(id); }
  public ProductResponse getVersion(String id,int version) { return service.getVersion(id,version); }
  public ProductResponse getApprovedVersion(String id,int version) { return service.getApprovedVersion(id,version); }
}
