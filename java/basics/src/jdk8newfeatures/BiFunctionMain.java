package jdk8newfeatures;

import java.util.function.BiFunction;

public class BiFunctionMain {
    public static void main(String[] args) {
        ISum iSum=(num1,num2)->num1+num2;
        int value=iSum.sum(4,7);
        System.out.println("sum value is "+value);

        BiFunction<Integer,Integer,Integer> biFunction=(num1,num2)->num1+num2;
        int value2=biFunction.apply(7,9);
        System.out.println(value2);
    }

}
