package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.service.IProductService;
import com.example.demo.service.ProductServiceImpl;
import jdk.internal.icu.text.NormalizerBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    IProductService service;
    Product product=new Product("samsung",20000);

    // http://localhost:8585/addproduct
    @GetMapping("/addproduct")
    public ModelAndView addProductPage(){
        ModelAndView modelAndView=new ModelAndView("addproduct");
        return modelAndView;
    }
    @GetMapping("/productdetails")
    public ModelAndView productDetails(@RequestParam int id) throws ProductNotFoundException {
        Product product=service.findById(id);
        ModelAndView modelAndView=new ModelAndView("productdetails","product",product);
        return modelAndView;
    }
    @GetMapping("/processedproduct")
    public RedirectView addProduct(@RequestParam String name,@RequestParam double price){
        Product product=service.addProduct(name,price);
        String url="/productdetails?id="+product.getId();
        RedirectView redirectView=new RedirectView(url);
        return redirectView;
    }
    @GetMapping("/getproduct")
    public ModelAndView getProduct(){
        ModelAndView modelAndView=new ModelAndView("getproduct");
        return modelAndView;
    }
    @GetMapping("getallproducts")
    public ModelAndView findAll(){
        List<Product> productList=service.findAll();
        ModelAndView modelAndView=new ModelAndView("productslist","products",productList);
        return modelAndView;
    }



}

