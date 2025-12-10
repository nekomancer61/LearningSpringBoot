package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import model.Product;

@Component
public class ProductDao {
    @PersistenceContext
    private EntityManager em;
    public void persist(Product product){
        em.persist(product);
    }
    public List<Product> findAll(){
        return em.createQuery("select p from Product p").getResultList();
    }
}
