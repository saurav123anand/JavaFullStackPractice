package com.example.optimizedproductms.util;

import com.example.optimizedproductms.dto.ProductDetails;
import com.example.optimizedproductms.entity.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductUtil {
    public ProductDetails toProductDetails(Product product){
        ProductDetails response=new ProductDetails();
        response.setId(product.getId());
        response.setName(product.getName());
        response.setPrice(product.getPrice());
        return response;
    }
    public List<ProductDetails> toProductDetails(List<Product> products){
        List<ProductDetails> response=new ArrayList<>();
        for(Product product:products){
            ProductDetails details=toProductDetails(product);
            response.add(details);
        }
        return response;
    }

}
