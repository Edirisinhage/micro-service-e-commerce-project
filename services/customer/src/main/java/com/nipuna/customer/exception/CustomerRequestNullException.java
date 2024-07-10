package com.nipuna.customer.exception;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomerRequestNullException extends RuntimeException {

    private final String message;

}
