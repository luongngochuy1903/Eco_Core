package com.ecofood.core.service;
import com.ecofood.core.dto.*;
import java.util.List;
public interface ProductService {
  ProductResponse create(ProductCreateRequest request);
  ProductResponse update(String productId, ProductUpdateRequest request);
  ProductResponse submit(String productId);
  ProductResponse approve(String productId, int version, ProductApproveRequest request);
  ProductResponse reject(String productId, int version, ProductDecisionRequest request);
  ProductResponse newVersion(String productId);
  /** Preview for the approve action — Plans across every Proposition sourced from this Product, currently Pending Review and bound to this version. */
  List<PendingPlanApprovalResponse> pendingPlanApprovals(String productId, int version);
}
