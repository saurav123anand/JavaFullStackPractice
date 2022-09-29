package com.example.demo.dao;

import com.example.demo.entity.Product;

import java.util.List;

public interface IProductDao {
    void add(Product product);
    Product findById(int id);
    void update(Product product);
    List<Product> findAll();

}
