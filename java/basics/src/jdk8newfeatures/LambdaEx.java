package jdk8newfeatures;

public class LambdaEx {
    public static void main(String[] args) {
        //single line lambda expression
        ICalculator iCalculator=(num1, num2) -> num1+num2;
        int sumVal=iCalculator.sum(2,6);
        System.out.println("sum is "+sumVal);
        int subVal=iCalculator.subtract(3,4);
        System.out.println("subtraction is "+subVal);

        //multi line lambda expression
        ICalculator iCalculator2=(num1,num2)->{
            int sum=num1+num2;
            return num1+num2;
        };
        int sumVal2=iCalculator.sum(12,6);
        System.out.println("sum is "+sumVal2);


    }
}
