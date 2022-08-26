package iodemo;

import java.io.*;

public class GoodFileCopy {
    public static void main(String[] args) {
       GoodFileCopy goodFileCopy=new GoodFileCopy();
       goodFileCopy.execute();
    }
    void execute(){
        //File inputFile=new File("D:/sania/dir/names.txt");
        File inputFile=new File("E:/Hollywood movies/gravity.mkv");
        //File outputFile=new File("D:/sania/dir/namesCopy.txt");
        File outputFile=new File("D:/sania/dir/gravityCopy.mkv");
        InputStream inputStream=null;
        OutputStream outputStream=null;
        try {
            inputStream = new FileInputStream(inputFile);
            BufferedInputStream bufferedInputStream=new BufferedInputStream(inputStream);
            outputStream = new FileOutputStream(outputFile);
            BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(outputStream);
            byte readBytes[]=new byte[5];
            int bytesCount=0;
            int totalBytesCount=0;
            while ((bytesCount = bufferedInputStream.read(readBytes)) != -1) {
                bufferedOutputStream.write(readBytes,0,bytesCount);
                totalBytesCount=totalBytesCount+bytesCount;
            }
            System.out.println("file copy done bytes count=" + totalBytesCount);
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
