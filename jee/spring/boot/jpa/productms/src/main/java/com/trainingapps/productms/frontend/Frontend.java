package com.trainingapps.productms.frontend;

import com.trainingapps.productms.entity.Product;
import com.trainingapps.productms.exception.InvalidIdException;
import com.trainingapps.productms.exception.InvalidNameException;
import com.trainingapps.productms.exception.InvalidPriceException;
import com.trainingapps.productms.exception.ProductNotFoundException;
import com.trainingapps.productms.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Frontend {
    @Autowired
    IProductService service;
    public void runUI(){
        try{
            Product product1=service.add("samsung",12000);
           // display(product1);
            Product product2=service.add("motorolla",15000);
            Product product3=service.add("samsung",20000);

            //display(product2);

            System.out.println("find by id**************");
            Product foundById=service.findById(2);
            display(foundById);

            System.out.println("find by name**********");
            List<Product> findByName=service.findByName("samsung");
            display(findByName);

            System.out.println("getting all products before updating*********");
            List<Product> findAll=service.findAll();
            display(findAll);

            System.out.println("changing price************");
            Product update=service.changePrice(1,10000);
            display(update);

            System.out.println("getting all products after updating*********");
            List<Product> findAllAfterUpdate=service.findAll();
            display(findAllAfterUpdate);


        }
        catch (InvalidIdException | InvalidPriceException | InvalidNameException | ProductNotFoundException e){
            System.out.println(e.getMessage());
        }

    }
    void display(Product product){
        if(product!=null){
            System.out.println("id is "+product.getId()+" name is "+product.getName()+" " +
                    "price is "+product.getPrice());
        }
    }
    void display(List<Product> products){
       for(Product product:products){
           display(product);
       }
    }
}
