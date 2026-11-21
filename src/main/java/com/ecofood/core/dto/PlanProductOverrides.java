package com.ecofood.core.dto;

import jakarta.validation.Valid;

public record PlanProductOverrides(
        String name, String description, String imageUrl, @Valid ProductRecipeRequest recipe) {
    public PlanProductOverrides(String name, String description, String imageUrl) {
        this(name, description, imageUrl, null);
    }
}
