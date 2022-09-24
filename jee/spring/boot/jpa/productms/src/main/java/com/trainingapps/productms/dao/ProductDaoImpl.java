package com.trainingapps.productms.dao;

import com.trainingapps.productms.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
@Repository
public class ProductDaoImpl implements IProductDao{
    // both will do same work
    //@Autowired or @PersistenceContext
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Product save(Product product) {
       entityManager.merge(product);
       return product;
    }

    @Override
    public Product findById(Long id) {
        Product product=entityManager.find(Product.class,id);
        return product;
    }
    @Override
    public List<Product> findByName(String name){
        String query="From Product where name=:nameArgument";
        TypedQuery<Product> typedQuery=entityManager.createQuery(query,Product.class);
        typedQuery.setParameter("nameArgument",name);
        List<Product> products=typedQuery.getResultList();
        return products;

    }

    @Override
    public List<Product> findAll() {
       String query="FROM Product";
       TypedQuery<Product> typedQuery=entityManager.createQuery(query,Product.class);
       List<Product> products=typedQuery.getResultList();
       return products;

    }
}
