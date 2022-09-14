package com.trainingapps.didemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource("app.properties")
@ComponentScan("com.trainingapps.didemo")
@Configuration
public class JavaConfig {
/*
    @Bean
    public Square square(){
        Square square=new Square(7);
        return square;
    }
*/
}
