package com.ecofood.core.client;

import com.ecofood.core.dto.ProductFamilySaveRequest;
import com.ecofood.core.dto.ProductProcessResponse;
import com.ecofood.core.service.ProductProcessWriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CoreProductProcessClient {
    private final ProductProcessWriteService service;

    public ProductProcessResponse save(String familyId, ProductFamilySaveRequest request) {
        return service.save(familyId, request);
    }

    public ProductProcessResponse get(String familyId) {
        return service.get(familyId);
    }
}
