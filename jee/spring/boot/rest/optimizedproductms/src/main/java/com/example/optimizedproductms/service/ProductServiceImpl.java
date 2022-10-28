package com.example.optimizedproductms.service;
import com.example.optimizedproductms.dao.IProductDao;
import com.example.optimizedproductms.entity.Product;
import com.example.optimizedproductms.exception.InvalidIdException;
import com.example.optimizedproductms.exception.InvalidNameException;
import com.example.optimizedproductms.exception.InvalidPriceException;
import com.example.optimizedproductms.exception.ProductNotFoundException;
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
    public Product addProduct(String name, double price) {
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

    @Override
    public String deleteProduct(long id) throws ProductNotFoundException {
        Product product=findById(id);
        productDao.delete(product);
        return "product with id "+id+" has been deleted";
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
