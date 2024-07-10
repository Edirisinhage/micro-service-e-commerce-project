package com.nipuna.customer.mapper;

import com.nipuna.customer.entity.Customer;
import com.nipuna.customer.entity.dto.CustomerDto;
import com.nipuna.customer.exception.CustomerRequestNullException;
import com.nipuna.customer.services.CustomerServ;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Service;

import java.sql.SQLDataException;

@Service
public class ModelMapper {

    public Customer CustomerDtoToCustomer(CustomerDto customerDto) throws SQLDataException {
//        if(customerDto.equals(null)){
//            throw new CustomerRequestNullException("Customer Request Null");
//        }
//        return Customer.builder()
//                .firstname(customerDto.getFirstname())
//                .lastname(customerDto.getLastname())
//                .email(customerDto.getEmail())
//                .address(customerDto.getAddress())
//                .build();
        Customer customer=new Customer();
        customer.setId(customerDto.getId());
        customer.setFirstname(customerDto.getFirstname());
        customer.setLastname(customerDto.getLastname());
        customer.setEmail(customerDto.getEmail());
        customer.setAddress(customerDto.getAddress());

        return customer;
    }
}
