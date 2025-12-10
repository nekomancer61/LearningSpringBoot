package com.blueco.customer_management_restful.repository;

import java.util.List;

public interface Repository<T> {
    List<T> findAll();
    T findById(Long id);
    void save(T entity);
    void delete(Long id);
}
