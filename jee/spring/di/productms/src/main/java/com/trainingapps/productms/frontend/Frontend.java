package com.trainingapps.productms.frontend;

import com.trainingapps.productms.entity.Product;
import com.trainingapps.productms.exception.InvalidIdException;
import com.trainingapps.productms.exception.InvalidNameException;
import com.trainingapps.productms.exception.InvalidPriceException;
import com.trainingapps.productms.exception.ProductNotFoundException;
import com.trainingapps.productms.service.IProductService;
import com.trainingapps.productms.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class Frontend {
    @Autowired
    IProductService service;
    public void runUI(){
        service.addProduct("Samsung",10000);
        service.addProduct("micromax",12000);
        service.addProduct("IPhone",120000);
        try {
            Product foundProductById=service.findProductById(2);
            System.out.println(foundProductById);
            System.out.println("getting all the products*******************");
            List<Product> foundAllProducts=service.findAllProduct();
            for (Product product:foundAllProducts){
                System.out.println(product);
            }
            System.out.println("getting updated product*************");
            Product updatedProduct=service.changePrice(2,23000);
            System.out.println(updatedProduct);

            System.out.println("getting all the products after updating*******************");
            List<Product> foundAllProductsAfterUpdating=service.findAllProduct();
            for (Product product:foundAllProductsAfterUpdating){
                System.out.println(product);
            }
            System.out.println("deleting product*************");
            String deletedProduct=service.deleteProduct(2);
            System.out.println(deletedProduct);

            System.out.println("getting all the products after deleting*******************");
            List<Product> foundAllProductsAfterDeleting=service.findAllProduct();
            for (Product product:foundAllProductsAfterDeleting){
                System.out.println(product);
            }
        }
        catch (InvalidIdException | InvalidNameException | InvalidPriceException | ProductNotFoundException e){
            System.out.println(e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
        }



    }
}
