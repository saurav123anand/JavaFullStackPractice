package com.trainingapps.productms.service;

import com.trainingapps.productms.entity.Product;
import com.trainingapps.productms.exception.ProductNotFoundException;

import java.util.Set;

public interface IProductService {
    Product addProduct(String name,double price);
    Product findProductById(long id) throws ProductNotFoundException;
    Product changePrice(int id,double price) throws ProductNotFoundException;
    Set<Product> findAll();
}
