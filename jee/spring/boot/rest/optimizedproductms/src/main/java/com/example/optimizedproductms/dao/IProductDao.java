package com.example.optimizedproductms.dao;

import com.example.optimizedproductms.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductDao{
    Product save(Product product);
    Product findById(long id);
    List<Product> findByName(String name);
    List<Product> findAll();
    void delete(Product product);
}

