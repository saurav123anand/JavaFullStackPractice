package stringdemo;

public class StringBufferEx {
    public static void main(String[] args) {
        StringBuffer stringBuffer=new StringBuffer("hello");
        stringBuffer.append("hi");
        stringBuffer.append("world");
        stringBuffer.append("good morning");
        stringBuffer.append("good afternoon").append("evening").append("same");
        System.out.println(stringBuffer);
    }
}
