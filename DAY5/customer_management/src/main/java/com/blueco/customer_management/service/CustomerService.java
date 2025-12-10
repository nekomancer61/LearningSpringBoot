package com.blueco.customer_management.service;

import java.util.List;

import com.blueco.customer_management.model.Customer;

public interface CustomerService {
    List<Customer> findAll();
    Customer findById(Long id);
    void save(Customer customer);
    void remove(Long id); 
}
