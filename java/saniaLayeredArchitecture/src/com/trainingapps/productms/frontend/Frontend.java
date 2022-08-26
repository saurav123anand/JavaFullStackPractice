package com.trainingapps.productms.frontend;

import com.trainingapps.productms.entity.Product;
import com.trainingapps.productms.exceptions.InvalidIdException;
import com.trainingapps.productms.exceptions.InvalidNameException;
import com.trainingapps.productms.exceptions.InvalidPriceException;
import com.trainingapps.productms.exceptions.ProductNotFoundException;
import com.trainingapps.productms.service.IProductService;
import com.trainingapps.productms.service.ProductServiceImpl;

public class Frontend {
    public void runUI() {
        try {
            IProductService productService = new ProductServiceImpl(10);
            Product product = productService.addProduct("Samsung", 12000);
            System.out.println("product added");
            productService.addProduct("Motorola", 15000);
            productService.addProduct("Nokia", 2000);

            System.out.println("getting all the products*****************************");
            Product[] products = productService.findAll();
            display(products);

            long id = 2;
            System.out.println("finding product by id " + id);
            Product foundProductById = productService.findById(id);
            display(foundProductById);

            System.out.println("changing the price**************");
            Product changePrice = productService.changePrice(2, 20000);
            display(changePrice);

            System.out.println("getting all the products after changing the price*****************************");
            Product[] productsAfterChangePrice = productService.findAll();
            display(productsAfterChangePrice);

            System.out.println("deleting the product*****");
            Product deletedProduct = productService.delete(1);
            System.out.println(deletedProduct + " has been deleted");

            System.out.println("getting all the products after deleting the product*****************************");
            Product[] productsAfterDeletingProduct = productService.findAll();
            display(productsAfterDeletingProduct);

        } catch (InvalidIdException e) {
            System.out.println(e.getMessage());
        } catch (InvalidNameException e) {
            System.out.println(e.getMessage());
        } catch (InvalidPriceException e) {
            System.out.println(e.getMessage());
        } catch (ProductNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("something went wrong");
        }


    }

    private void display(Product[] products) {
        for (Product product : products) {
            if (product != null) {
                display(product);
            }
        }
    }

    private void display(Product product) {
        System.out.println("Id is " + product.getId() + " name is " + product.getName() + " price is " +
                product.getPrice());


    }
}
