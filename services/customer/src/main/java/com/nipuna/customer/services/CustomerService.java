package com.nipuna.customer.services;

import com.nipuna.customer.entity.Customer;
import com.nipuna.customer.entity.dto.CustomerDto;
import com.nipuna.customer.exception.NoAnyUserException;
import com.nipuna.customer.exception.UserNotFoundException;
import com.nipuna.customer.mapper.ModelMapper;
import com.nipuna.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLDataException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RequiredArgsConstructor
@Service
public class CustomerService implements CustomerServ {

    @Autowired
    private final CustomerRepository repository;
    private final ModelMapper mapper;
    @Override
    public String createCustomer(CustomerDto customerDto) throws SQLDataException {
        Customer customer=repository.save(mapper.CustomerDtoToCustomer(customerDto));
        return customer.getId();
    }

    @Override
    public Customer updateCustomer(CustomerDto customerDto) throws Throwable {
        var customer= repository.findById(customerDto.getId()).orElseThrow(()->new UserNotFoundException("User Not found"));
        mergeCustomer(customerDto,customer);
        return customer;
    }

    public void mergeCustomer(CustomerDto customerDto,Customer customer){
        if(StringUtils.isNotBlank(customerDto.getFirstname())){
            customer.setFirstname(customerDto.getFirstname());
        }
        if(StringUtils.isNotBlank(customerDto.getLastname())){
            customer.setLastname(customerDto.getLastname());
        }
        if(StringUtils.isNotBlank(customerDto.getEmail())){
            customer.setEmail(customerDto.getEmail());
        }
        if(customerDto.getAddress()!=null){
            customer.setAddress(customerDto.getAddress());
        }

        repository.save(customer);
    }

    public List<Customer> getAllUsers() throws NoAnyUserException {
        List<Customer> customerList=repository.findAll();
        if(customerList.isEmpty()){
            throw new NoAnyUserException("There is no any user registered");
        }
        return customerList;
    }

    @Override
    public Customer findCustomer(String id)throws UserNotFoundException {
        return repository.findById(id).orElseThrow(()->new UserNotFoundException("Customer Not Exist"));
    }

    @Override
    public Customer deleteCustomer(String id) throws UserNotFoundException{
        Customer customer=repository.findById(id).orElseThrow(()->new UserNotFoundException("User Not Exist"));
        if(customer!=null){
            repository.delete(customer);
            return customer;
        }
        return null;
    }
}
