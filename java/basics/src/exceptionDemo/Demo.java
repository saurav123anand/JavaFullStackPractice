package exceptionDemo;

public class Demo {
    public static void main(String[] args) {
        Demo demo=new Demo();
        System.out.println("execution starts");
        try{
            System.out.println("divide method");
            System.out.println(demo.divide(2,0));
        }
        catch (ArithmeticException e){
            System.out.println("arithmetic exception");
        }
        catch (Exception e){
            System.out.println("some error occurred");
        }

        System.out.println("execution ends");
    }
    public int divide(int num1,int num2) {
        return num1/num2;
    }

}
