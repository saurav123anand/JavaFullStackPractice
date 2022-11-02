package com.example.optimizedproductms.service;
import com.example.optimizedproductms.dao.IProductDao;
import com.example.optimizedproductms.dto.AddProductRequest;
import com.example.optimizedproductms.dto.ChangeProductRequest;
import com.example.optimizedproductms.dto.ProductDetails;
import com.example.optimizedproductms.entity.Product;
import com.example.optimizedproductms.exception.InvalidIdException;
import com.example.optimizedproductms.exception.InvalidNameException;
import com.example.optimizedproductms.exception.InvalidPriceException;
import com.example.optimizedproductms.exception.ProductNotFoundException;
import com.example.optimizedproductms.util.ProductUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Transactional
@Service
public class ProductServiceImpl implements IProductService{
    @Autowired
    private IProductDao productDao;
    @Autowired
    private ProductUtil util;


    @Override
    public ProductDetails addProduct(AddProductRequest requestData) {
        Product product=new Product(requestData.getName(),requestData.getPrice());
        product=productDao.save(product);
        ProductDetails response=util.toProductDetails(product);
        return response;
    }
    @Override
    public Product findById(long id) throws ProductNotFoundException {
        Product product=productDao.findById(id);
        if(product==null){
            throw new ProductNotFoundException("product not found for id "+id);
        }
        return product;
    }
    @Override
    public ProductDetails findProductDetailsById(long id) throws ProductNotFoundException {
        Product product=productDao.findById(id);
        if(product==null){
            throw new ProductNotFoundException("product not found for id "+id);
        }
        ProductDetails response=util.toProductDetails(product);
        return response;
    }
    @Override
    public ProductDetails changePrice(long id, ChangeProductRequest requestData) throws ProductNotFoundException {
        Product product=findById(id);
        product.setPrice(requestData.getPrice());
        product=productDao.save(product);
        ProductDetails response=util.toProductDetails(product);
        return response;
    }

    @Override
    public List<ProductDetails> findByName(String name) {
        List<Product> products=productDao.findByName(name);
        List<ProductDetails> response=util.toProductDetails(products);
        return response;
    }

    @Override
    public List<ProductDetails> findAll() {
        List<Product> products=productDao.findAll();
        List<ProductDetails> response=util.toProductDetails(products);
        return response;
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
