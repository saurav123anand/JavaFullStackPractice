package interfaceDemo;

public class CasioCalc implements ICalc{
    @Override
    public int sum(int num1,int num2){
      return num1+num2;
    }
}
