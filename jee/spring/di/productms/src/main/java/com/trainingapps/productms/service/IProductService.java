package com.trainingapps.productms.service;

import com.trainingapps.productms.entity.Product;
import com.trainingapps.productms.exception.ProductNotFoundException;

import java.util.List;

public interface IProductService {
    Product addProduct(String name,float price);
    Product findProductById(int id) throws ProductNotFoundException;
    Product changePrice(int id,float newPrice) throws ProductNotFoundException;
    List<Product> findAllProduct();
    String deleteProduct(int id) throws ProductNotFoundException;
}
