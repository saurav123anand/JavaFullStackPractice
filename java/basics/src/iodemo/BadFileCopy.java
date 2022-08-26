package iodemo;

import java.io.*;

public class BadFileCopy {
    public static void main(String[] args) {
        BadFileCopy fileCopy=new BadFileCopy();
       /* try {
            fileCopy.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        fileCopy.execute1();
    }
    /*void execute() throws FileNotFoundException,IOException {
        File inputFile=new File("D:/sania/dir/names.txt");
        File outputFile=new File("D:/sania/dir/namesCopy.txt");
        InputStream inputStream=new FileInputStream(inputFile);
        OutputStream outputStream=new FileOutputStream(outputFile);
        int readByte;
        int bytesCount=0;
        while((readByte=inputStream.read())!=-1){
            outputStream.write(readByte);
            bytesCount++;
        }
        System.out.println("file copy done bytes count="+bytesCount);
    }*/
    void execute1(){
        File inputFile=new File("D:/sania/dir/names.txt");
        File outputFile=new File("D:/sania/dir/namesCopy.txt");
        InputStream inputStream=null;
        OutputStream outputStream=null;
        try {
            inputStream = new FileInputStream(inputFile);
            outputStream = new FileOutputStream(outputFile);
            int readByte=0;
            int bytesCount = 0;
            while ((readByte = inputStream.read()) != -1) {
                outputStream.write(readByte);
                bytesCount++;
            }
            System.out.println("file copy done bytes count=" + bytesCount);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            close(inputStream);
            close(outputStream);
        }
    }
    void close(InputStream inputStream){
        try {
            if(inputStream!=null){
                inputStream.close();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
    void close(OutputStream outputStream){
        try {
            if(outputStream!=null){
                outputStream.close();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
