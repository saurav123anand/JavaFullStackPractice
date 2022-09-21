package com.trainingapps.productms.dao;

import com.trainingapps.productms.entity.Product;

import java.util.List;
import java.util.Set;

public interface IProductDao {
    Product add(Product product);
    Product findById(long id);
    void update(Product product);
    Set<Product> findAll();
}
