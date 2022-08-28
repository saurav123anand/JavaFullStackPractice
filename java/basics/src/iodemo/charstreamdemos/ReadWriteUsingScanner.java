package iodemo.charstreamdemos;

import javax.security.sasl.SaslClient;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ReadWriteUsingScanner {
    public static void main(String[] args) {
        ReadWriteUsingScanner readWriteUsingScanner=new ReadWriteUsingScanner();
        readWriteUsingScanner.execute();

    }
    void execute(){
        File file=new File("D:/sania/dir/fruits.txt");
        Scanner sc=null;
        try{
            sc=new Scanner(file);
            while(sc.hasNext()){
               String fruit=sc.next();
               System.out.println("fruit name is "+fruit);
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        finally {
            sc.close();
        }

    }
}
