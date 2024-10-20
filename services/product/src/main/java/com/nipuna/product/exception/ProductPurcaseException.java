package com.nipuna.product.exception;

public class ProductPurcaseException extends Throwable {

    private String message;
    public ProductPurcaseException(String s) {
        this.message=s;
    }
}
