package com.trainingapps.productms;

import com.trainingapps.productms.frontend.Frontend;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationMain {
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(JavaConfig.class);
        Frontend frontend=context.getBean(Frontend.class);
        frontend.runUI();
    }
}
