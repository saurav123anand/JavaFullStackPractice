package com.trainingapps.productms.dao;

import com.trainingapps.productms.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public class ProductDaoImpl implements IProductDao{
    private Map<Long,Product> store=new HashMap<>();

    private long generatedId;
    private long getGeneratedId(){
        return ++generatedId;
    }

    @Override
    public void add(Product product) {
        long id=getGeneratedId();
        product.setId(id);
        store.put(id,product);
    }

    @Override
    public Product findById(long id) {
        Product product=store.get(id);
        return product;
    }

    @Override
    public Product update(Product product) {
        Product updated=store.put(product.getId(),product);
        return updated;
    }

    @Override
    public List<Product> findAll() {
        Collection<Product> products=store.values();
        List<Product> getAllProducts=new ArrayList<>(products);
        return getAllProducts;
    }

    @Override
    public void remove(Product product) {
        store.remove(product.getId());
    }
}
