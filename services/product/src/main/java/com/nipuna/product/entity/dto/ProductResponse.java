package com.nipuna.product.entity.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.NoRepositoryBean;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    Integer id;
    String name;
    String description;
    double availableQuantity;
    BigDecimal price;
    Integer categoryId;
    String categoryName;
    String categoryDescription;
}
