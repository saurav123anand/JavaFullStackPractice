package com.trainingapps.didemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Scope("prototype")
@Component
public class Canvas {
    @Qualifier("rectangle")
    @Autowired
    IShape shape;
    public Canvas(){
        System.out.println("calling default Canvas constructor");
    }
    //@Autowired
    public Canvas(IShape shape){
        System.out.println("calling parameterized Canvas Constructor");
        this.shape=shape;
    }
    //@Autowired
    public void setSquare(IShape square) {
        this.shape = shape;
    }

    public void drawShape(){
        System.out.println(shape.getClass().getName());
        int area=shape.area();
        System.out.println("area of shape is "+area);
    }
    @PostConstruct
    public void afterInitialized(){
        System.out.println("Canvas object has been created");
    }
    @PreDestroy
    public void beforeDestroy(){
        System.out.println("before canvas object is destroyed");
    }

}
