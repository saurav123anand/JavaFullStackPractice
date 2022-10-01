package com.trainingapps.productms.controller;

import com.trainingapps.productms.ProductApplication;
import com.trainingapps.productms.entity.Product;
import com.trainingapps.productms.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService service;

    //complete url
    //http://localhost:8585/products/findById/id
    @GetMapping("/findById/{id}")
    //@RequestMapping(value = "/products/findById/{id}",method = RequestMethod.GET)
    public Product findById(@PathVariable long id) throws Exception{
        Product product=service.findById(id);
        return product;
    }
    @PostMapping("/add")
    //@RequestMapping(value = "/products/add",method = RequestMethod.POST)
    public Product addProduct(@RequestBody Product requestData){
        Product product=service.addProduct(requestData.getName(),requestData.getPrice());
        return product;
    }
    @PutMapping("/update/price/{id}")
    public Product updatePrice(@PathVariable("id") long productId,@RequestBody Product requestData) throws Exception{
        Product product=service.changePrice(productId,requestData.getPrice());
        return product;
    }
    @GetMapping("/findall")
    public List<Product> findAllProduct(){
        return service.findAll();
    }
    @DeleteMapping("/deletebyid/{id}")
    public String removeProduct(@PathVariable long id) throws Exception{
        service.deleteProduct(id);
        return "product with id "+id+" deleted";
    }



}
