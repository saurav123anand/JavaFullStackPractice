package interfaceDemo;

public class Main {
    public static void main(String[] args) {
        ICalc casioCalc=new CasioCalc();
        System.out.println(casioCalc.sum(2,6));
    }
}
