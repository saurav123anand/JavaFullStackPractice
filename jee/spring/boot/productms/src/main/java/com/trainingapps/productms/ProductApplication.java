package com.trainingapps.productms;

import com.trainingapps.productms.frontend.Frontend;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ProductApplication {
	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(ProductApplication.class, args);
		Frontend frontend=context.getBean(Frontend.class);
		frontend.runUI();
	}

}
