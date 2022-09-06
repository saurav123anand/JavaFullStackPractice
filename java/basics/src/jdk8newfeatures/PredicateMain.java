package jdk8newfeatures;

import java.util.function.Predicate;

public class PredicateMain {
    public static void main(String[] args) {
        IEven iEven=num->num%2==0;
        boolean isEvenTrue=iEven.isEven(24);
        System.out.println(isEvenTrue);

        Predicate<Integer> integerPredicate=num->num%2==0;
        boolean isEvenTrue2=integerPredicate.test(56);
        System.out.println(isEvenTrue2);
    }

}
