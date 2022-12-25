package com.example.jpamapping.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Id
    private int productId;
    private String productName;
    @ManyToMany(mappedBy = "products",fetch = FetchType.EAGER)
    private List<Category> categories;

    public Product() {
    }

    public Product(int productId, String productName, List<Category> categories) {
        this.productId = productId;
        this.productName = productName;
        this.categories = categories;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
