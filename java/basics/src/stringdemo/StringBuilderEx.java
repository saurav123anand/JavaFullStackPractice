package stringdemo;
import java.lang.*;
public class StringBuilderEx {
    public static void main(String[] args) {
        StringBuilder stringBuilder=new StringBuilder("hello");
        stringBuilder.append("hi");
        stringBuilder.append("world");
        stringBuilder.append("good morning");
        stringBuilder.append("good afternoon").append("evening").append("same");
        System.out.println(stringBuilder);
    }
}
