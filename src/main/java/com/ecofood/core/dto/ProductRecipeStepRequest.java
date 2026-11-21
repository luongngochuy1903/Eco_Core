package com.ecofood.core.dto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
public record ProductRecipeStepRequest(
    @NotNull @Min(1) Integer order,
    @NotBlank String name,
    String description,
    @NotNull @Min(0) Integer durationMinutes) {}
