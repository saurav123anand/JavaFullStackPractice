package com.trainingapps.productms.frontend;

import com.trainingapps.productms.entity.Product;
import com.trainingapps.productms.exception.InvalidNameException;
import com.trainingapps.productms.exception.InvalidPriceException;
import com.trainingapps.productms.exception.ProductNotFoundException;
import com.trainingapps.productms.service.IProductService;
import com.trainingapps.productms.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class Frontend {
    @Autowired
    private IProductService service;
    public void runUI(){
        //adding products
        Product product1=service.addProduct("Samsung",12000);
        service.addProduct("motorola",14000);
        service.addProduct("Oppo A55",16000);

        // finding by id;
        try {
            System.out.println("getting product with id 2*********");
            Product found=service.findProductById(2);
            System.out.println(found);

            System.out.println("getting products before updating***********");
            Set<Product> allProductsBefore=service.findAll();
            for(Product product:allProductsBefore){
                if(product!=null){
                    System.out.println(product);
                }
            }
            System.out.println("changing price***************");
            Product update=service.changePrice(3,17000);
            System.out.println(update);

            System.out.println("getting products after updating**********");
            Set<Product> allProducts=service.findAll();
            for(Product product:allProducts){
                if(product!=null){
                    System.out.println(product);
                }
            }


        }
        catch (InvalidNameException | ProductNotFoundException | InvalidPriceException e){
            System.out.println(e.getMessage());
        }

    }
}
