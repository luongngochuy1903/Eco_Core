package com.ecofood.core.dto;

import com.ecofood.core.enums.TransactionStatus;
import java.time.Instant;

public record SubmitTransactionResponse(String id, String invoiceNumber,
    TransactionStatus status, Instant receivedAt) {}
