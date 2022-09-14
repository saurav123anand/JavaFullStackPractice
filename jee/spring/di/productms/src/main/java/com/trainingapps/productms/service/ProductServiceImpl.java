package com.trainingapps.productms.service;

import com.trainingapps.productms.dao.IProductDao;
import com.trainingapps.productms.dao.ProductDaoImpl;
import com.trainingapps.productms.entity.Product;
import com.trainingapps.productms.exception.InvalidIdException;
import com.trainingapps.productms.exception.InvalidNameException;
import com.trainingapps.productms.exception.InvalidPriceException;
import com.trainingapps.productms.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ProductServiceImpl implements IProductService{
    @Autowired
    IProductDao productDao;
    @Override
    public Product addProduct(String name, float price) {
        validateName(name);
        validatePrice(price);
        Product product=new Product(name,price);
        productDao.add(product);
        return product;
    }

    @Override
    public Product findProductById(int id) throws ProductNotFoundException{
        validateId(id);
        Product foundProduct=productDao.findById(id);
        if(foundProduct==null){
            throw new ProductNotFoundException("product not found for id "+id);
        }
        return foundProduct;
    }

    @Override
    public Product changePrice(int id, float newPrice) throws ProductNotFoundException{
        Product product=findProductById(id);
        product.setPrice(newPrice);
        productDao.updateProduct(product);
        return product;
    }

    @Override
    public List<Product> findAllProduct() {
        return productDao.findAll();
    }

    @Override
    public String deleteProduct(int id) throws ProductNotFoundException{
        Product product=findProductById(id);
        productDao.deleteProduct(product);
        return "Product with id "+product.getId()+" has been deleted";
    }
    private void validateName(String name){
        if(name==null || name.isEmpty() || name.length()<3){
            throw new InvalidNameException("product name is invalid");
        }
    }
    private void validatePrice(float price){
        if(price<0){
            throw new InvalidPriceException("price is invalid");
        }
    }
    private void validateId(int id){
        if(id<0){
            throw new InvalidIdException("id is invalid");
        }
    }
}
