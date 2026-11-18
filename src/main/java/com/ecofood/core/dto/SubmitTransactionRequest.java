package com.ecofood.core.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

public record SubmitTransactionRequest(
    @NotBlank @Size(max = 100) @Pattern(regexp = "\\S(?:.*\\S)?") String invoiceNumber,
    @NotNull @PastOrPresent Instant transactionTime,
    @NotBlank @Pattern(regexp = "[A-Z]{3}") String currency,
    @NotNull @DecimalMin("0") BigDecimal totalAmount,
    @NotEmpty @Size(max = 1000) List<@NotNull @Valid InvoiceItemDto> items) {}
