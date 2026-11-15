package com.ecofood.core.client;

import com.ecofood.core.dto.CreateDataAccessRuleRequest;
import com.ecofood.core.dto.DataAccessRuleDetailResponse;
import com.ecofood.core.dto.DataAccessRuleDirectoryResponse;
import com.ecofood.core.dto.DataAccessRuleResponse;
import com.ecofood.core.dto.PageResponse;
import com.ecofood.core.dto.UpdateDataAccessRuleRequest;
import com.ecofood.core.service.DataAccessRuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/** Cross-module entry point to DataAccessRuleService — any OTHER module must call this, never userACL's package directly. */
@Service
@RequiredArgsConstructor
public class CoreDataAccessRuleClient {

  private final DataAccessRuleService dataAccessRuleService;

  public DataAccessRuleResponse create(CreateDataAccessRuleRequest request) {
    return dataAccessRuleService.create(request);
  }

  public PageResponse<DataAccessRuleDirectoryResponse> listDirectory(int page, int size, String sort, String search) {
    return dataAccessRuleService.listDirectory(page, size, sort, search);
  }

  public DataAccessRuleDetailResponse getById(String id) {
    return dataAccessRuleService.getById(id);
  }

  public DataAccessRuleDetailResponse update(String id, UpdateDataAccessRuleRequest request) {
    return dataAccessRuleService.update(id, request);
  }
}
