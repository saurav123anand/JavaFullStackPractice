package iodemo.charstreamdemos;

import java.io.*;

public class ReadLineWriteReplaceString {
    public static void main(String[] args) {
        ReadLineWriteReplaceString fileCopyReadLineWrite=new ReadLineWriteReplaceString();
        fileCopyReadLineWrite.execute();
    }
    void execute(){
        File inputFile = new File("D:/sania/dir/info.txt");
        File outputFile = new File("D:/sania/dir/infoCopy.txt");
        Reader reader=null;
        Writer writer=null;
        try{
            reader=new FileReader(inputFile);
            writer=new FileWriter(outputFile);

            BufferedReader bufferedReader=new BufferedReader(reader);
            BufferedWriter bufferedWriter=new BufferedWriter(writer);
            String readLine;
            while((readLine=bufferedReader.readLine())!=null){
                if(readLine.contains("scooby")){
                    readLine=readLine.replace("scooby","guchhu");
                }
                bufferedWriter.write(readLine+"\n");
            }
            bufferedWriter.flush();
            System.out.println("file copy done, name replaced from scooby to guchhu");
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            close(reader);
            close(writer);
        }
    }
    void close(Reader reader){
        try{
            if(reader!=null){
                reader.close();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    void close(Writer writer){
        try{
            if(writer!=null){
                writer.close();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
