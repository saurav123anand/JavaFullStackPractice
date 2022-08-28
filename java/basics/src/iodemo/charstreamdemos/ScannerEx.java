package iodemo.charstreamdemos;

import java.io.InputStream;
import java.util.Scanner;

public class ScannerEx {
    public static void main(String[] args) {
        InputStream inputStream=System.in;
        Scanner sc=new Scanner(inputStream);
        System.out.println("enter a number");
        int num=sc.nextInt();
        System.out.println("value entered ="+num);
        sc.close();
    }
}
