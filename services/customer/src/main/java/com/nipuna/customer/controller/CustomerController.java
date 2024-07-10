package com.nipuna.customer.controller;

import com.nipuna.customer.entity.Customer;
import com.nipuna.customer.entity.dto.CustomerDto;
import com.nipuna.customer.entity.dto.ResponseDto;
import com.nipuna.customer.exception.CustomerRequestNullException;
import com.nipuna.customer.exception.NoAnyUserException;
import com.nipuna.customer.exception.UserNotFoundException;
import com.nipuna.customer.services.CustomerServ;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLDataException;
import java.util.List;


@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerServ service;

    @PostMapping("/register")
    public ResponseEntity<ResponseDto> registerCustomer(@RequestBody
                                                           @Valid CustomerDto customerDto) throws SQLDataException, CustomerRequestNullException, ValidationException {
        ResponseDto responseDto=ResponseDto.builder()
                .status("Success")
                .message("Successfully Register the customer")
                .object(service.createCustomer(customerDto))
                .build();
        return ResponseEntity.ok(responseDto);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateCustomer(
            @RequestBody @Valid CustomerDto customerDto) throws Throwable {

        ResponseDto responseDto=ResponseDto.builder()
                .status("Success")
                .object(service.updateCustomer(customerDto))
                .message("Successfully Updated the customer")
                .build();

        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/get-all")
    public ResponseEntity<ResponseDto> getAllCustomers() throws NoAnyUserException {
        ResponseDto response=ResponseDto.builder()
                .status("Success")
                .object(service.getAllUsers())
                .message("Successfully Retrieve the users")
                .build();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{customerid}")
    public ResponseEntity<ResponseDto> findCustomer(@PathVariable String customerid)throws UserNotFoundException {
        ResponseDto response=ResponseDto.builder()
                .status("Success")
                .message("User Found")
                .object(service.findCustomer(customerid))
                .build();

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteCustomer(@PathVariable String id){
        ResponseDto response=ResponseDto.builder()
                .status("Success")
                .message("Successfully Deleted the Customer")
                .object(service.deleteCustomer(id))
                .build();

        return ResponseEntity.ok(response);
    }

}
