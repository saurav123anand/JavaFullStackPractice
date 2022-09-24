package com.trainingapps.productms.dao;

import com.trainingapps.productms.entity.Product;

import java.util.List;

public interface IProductDao {
    Product save(Product product);
    Product findById(Long id);
    List<Product> findByName(String name);
    List<Product> findAll();
}
