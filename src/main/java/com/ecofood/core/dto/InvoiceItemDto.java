package com.ecofood.core.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public record InvoiceItemDto(
    @NotBlank @Size(max = 100) String productCode,
    @NotBlank @Size(max = 255) String productName,
    @NotNull @DecimalMin(value = "0", inclusive = false) BigDecimal quantity,
    @NotNull @DecimalMin("0") BigDecimal unitPrice,
    @NotNull @DecimalMin("0") BigDecimal amount) {}
