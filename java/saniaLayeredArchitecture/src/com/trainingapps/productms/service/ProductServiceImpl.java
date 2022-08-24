package com.trainingapps.productms.service;

import com.trainingapps.productms.dao.IProductDao;
import com.trainingapps.productms.dao.ProductDaoImpl;
import com.trainingapps.productms.entity.Product;
import com.trainingapps.productms.exceptions.InvalidIdException;
import com.trainingapps.productms.exceptions.InvalidNameException;
import com.trainingapps.productms.exceptions.InvalidPriceException;
import com.trainingapps.productms.exceptions.ProductNotFoundException;

public class ProductServiceImpl implements IProductService{
    IProductDao productDao;
    public ProductServiceImpl(int capacity){
        productDao=new ProductDaoImpl(capacity);
    }
    @Override
    public Product addProduct(String name, double price) {
        ValidateName(name);
        ValidatePrice(price);
        Product product=new Product(name,price);
        productDao.add(product);
        return product;
    }

    @Override
    public Product findById(long id) throws ProductNotFoundException {
        ValidateId(id);
        Product product=productDao.findById(id);
        if(product==null){
            throw new ProductNotFoundException("product not found for id "+id);
        }
        return product;

    }

    @Override
    public Product changePrice(long id, double price) throws ProductNotFoundException {
        ValidateId(id);
        Product product=findById(id);
        product.setPrice(price);
        productDao.update(product);
        return product;
    }

    @Override
    public Product[] findAll() {
        return productDao.findAll();
    }

    @Override
    public void delete(long id) throws ProductNotFoundException {
        ValidateId(id);
        Product product=findById(id);
        productDao.delete(product);


    }
    private void ValidateId(long id){
        if(id<0){
            throw new InvalidIdException("Id is invalid");
        }
    }
    private void ValidatePrice(double price){
        if(price<0){
            throw new InvalidPriceException("price can't be negative");
        }
    }
    private void ValidateName(String name){
        if(name==null || name.isEmpty()){
            throw new InvalidNameException("Name is invalid,kindly mention the valid name");
        }
    }

}
