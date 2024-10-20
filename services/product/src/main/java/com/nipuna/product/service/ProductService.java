package com.nipuna.product.service;

import com.nipuna.product.entity.dto.ProductPurchaseRequest;
import com.nipuna.product.entity.dto.ProductPurchaseResponse;
import com.nipuna.product.entity.dto.ProductRequest;
import com.nipuna.product.entity.dto.ProductResponse;
import com.nipuna.product.exception.ProductPurcaseException;
import com.nipuna.product.mapper.ProductMapper;
import com.nipuna.product.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    public Integer createProduct(ProductRequest request) {
        var product=productMapper.toProduct(request);
        return productRepository.save(product).getId();
    }

    public List<ProductPurchaseResponse> purchaseProduct(List<ProductPurchaseRequest> requests) throws ProductPurcaseException {
        var productIds=requests.
                stream()
                .map(ProductPurchaseRequest::getProductId)
                .toList();
        var storedProducts=productRepository.findAllByIdInOrderById(productIds);
        if(productIds.size()!=storedProducts.size()){
            throw new ProductPurcaseException("One or more products does not exist");
        }

        var storedRequest=requests
                .stream()
                .sorted(Comparator.comparing(ProductPurchaseRequest::getProductId))
                .toList();

        var purcasedProducts=new ArrayList<ProductPurchaseResponse>();

        for(int i=0; i<storedRequest.size();i++){
            var product=storedProducts.get(i);
            var productRequest=storedRequest.get(i);
            if(product.getAvailableQuantity()<productRequest.getQuantity()){
                throw new ProductPurcaseException("Insuficient stock quantity for product with ID:"+ productRequest.getProductId());
            }

            var newAvailableQuantity=product.getAvailableQuantity()-productRequest.getQuantity();
            product.setAvailableQuantity(newAvailableQuantity);
            productRepository.save(product);
            purcasedProducts.add(productMapper.toProductPurcaseResponse(product,productRequest.getQuantity()));
        }
        return purcasedProducts;
    }

    public ProductResponse findProductById(Integer productId) {
        return productRepository.findById(productId)
                .map(productMapper::toProductResponse)
                .orElseThrow(()->new EntityNotFoundException("Product not found with the Id"));
    }

    public List<ProductResponse> findAllProduct() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toProductResponse)
                .collect(Collectors.toList());
    }
}
