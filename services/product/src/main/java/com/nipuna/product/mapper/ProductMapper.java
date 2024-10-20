package com.nipuna.product.mapper;

import com.nipuna.product.entity.Category;
import com.nipuna.product.entity.Product;
import com.nipuna.product.entity.dto.ProductPurchaseResponse;
import com.nipuna.product.entity.dto.ProductRequest;
import com.nipuna.product.entity.dto.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductMapper {

    public Product toProduct(ProductRequest request){
        return Product.builder()
                .id(request.getId())
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .availableQuantity(request.getAvailableQuantity())
                .category(Category.builder()
                        .id(request.getCategoryId())
                        .build())
                .build();
    }

    public ProductResponse toProductResponse(Product product) {

        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getAvailableQuantity(),
                product.getPrice(),
                product.getCategory().getId(),
                product.getCategory().getName(),
                product.getCategory().getDescription()

        );
    }

    public ProductPurchaseResponse toProductPurcaseResponse(Product product, double quantity) {

        return new ProductPurchaseResponse(
          product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                quantity

        );
    }
}
