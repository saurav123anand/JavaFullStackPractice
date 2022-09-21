package com.trainingapps.productms.dao;


import com.trainingapps.productms.entity.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ProductDaoImpl implements IProductDao {
    Set<Product> products;
    public ProductDaoImpl(){
        products=new LinkedHashSet<>();
    }

    private long generatedId;
    private long generateId(){
        return ++generatedId;
    }
    @Override
    public Product add(Product product) {
        long id=generateId();
        product.setId(id);
        products.add(product);
        return product;
    }

    @Override
    public Product findById(long id) {
        for(Product product:products){
            if(product!=null && product.getId()==id){
                return product;
            }
        }
        return null;
    }

    @Override
    public void update(Product product) {
        products.add(product);

    }

    @Override
    public Set<Product> findAll() {
        return products;
    }
}
