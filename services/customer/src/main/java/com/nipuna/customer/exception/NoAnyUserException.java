package com.nipuna.customer.exception;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class NoAnyUserException extends Throwable {

    private final String message;

}
