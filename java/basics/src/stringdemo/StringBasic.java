package stringdemo;

public class StringBasic {
    public static void main(String[] args) {
        String str1="hello";
        String str2="hello";
        String str3=str1+"world";
        System.out.println(str1==str2); //true
        System.out.println(str1.equals(str2)); //true
        System.out.println(str1==str3); //false
        System.out.println(str1.equals(str3)); //false

        String str4=new String("hello");
        String str5=new String("hello");
        System.out.println(str1==str4); //false
        System.out.println(str4==str5); //false
        System.out.println(str4.equals(str5)); //true



    }
}
