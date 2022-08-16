package interfaceDemo;

public class IBMCalc implements ICalc{
    public int add(int num1,int num2){
        return num1+num2;
    }

    @Override
    public int sum(int num1, int num2) {
        return num1+num2;
    }
}
