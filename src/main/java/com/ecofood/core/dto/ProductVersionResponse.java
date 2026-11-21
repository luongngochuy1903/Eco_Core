package com.ecofood.core.dto;
import com.ecofood.core.enums.ProductStatusEnum;
import java.time.Instant;
public record ProductVersionResponse(int version, Long revision, ProductStatusEnum status,
                                    String name, Instant createdAt, Instant updatedAt) {}
