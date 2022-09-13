package com.trainingapps.didemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppMain {
    public static void main(String[] args) {
        /*Square square1=new Square();
        Canvas canvas1=new Canvas(square1);
        canvas1.drawShape();

        Square square2=new Square(7);
        Canvas canvas2=new Canvas();
        canvas2.setSquare(square2);
        canvas2.drawShape();*/

        ApplicationContext context=new AnnotationConfigApplicationContext(JavaConfig.class);
        Canvas canvas=context.getBean(Canvas.class);
        canvas.drawShape();
    }
}
