package iodemo;

import java.io.File;

public class FileApi {
    public static void main(String[] args) {
         FileApi fileApi=new FileApi();
         fileApi.execute();
    }
    void execute(){
        File dir=new File("D:/sania/dir");
        File file=new File("D:/sania/dir/names.txt");
        boolean isDir=file.isDirectory();
        boolean isFile=file.isFile();
        boolean isExist=file.exists();

        System.out.println("names.txt is a directory "+isDir+" exists "+isExist);
        System.out.println("names.txt is a file "+isFile+" exists "+isExist);
        System.out.println(file.getName());

        //listing all the files in a directory
        System.out.println("listing all the files in a directory");
        File[] files=dir.listFiles();
        for(File iterated:files){
            System.out.println(iterated.getName());
        }



    }
}
