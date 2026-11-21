package com.ecofood.core.dto;

import java.math.BigDecimal;
import jakarta.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

public record EconomicMetricsRequest(
        @Min(1) @Max(12) Integer month,
        @NotNull @Min(1970) @Max(9999) Integer year,
        @JsonFormat(shape = JsonFormat.Shape.STRING) @DecimalMin("0") BigDecimal totalSalesVolume,
        @JsonFormat(shape = JsonFormat.Shape.STRING) @DecimalMin("0") BigDecimal profit,
        @JsonFormat(shape = JsonFormat.Shape.STRING) @DecimalMin("0") BigDecimal ingredientCost,
        @JsonFormat(shape = JsonFormat.Shape.STRING) @DecimalMin("0") BigDecimal platformCost,
        @Min(1) @Max(4) Integer quarter,
        @JsonFormat(shape = JsonFormat.Shape.STRING) @DecimalMin("0") BigDecimal revenue) {

    public EconomicMetricsRequest(
            Integer month,
            Integer year,
            BigDecimal totalSalesVolume,
            BigDecimal profit,
            BigDecimal ingredientCost,
            BigDecimal platformCost) {
        this(month, year, totalSalesVolume, profit, ingredientCost, platformCost, null, null);
    }

    @JsonIgnore
    @AssertTrue(message = "Provide either a quarter or a legacy month, but not both")
    public boolean isPeriodValid() {
        return (quarter != null) != (month != null);
    }
}
