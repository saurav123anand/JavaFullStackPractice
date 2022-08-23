package com.trainingapps.productms.dao;

import com.trainingapps.productms.entity.Product;

public class ProductDaoImpl implements IProductDao {
    Product products[];

    public ProductDaoImpl(int capacity) {
        products = new Product[capacity];
    }

    private long generatedId;

    private void generateId() {
        ++generatedId;
    }

    private int index = 0;

    @Override
    public void add(Product product) {
        if (index < products.length) {
            product.setId(generatedId);
            products[index] = product;
            index++;
        }
    }

    @Override
    public Product findById(long id) {
        for (Product product : products) {
            if (product != null && product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void update(Product product) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getId() == product.getId()) {
                products[i] = product;
                return;
            }
        }
    }

    @Override
    public Product[] findAll() {
        return products;
    }

    @Override
    public void delete(Product product) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getId() == product.getId()) {
                products[i] = null;
                return;
            }
        }
    }
}
