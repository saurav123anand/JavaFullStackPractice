package com.example.demo.dao;

import com.example.demo.entity.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.*;
@Component
public class ProductDaoImpl implements IProductDao{
    Map<Integer,Product> store=new HashMap<>();
    private int generateId;
    private int getGenerateId(){
        return ++generateId;
    }
    @Override
    public void add(Product product) {
        int id=getGenerateId();
        product.setId(id);
        store.put(id,product);
    }

    @Override
    public Product findById(int id) {
        Product product=store.get(id);
        return product;
    }

    @Override
    public void update(Product product) {
         store.put(product.getId(),product);
    }

    @Override
    public List<Product> findAll() {
        Collection<Product> products=store.values();
        List<Product> result=new ArrayList<>(products);
        return result;
    }
}
