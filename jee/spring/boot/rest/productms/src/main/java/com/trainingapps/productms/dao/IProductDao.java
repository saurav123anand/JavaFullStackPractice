package com.trainingapps.productms.dao;

import com.trainingapps.productms.entity.Product;

import java.util.List;

public interface IProductDao {
    void add(Product product);
    Product findById(long id);
    Product update(Product product);
    List<Product> findAll();
    void remove(Product product);
}
