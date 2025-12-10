package com.blueco.customer_management_restful.repository.impl;

import java.util.List;

import com.blueco.customer_management_restful.model.Customer;
import com.blueco.customer_management_restful.repository.CustomerRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

public class CustomerRepositoryImpl implements CustomerRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Customer> findAll() {
        TypedQuery<Customer> customerQuery = em.createQuery("select c from Customer c", Customer.class);
        return customerQuery.getResultList();    
    }

    @Override
    public Customer findById(Long id) {
        return em.find(Customer.class, id);    
    }

    @Override
    public void save(Customer entity) {
        if (findById(entity.getId() )!=null){
            em.merge(entity);
        }
        else {
            em.persist(entity);
        }
    }

    @Override
    public void delete(Long id) {
        Customer c = findById(id);
        if (c!=null){
            em.remove(c);
        }
    }
    
}
