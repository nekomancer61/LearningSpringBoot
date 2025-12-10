package com.blueco.customer_management_restful.service;

import java.util.List;

import com.blueco.customer_management_restful.model.Customer;

public interface CustomerService {
    List<Customer> findAll();
    Customer findById(Long id);
    void save(Customer c);
    void delete(Long id);
}
