package com.trainingapps.productms.service;

import com.trainingapps.productms.entity.Product;
import com.trainingapps.productms.exceptions.ProductNotFoundException;

public interface IProductService {
    Product addProduct(String name,double price);
    Product findById(long id) throws ProductNotFoundException;
    Product changePrice(long id,double price);
    Product[] findAll();;
    void delete(long id);
}
