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

  /**
   * System-level check, bypassing the normal ACL-role read gate every other
   * method here imposes — called from contexts with no human/employee actor
   * at all (a POS/seller submitting a sale) or from a system cascade (Plan
   * approval), neither of which carries an ACL roleGroups claim. Returns
   * false for a missing Product/version rather than throwing, since callers
   * only ever care "is it safe to proceed," not why it isn't.
   */
  boolean isVersionApproved(String productId, int version);
}
