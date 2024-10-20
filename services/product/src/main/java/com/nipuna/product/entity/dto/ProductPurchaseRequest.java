package com.nipuna.product.entity.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductPurchaseRequest {

    @NotNull(message = "Product is mandotory")
    Integer productId;
    @NotNull(message = "Quantity is mandotory")
    double quantity;

}
