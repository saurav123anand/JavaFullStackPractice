package jdk8newfeatures;

import java.util.function.Supplier;

public class SupplierMain {
    public static void main(String[] args) {
        //custom supplier
        IGreeter greeter=()->"good morning";
        String msg1=greeter.greet();
        System.out.println(msg1);

        //alternative way
        IGreeter greeter2=()->{
            String msg="good morning";
            return msg;
        };
        String msg2=greeter2.greet();
        System.out.println(msg2);

        //predefined supplier
        Supplier<String> supplier=()->"good morning";
        String msg3=supplier.get();
        System.out.println("value for predefined supplier is "+msg3);




    }

}
