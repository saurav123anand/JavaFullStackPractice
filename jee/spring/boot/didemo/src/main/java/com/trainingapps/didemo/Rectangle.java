package com.trainingapps.didemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Rectangle implements IShape{
    @Value("${rect.len}")
    private int length;
    @Value("${rect.breadth}")
    private int breadth;

    public Rectangle() {
    }

    public Rectangle(int length,int breadth) {
        this.length=length;
        this.breadth = breadth;
    }
    public int area(){
        int area=length*breadth;
        return area;
    }
}
