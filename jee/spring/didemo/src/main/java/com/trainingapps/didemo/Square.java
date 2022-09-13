package com.trainingapps.didemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("sq")
public class Square {
    @Value("${square.side}")
    private int side;
    public Square(){

    }

    public Square(int side) {
        this.side = side;
    }
    public int area(){
        return side*side;
    }

}
