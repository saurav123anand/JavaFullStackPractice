package com.example.demo.service;

import com.example.demo.dao.IProductDao;
import com.example.demo.entity.Product;
import com.example.demo.exception.InvalidIdException;
import com.example.demo.exception.InvalidNameException;
import com.example.demo.exception.InvalidPriceException;
import com.example.demo.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class ProductServiceImpl implements IProductService{
    @Autowired
    IProductDao productDao;
    @Override
    public Product addProduct(String name, double price) {
        validateName(name);
        validatePrice(price);
        Product product=new Product(name,price);
        productDao.add(product);
        return product;
    }

    @Override
    public Product findById(int id) throws ProductNotFoundException{
        validateId(id);
        Product product=productDao.findById(id);
        if(product==null){
            throw new ProductNotFoundException("product not found for id="+id);
        }
        return product;
    }

    @Override
    public Product changePrice(int id, double price) throws ProductNotFoundException{
        validateId(id);
        validatePrice(price);
        Product product=findById(id);
        product.setPrice(price);
        productDao.update(product);
        return product;

    }

    @Override
    public List<Product> findAll() {
        List<Product> products=productDao.findAll();
        return products;
    }
    private void validateId(int id){
        if(id<0){
            throw new InvalidIdException("id is invalid");
        }
    }
    private void validateName(String name){
        if(name==null || name.isEmpty() || name.length()<3){
            throw new InvalidNameException("name is invalid");
        }
    }
    private void validatePrice(double price){
        if(price<0){
            throw new InvalidPriceException("price is invalid");
        }
    }

}
