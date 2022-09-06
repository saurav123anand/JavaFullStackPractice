package jdk8newfeatures;

import java.util.function.BiPredicate;

public class BiPredicateMain {
    public static void main(String[] args) {
        IEqual iEqual=(num1,num2)->num1==num2;
        boolean isTrue=iEqual.isTwoValueEqual(12,12);
        System.out.println(isTrue);

        BiPredicate<Integer,Integer> biPredicate=(num1,num2)->num1==num2;
        boolean isTrue2=biPredicate.test(12,13);
        System.out.println(isTrue2);
    }

}
