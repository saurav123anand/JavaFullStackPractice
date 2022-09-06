package jdk8newfeatures;

@FunctionalInterface
public interface ICalculator {
    int sum(int num1,int num2);
    default int subtract(int num1,int num2){
        return num1-num2;
    }
}
