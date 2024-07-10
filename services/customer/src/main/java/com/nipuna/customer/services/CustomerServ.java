package com.nipuna.customer.services;

import com.nipuna.customer.entity.Customer;
import com.nipuna.customer.entity.dto.CustomerDto;
import com.nipuna.customer.exception.NoAnyUserException;
import com.nipuna.customer.exception.UserNotFoundException;
import org.bson.types.ObjectId;

import java.sql.SQLDataException;
import java.util.List;

public interface CustomerServ {

    String createCustomer(CustomerDto customerDto) throws SQLDataException;

    Customer updateCustomer(CustomerDto customerDto) throws Throwable;

    List<Customer> getAllUsers()throws NoAnyUserException;

    Customer findCustomer(String id)throws UserNotFoundException;

    Customer deleteCustomer(String id)throws UserNotFoundException;
}
