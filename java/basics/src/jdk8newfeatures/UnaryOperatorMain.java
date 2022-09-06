package jdk8newfeatures;

import java.util.function.UnaryOperator;

public class UnaryOperatorMain {
    public static void main(String[] args) {
        IValue iValue=num->num;
        int value=iValue.getValue(23);
        System.out.println("value is "+value);

        UnaryOperator<Integer> integerFunction= num->num;
        int value2=integerFunction.apply(56);
        System.out.println("value2 is "+value2);


    }

}
