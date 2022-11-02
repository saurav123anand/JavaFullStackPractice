package com.example.optimizedproductms.controller;

import com.example.optimizedproductms.dto.AddProductRequest;
import com.example.optimizedproductms.dto.ChangeProductRequest;
import com.example.optimizedproductms.dto.ProductDetails;
import com.example.optimizedproductms.entity.Product;
import com.example.optimizedproductms.exception.ProductNotFoundException;
import com.example.optimizedproductms.service.IProductService;
import com.example.optimizedproductms.util.ProductUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/products")
@Validated
public class ProductController {
    @Autowired
    private IProductService service;
    @Autowired
    private ProductUtil util;

    //complete url
    //http://localhost:8585/products/findbyid/id
    @GetMapping("/findbyid/{id}")
    //@RequestMapping(value = "/products/findById/{id}",method = RequestMethod.GET)
    public ProductDetails findById(@PathVariable long id) throws Exception {
        ProductDetails response = service.findProductDetailsById(id);
        return response;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    //@RequestMapping(value = "/products/add",method = RequestMethod.POST)
    public ProductDetails addProduct(@RequestBody AddProductRequest requestData) {
        ProductDetails response = service.addProduct(requestData);
        return response;
    }

    @PutMapping("/update/price/{id}")
    public ProductDetails updatePrice(@PathVariable("id") long productId, @RequestBody ChangeProductRequest requestData) throws Exception {
        ProductDetails response = service.changePrice(productId, requestData);
        return response;
    }

    @GetMapping("/findbyname/{name}")
    //@RequestMapping(value = "/products/findById/{id}",method = RequestMethod.GET)
    public List<ProductDetails> findByName(@PathVariable String name) throws Exception {
        List<ProductDetails> response = service.findByName(name);
        return response;
    }

    @GetMapping("/findall")
    public List<ProductDetails> findAllProduct() {
        List<ProductDetails> response=service.findAll();
        return response;
    }

    @DeleteMapping("/deletebyid/{id}")
    public String removeProduct(@PathVariable long id) throws Exception {
        service.deleteProduct(id);
        return "product with id " + id + " deleted";
    }
}
