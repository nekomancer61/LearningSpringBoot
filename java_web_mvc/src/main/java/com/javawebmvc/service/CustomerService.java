package com.javawebmvc.service;

import java.util.List;

import com.javawebmvc.model.Customer;

public interface CustomerService {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(int id);

    void update(int id, Customer customer);

    

    void remove(int id);
}
