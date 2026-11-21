package com.ecofood.core.dto;

import java.math.BigDecimal;
import java.util.List;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonFormat;

public record PartnerMetricsRequest(
        @NotBlank String tenantId,
        @JsonFormat(shape = JsonFormat.Shape.STRING) @DecimalMin("0") BigDecimal expectRevenue,
        List<@Valid EconomicMetricsRequest> expectMetrics) {}
