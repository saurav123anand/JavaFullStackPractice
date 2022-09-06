package jdk8newfeatures;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class BinaryOperatorMain {
    public static void main(String[] args) {
        ISum iSum=(num1,num2)->num1+num2;
        int sum1=iSum.sum(4,7);
        System.out.println("sum1 is "+sum1);

        BinaryOperator<Integer> binaryOperator=(num1, num2)->num1+num2;
        int sum2=binaryOperator.apply(7,9);
        System.out.println("sum2 is "+sum2);
    }
}
