package com.example.userService.service;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@EnableAutoConfiguration
@Configuration
@ComponentScan
public class SystemConfig {
    @Bean(initMethod = "init")
    public UsersRepository usersRepository(){
        return  new UsersRepository();
    }
    @Bean
    public LegacyPaymentsService legacyPaymentsService(){
        return  new LegacyPaymentsService();
    }
    @PostConstruct
    public void initialize(){

    }


}
