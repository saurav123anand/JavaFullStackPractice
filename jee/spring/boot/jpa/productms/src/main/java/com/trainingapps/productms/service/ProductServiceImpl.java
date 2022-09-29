package com.trainingapps.productms.service;

import com.trainingapps.productms.dao.IProductDao;
import com.trainingapps.productms.entity.Product;
import com.trainingapps.productms.exception.InvalidIdException;
import com.trainingapps.productms.exception.InvalidNameException;
import com.trainingapps.productms.exception.InvalidPriceException;
import com.trainingapps.productms.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service
public class ProductServiceImpl implements IProductService{
    @Autowired
    IProductDao productDao;
    @Override
    public Product add(String name, double price) {
        validateName(name);
        validatePrice(price);
        Product product=new Product(name,price);
        product=productDao.save(product);
        return product;
    }

    @Override
    public Product findById(long id) throws ProductNotFoundException {
        validateId(id);
        Product product=productDao.findById(id);
        if(product==null){
            throw new ProductNotFoundException("product not found for id "+id);
        }
        return product;
    }
    @Override
    public Product changePrice(long id, double price) throws ProductNotFoundException {
        validateId(id);
        validatePrice(price);
        Product product=findById(id);
        product.setPrice(price);
        product=productDao.save(product);
        return product;
    }

    @Override
    public List<Product> findByName(String name) {
        validateName(name);
        List<Product> products=productDao.findByName(name);
        return products;
    }

    @Override
    public List<Product> findAll() {
        List<Product> products=productDao.findAll();
        return products;
    }
    private void validateName(String name){
        if(name==null || name.isEmpty() ||name.length()<3){
            throw new InvalidNameException("name is invalid");
        }
    }
    private void validatePrice(double price){
        if(price<0){
            throw new InvalidPriceException("price is invalid");
        }
    }
    private void validateId(long id){
        if(id<0){
            throw new InvalidIdException("Id is invalid");
        }
    }
}
