package com.nipuna.product.entity.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {

    Integer id;
    @NotNull(message = "Product name is required")
    String name;
    @NotNull(message = "Product description is required")
    String description;
    @Positive(message = "Quantity must be positive value")
    double availableQuantity;
    @Positive(message = "Quantity must be positive value")
    BigDecimal price;
    @NotNull(message = "Product category is required")
    Integer categoryId;
}
