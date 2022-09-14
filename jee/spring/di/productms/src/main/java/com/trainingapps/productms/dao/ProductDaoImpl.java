package com.trainingapps.productms.dao;

import com.trainingapps.productms.entity.Product;
import org.springframework.stereotype.Component;

import java.util.*;
@Component
public class ProductDaoImpl implements IProductDao {
    private Map<Integer, Product> products;

    public ProductDaoImpl() {
        products = new HashMap<>();
    }

    private int generatedId;

    public int generateId() {
        return ++generatedId;
    }

    @Override
    public void add(Product product) {
        int id=generateId();
        product.setId(id);
        products.put(id,product);
    }

    @Override
    public Product findById(int id) {
        Set<Integer> keys=products.keySet();
        for(Integer key:keys){
            Product product=products.get(key);
            if(product!=null && product.getId()==id){
                return product;
            }
        }
        return null;
    }

    @Override
    public List<Product> findAll() {
        Collection<Product> productCollection=products.values();
        List<Product> products=new ArrayList<>(productCollection);
        return products;
    }

    @Override
    public void updateProduct(Product product) {
          products.put(product.getId(),product);
    }

    @Override
    public void deleteProduct(Product product) {
        products.remove(product.getId());
    }
}
