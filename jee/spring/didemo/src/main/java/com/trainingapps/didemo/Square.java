package com.trainingapps.didemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
//@Scope("prototype")
@Component
public class Square implements IShape{
    @Value("${square.side}")
    private int side;
    public Square(){

    }
    public Square(int side) {
        this.side = side;
    }
    @Override
    public int area(){
        return side*side;
    }

}
