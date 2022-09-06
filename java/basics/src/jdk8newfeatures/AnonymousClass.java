package jdk8newfeatures;

public class AnonymousClass {
    public static void main(String[] args) {
        ICalculator iCalculator=new ICalculator() {
            @Override
            public int sum(int num1, int num2) {
                System.out.println("hello");
                return num1+num2;
            }
            public int multiply(int num1, int num2) {
                return num1*num2;
            }
        };
        int sumVal=iCalculator.sum(23,21);
        System.out.println("sum of two number is "+sumVal);

        int subVal=iCalculator.subtract(12,6);
        System.out.println("subtraction of two number is "+subVal);

    }
}
