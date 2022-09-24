package com.trainingapps.productms.service;

import com.trainingapps.productms.dao.IProductDao;
import com.trainingapps.productms.dao.ProductDaoImpl;
import com.trainingapps.productms.entity.Product;
import com.trainingapps.productms.exception.ProductNotFoundException;

import java.util.List;

public interface IProductService {
    Product add(String name,double price);
    Product findById(long id) throws ProductNotFoundException;
    Product changePrice(long id,double price) throws ProductNotFoundException;
    List<Product> findByName(String name);
    List<Product> findAll();
}
