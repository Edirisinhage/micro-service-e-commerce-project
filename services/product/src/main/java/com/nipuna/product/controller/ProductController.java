package com.nipuna.product.controller;

import com.nipuna.product.entity.dto.ProductPurchaseRequest;
import com.nipuna.product.entity.dto.ProductPurchaseResponse;
import com.nipuna.product.entity.dto.ProductRequest;
import com.nipuna.product.entity.dto.ProductResponse;
import com.nipuna.product.exception.ProductPurcaseException;
import com.nipuna.product.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<Integer> createProduct(@RequestBody @Valid ProductRequest request){
        return ResponseEntity.ok(productService.createProduct(request));
    }

    @PostMapping("/purchase")
    public ResponseEntity<List<ProductPurchaseResponse>> purchaseProduct(
            @RequestBody List<ProductPurchaseRequest> request
    ) throws ProductPurcaseException {
        return ResponseEntity.ok(productService.purchaseProduct(request));
    }

    @GetMapping("/findby/{product-id}")
    public ResponseEntity<ProductResponse> findById(
            @PathVariable("product-id") Integer productId
    ){
        return ResponseEntity.ok(productService.findProductById(productId));
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<ProductResponse>> findAllProducts(){
        return ResponseEntity.ok().body(productService.findAllProduct());
    }


}
