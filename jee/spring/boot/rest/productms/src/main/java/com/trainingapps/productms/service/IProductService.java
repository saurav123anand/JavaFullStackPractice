package com.trainingapps.productms.service;

import com.trainingapps.productms.entity.Product;
import com.trainingapps.productms.exception.ProductNotFoundException;

import java.util.List;

public interface IProductService {
    Product addProduct(String name,double price);
    Product findById(long id) throws ProductNotFoundException;
    Product changePrice(long id,double price) throws ProductNotFoundException;
    List<Product> findAll();
    void deleteProduct(long id) throws ProductNotFoundException;
}
