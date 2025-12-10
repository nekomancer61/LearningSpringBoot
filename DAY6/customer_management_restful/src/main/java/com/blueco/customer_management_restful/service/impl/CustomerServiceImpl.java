package com.blueco.customer_management_restful.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.blueco.customer_management_restful.model.Customer;
import com.blueco.customer_management_restful.repository.CustomerRepository;
import com.blueco.customer_management_restful.service.CustomerService;

public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id);
    
    }

    @Override
    public void save(Customer c) {
        customerRepository.save(c);
    }

    @Override
    public void delete(Long id) {
        customerRepository.delete(id);
    }
    
}
