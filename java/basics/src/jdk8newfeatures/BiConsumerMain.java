package jdk8newfeatures;

import java.util.function.BiConsumer;

public class BiConsumerMain {
    public static void main(String[] args) {
        StringConcat stringConcat=(str1,str2)-> System.out.println(str1+" "+str2);
        stringConcat.concatString("good","afternoon");

        //predefined BiConsumer
        BiConsumer<String,String> biConsumer=(str1,str2)-> System.out.println(str1+" "+str2);
        biConsumer.accept("good","night");
    }
}
