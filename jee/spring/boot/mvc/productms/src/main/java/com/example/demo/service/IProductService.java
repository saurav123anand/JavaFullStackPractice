package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.exception.ProductNotFoundException;

import java.util.List;

public interface IProductService {
    Product addProduct(String name,double price);
    Product findById(int id) throws ProductNotFoundException;
    Product changePrice(int id,double price) throws ProductNotFoundException;
    List<Product> findAll();
}
