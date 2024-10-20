package com.nipuna.product.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductPurchaseResponse {

    Integer productId;

    String name;

    String description;

    BigDecimal price;

    double quantity;
}
