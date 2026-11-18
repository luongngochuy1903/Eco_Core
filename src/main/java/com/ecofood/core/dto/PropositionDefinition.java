package com.ecofood.core.dto;

import java.util.*;
import java.time.Instant;
import java.math.BigDecimal;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ecofood.core.enums.PlanOverrideField;

public record PropositionDefinition(
        @NotBlank String name,
        String description,
        List<@NotBlank String> regionIds,
        String brandId,
        @NotEmpty List<@NotBlank String> distributionPartnerIds,
        String currency,
        Instant startDate,
        Instant endDate,
        @JsonFormat(shape = JsonFormat.Shape.STRING) @DecimalMin("0") BigDecimal expectRevenue,
        List<@Valid EconomicMetricsRequest> expectMetrics,
        List<@Valid PartnerMetricsRequest> partnerMetrics,
        @JsonFormat(shape = JsonFormat.Shape.STRING) @DecimalMin("0") @DecimalMax("100")
                BigDecimal enterpriseProfitShare,
        @JsonFormat(shape = JsonFormat.Shape.STRING) @DecimalMin("0") @DecimalMax("100")
                BigDecimal platformProfitShare,
        @JsonFormat(shape = JsonFormat.Shape.STRING) @DecimalMin("0") @DecimalMax("100")
                BigDecimal distributionProfitShare,
        Set<@NotNull PlanOverrideField> allowedOverrides,
        @Min(1900) @Max(9999) Integer targetYear,
        @JsonFormat(shape = JsonFormat.Shape.STRING) @DecimalMin("0") BigDecimal currentRevenue) {
    public PropositionDefinition(
            String name,
            String description,
            List<String> regionIds,
            String brandId,
            List<String> distributionPartnerIds,
            String currency,
            Instant startDate,
            Instant endDate,
            BigDecimal expectRevenue,
            List<EconomicMetricsRequest> expectMetrics,
            List<PartnerMetricsRequest> partnerMetrics,
            BigDecimal enterpriseProfitShare,
            BigDecimal platformProfitShare,
            BigDecimal distributionProfitShare,
            Set<PlanOverrideField> allowedOverrides) {
        this(
                name,
                description,
                regionIds,
                brandId,
                distributionPartnerIds,
                currency,
                startDate,
                endDate,
                expectRevenue,
                expectMetrics,
                partnerMetrics,
                enterpriseProfitShare,
                platformProfitShare,
                distributionProfitShare,
                allowedOverrides,
                null,
                null);
    }
}
