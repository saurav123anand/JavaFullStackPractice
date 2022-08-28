package iodemo.charstreamdemos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ReadWriteUsingScanner2 {
    public static void main(String[] args) {
        ReadWriteUsingScanner2 readWriteUsingScanner=new ReadWriteUsingScanner2();
        readWriteUsingScanner.execute();

    }
    void execute(){
        File file=new File("D:/sania/dir/info.txt");
        Scanner sc=null;
        try{
            sc=new Scanner(file);
            while(sc.hasNextLine()){
               String line=sc.nextLine();
               line=line.trim();
               String[] words=line.split(",");
                System.out.println("words in the line "+ Arrays.asList(words));
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
