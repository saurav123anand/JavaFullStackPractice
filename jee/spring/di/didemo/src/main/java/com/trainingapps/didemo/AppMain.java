package com.trainingapps.didemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class AppMain {
    public static void main(String[] args) {
        /*Square square1=new Square();
        Canvas canvas1=new Canvas(square1);
        canvas1.drawShape();

        Square square2=new Square(7);
        Canvas canvas2=new Canvas();
        canvas2.setSquare(square2);
        canvas2.drawShape();*/

        ConfigurableApplicationContext context=new AnnotationConfigApplicationContext(JavaConfig.class);
        //getting bean by type
        Canvas canvas1=context.getBean(Canvas.class);
        canvas1.drawShape();

        //getting bean by name
        //Canvas canvas1=(Canvas) context.getBean("canvas");
        Canvas canvas2=context.getBean("canvas",Canvas.class);
        canvas2.drawShape();

        boolean isBoolean=canvas1==canvas2;
        System.out.println(isBoolean);

        Square square1=context.getBean(Square.class);
        Square square2=context.getBean(Square.class);
        context.close();

    }
}
