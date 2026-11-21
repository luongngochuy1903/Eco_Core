package com.ecofood.core.dto;

import java.util.List;
import com.ecofood.core.enums.*;

public record PropositionTenantReference(
        String id,
        String name,
        String enterpriseId,
        PartnerTypeEnum partnerType,
        TenantTypeEnum tenantType,
        List<String> scopedTenantIds,
        List<PartyRelationshipResponse> relationships,
        boolean deleted,
        String country) {
    public PropositionTenantReference(
            String id,
            String name,
            String enterpriseId,
            PartnerTypeEnum partnerType,
            TenantTypeEnum tenantType,
            List<String> scopedTenantIds,
            List<PartyRelationshipResponse> relationships,
            boolean deleted) {
        this(
                id,
                name,
                enterpriseId,
                partnerType,
                tenantType,
                scopedTenantIds,
                relationships,
                deleted,
                null);
    }
}
