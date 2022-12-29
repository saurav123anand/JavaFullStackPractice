package com.example.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class LoggerApplication {
	private static final Logger logger= LoggerFactory.getLogger(LoggerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LoggerApplication.class, args);
		logger.debug("i'm debug");
		logger.info("i'm info");
		logger.error("i'm error");
	}

}
