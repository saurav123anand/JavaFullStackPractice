package com.trainingapps.productms.dao;

import com.trainingapps.productms.entity.Product;

import java.util.List;

public interface IProductDao {
    void add(Product product);
    Product findById(int id);
    List<Product> findAll();
    void updateProduct(Product product);
    void deleteProduct(Product product);
}
