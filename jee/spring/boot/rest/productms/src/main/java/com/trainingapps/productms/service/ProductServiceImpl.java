package com.trainingapps.productms.service;

import com.trainingapps.productms.dao.IProductDao;
import com.trainingapps.productms.entity.Product;
import com.trainingapps.productms.exception.InvalidIdException;
import com.trainingapps.productms.exception.InvalidNameException;
import com.trainingapps.productms.exception.InvalidPriceException;
import com.trainingapps.productms.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements IProductService{
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
    public Product findById(long id) throws ProductNotFoundException{
        validateId(id);
        Product product=productDao.findById(id);
        if(product==null){
            throw new ProductNotFoundException("Product not found for id="+id);
        }
        return product;
    }

    @Override
    public Product changePrice(long id, double price) throws ProductNotFoundException{
        validateId(id);
        validatePrice(price);
        Product product=findById(id);
        product.setPrice(price);
        Product found=productDao.update(product);
        return found;
    }

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public void deleteProduct(long id) throws ProductNotFoundException{
        Product product=findById(id);
        productDao.remove(product);
    }

    private void validatePrice(double price){
        if(price<0.0){
            throw new InvalidPriceException("price is less than zero");
        }
    }
    private void validateName(String name){
        if(name==null || name.isEmpty() || name.length()<3){
            throw new InvalidNameException("Name is invalid");
        }
    }
    private void validateId(long id){
        if(id<0){
            throw new InvalidIdException("id is invalid ");
        }
    }
}
