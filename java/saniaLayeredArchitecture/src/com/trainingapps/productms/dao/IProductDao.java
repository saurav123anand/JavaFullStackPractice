package com.trainingapps.productms.dao;

import com.trainingapps.productms.entity.Product;

public interface IProductDao {
    void add(Product product);
    Product findById(long id);
    void update(Product product);
    Product[] findAll();
    void delete(Product product);
}
