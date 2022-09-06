package jdk8newfeatures;

import java.util.function.Function;

public class FunctionMain {
    public static void main(String[] args) {
        IIntegerConverter iIntegerConverter=(str)->Integer.parseInt(str);
        int value=iIntegerConverter.convert("100");
        System.out.println("converted value is "+value);

        Function<String,Integer> integerFunction=(str)->Integer.parseInt(str);
        int value2=integerFunction.apply("200");
        System.out.println(value2);
    }

}
