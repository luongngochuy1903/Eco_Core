package com.ecofood.core.dto;

public record ApprovedProductProcessReference(
        String productId,
        int productVersion,
        String productProcessId,
        String name,
        ProductProcessResponse process) {}
