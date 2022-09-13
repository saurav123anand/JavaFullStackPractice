package com.trainingapps.didemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Canvas {
    @Autowired
    Square square;
    public Canvas(){
        System.out.println("calling default Canvas constructor");
    }
    //@Autowired
    public Canvas(Square square){
        System.out.println("calling parameterized Canvas Constructor");
        this.square=square;
    }
    //@Autowired
    public void setSquare(Square square) {
        this.square = square;
    }

    public void drawShape(){
        int area=square.area();
        System.out.println("area of square is "+area);
    }

}
