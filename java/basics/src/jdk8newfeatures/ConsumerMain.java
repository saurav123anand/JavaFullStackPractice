package jdk8newfeatures;

import java.util.function.Consumer;

public class ConsumerMain {
    public static void main(String[] args) {
        IPrint printer=(input)-> System.out.println(input);
        printer.greet("hello");

        IPrint printer2=(input)-> {
            System.out.println(input);
        };
        printer2.greet("hi");

        //predefined consumer
        Consumer<String> consumer=(msg)-> System.out.println(msg);
        consumer.accept("good morning");
    }

}
