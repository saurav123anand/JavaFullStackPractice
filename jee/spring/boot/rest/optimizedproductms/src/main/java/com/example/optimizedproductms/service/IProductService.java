package com.example.optimizedproductms.service;

import com.example.optimizedproductms.dto.AddProductRequest;
import com.example.optimizedproductms.dto.ChangeProductRequest;
import com.example.optimizedproductms.dto.ProductDetails;
import com.example.optimizedproductms.entity.Product;
import com.example.optimizedproductms.exception.ProductNotFoundException;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
public interface IProductService {
    ProductDetails addProduct(@Valid AddProductRequest requestData);
    Product findById(@Min(value = 1,message = "id should not be less than 1") long id) throws ProductNotFoundException;
    ProductDetails findProductDetailsById(@Min(1) long id) throws ProductNotFoundException;
    ProductDetails changePrice(@Min(value = 1,message = "id should not be less than 1") long id, @Valid ChangeProductRequest requestData) throws ProductNotFoundException;
    List<ProductDetails> findByName(@NotNull @Length(min = 2) String name);
    List<ProductDetails> findAll();
    String deleteProduct(@Min(value = 1,message = "id should not be less than 1") long id) throws ProductNotFoundException;
}
