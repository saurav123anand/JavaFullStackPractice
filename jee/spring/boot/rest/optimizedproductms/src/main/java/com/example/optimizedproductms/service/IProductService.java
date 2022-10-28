package com.example.optimizedproductms.service;

import com.example.optimizedproductms.entity.Product;
import com.example.optimizedproductms.exception.ProductNotFoundException;

import java.util.List;

public interface IProductService {
    Product addProduct(String name, double price);
    Product findById(long id) throws ProductNotFoundException;
    Product changePrice(long id,double price) throws ProductNotFoundException;
    List<Product> findByName(String name);
    List<Product> findAll();
    String deleteProduct(long id) throws ProductNotFoundException;
}
