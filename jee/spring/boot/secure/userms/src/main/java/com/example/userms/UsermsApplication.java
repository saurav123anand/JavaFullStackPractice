package com.example.userms;

import com.example.userms.util.AuthenticationFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UsermsApplication {
    public static void main(String[] args) {
        SpringApplication.run(UsermsApplication.class, args);
    }

    @Bean
    public AuthenticationFilter authenticationFilter() {
        return new AuthenticationFilter();
    }

    @Bean
    public FilterRegistrationBean<AuthenticationFilter> registrationFilter() {
        FilterRegistrationBean<AuthenticationFilter> registration = new FilterRegistrationBean<>();
        registration.addUrlPatterns("/users/*");
        registration.setFilter(authenticationFilter());
        return registration;
    }


}
