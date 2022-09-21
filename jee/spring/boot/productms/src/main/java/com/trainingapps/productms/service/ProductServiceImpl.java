package com.trainingapps.productms.service;

import com.trainingapps.productms.dao.IProductDao;
import com.trainingapps.productms.entity.Product;
import com.trainingapps.productms.exception.InvalidNameException;
import com.trainingapps.productms.exception.InvalidPriceException;
import com.trainingapps.productms.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductDao productDao;
    @Override
    public Product addProduct(String name, double price) {
        validateName(name);
        validatePrice(price);
        Product product=new Product(name,price);
        productDao.add(product);
        return product;
    }

    @Override
    public Product findProductById(long id) throws ProductNotFoundException{
        Product product=productDao.findById(id);
        if(product==null){
            throw new ProductNotFoundException("product not found");
        }
        return product;
    }

    @Override
    public Product changePrice(int id, double price) throws ProductNotFoundException{
        Product product=findProductById(id);
        product.setPrice(price);
        productDao.update(product);
        return product;

    }

    @Override
    public Set<Product> findAll() {
        return productDao.findAll();
    }
    private void validateName(String name){
        if(name==null || name.isEmpty() || name.length()<3){
            throw new InvalidNameException("invalid product name");
        }
    }
    private void validatePrice(double price){
        if(price<0){
            throw new InvalidPriceException("invalid price");
        }
    }
}
