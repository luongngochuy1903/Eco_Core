package com.ecofood.core.dto;

import jakarta.validation.constraints.*;

public record RevisionRequest(@NotNull @Min(0) Long expectedRevision) {}
