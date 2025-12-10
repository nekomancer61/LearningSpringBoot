package com.blueco.customer_management.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.blueco.customer_management.model.Customer;

@Transactional
public class CustomerRepositoryImpl implements CustomerRepository{

    @PersistenceContext
    private EntityManager em;

    

    public CustomerRepositoryImpl() {
    }

    @Override
    public List<Customer> findAll() {
        return em.createQuery("Select c from Customer c",Customer.class).getResultList();
        
    }

    @Override
    public Customer findById(Long id) {
        return em.find(Customer.class, id);

    }

    @Override
    public void save(Customer model) {
        if (model.getId()!=null){
            em.merge(model);
        }
        else{
            em.persist(model);
        }
        
    }

    @Override
    public void remove(Long id) {
        Customer c = findById(id);
        if (c!=null) em.remove(c);
    }
    
}
