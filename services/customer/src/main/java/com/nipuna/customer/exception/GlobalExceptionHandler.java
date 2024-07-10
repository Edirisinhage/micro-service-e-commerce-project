package com.nipuna.customer.exception;

import com.mongodb.MongoWriteException;
import com.nipuna.customer.entity.dto.ResponseDto;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.ValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLDataException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomerRequestNullException.class)
    public ResponseEntity<ResponseDto> handleException(CustomerRequestNullException customerRequestNullException){
        ResponseDto responseDto=ResponseDto.builder()
                .status("Failed due to Exception")
                .message(customerRequestNullException.getMessage())
                .object(null)
                .build();
        return ResponseEntity
                .badRequest()
                .body(responseDto);
    }

    @ExceptionHandler(SQLDataException.class)
    public ResponseEntity<ResponseDto> handleException(SQLDataException exception){
        ResponseDto responseDto=ResponseDto.builder()
                .status("Failed due to Exception")
                .message(exception.getMessage())
                .object(null)
                .build();
        return ResponseEntity
                .internalServerError()
                .body(responseDto);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ResponseDto> handleException(ValidationException exception){
        ResponseDto responseDto=ResponseDto.builder()
                .status("Failed due to Exception")
                .message(exception.getMessage())
                .object(null)
                .build();
        return ResponseEntity
                .internalServerError()
                .body(responseDto);
    }


    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ResponseDto> handleException(UserNotFoundException exception){
        ResponseDto responseDto=ResponseDto.builder()
                .status("Failed due to Exception")
                .message(exception.getMessage())
                .object(null)
                .build();
        return ResponseEntity
                .internalServerError()
                .body(responseDto);
    }

    @ExceptionHandler(MissingPathVariableException.class)
    public ResponseEntity<ResponseDto> handleException(MissingPathVariableException exception){
        ResponseDto responseDto=ResponseDto.builder()
                .status("Failed due to Exception")
                .message(exception.getMessage())
                .object(null)
                .build();
        return ResponseEntity
                .internalServerError()
                .body(responseDto);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ResponseDto> handleException(ConstraintViolationException exception){
        ResponseDto responseDto=ResponseDto.builder()
                .status("Failed due to Exception")
                .message(exception.getMessage())
                .object(null)
                .build();
        return ResponseEntity
                .badRequest()
                .body(responseDto);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDto> handleException(MethodArgumentNotValidException exception){
        ResponseDto responseDto=ResponseDto.builder()
                .status("Failed due to Arguments Passed are not valid")
                .message(exception.getMessage())
                .object(null)
                .build();
        return ResponseEntity
                .badRequest()
                .body(responseDto);
    }

    @ExceptionHandler(MongoWriteException.class)
    public ResponseEntity<ResponseDto> handleException(MongoWriteException exception){
        ResponseDto responseDto=ResponseDto.builder()
                .status("Failed due to MongoWrite Exception: Dublicate values")
                .message(exception.getMessage())
                .object(null)
                .build();
        return ResponseEntity
                .badRequest()
                .body(responseDto);
    }

}
