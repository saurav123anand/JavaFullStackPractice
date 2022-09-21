package com.trainingapps.demo;

import com.trainingapps.demo.frontend.Frontend;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @Configuration
 * @ComponentScan
 * @EnableAutoConfiguration
 */
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(DemoApplication.class, args);
		Frontend frontend=context.getBean(Frontend.class);
		frontend.runUI();
	}

}
