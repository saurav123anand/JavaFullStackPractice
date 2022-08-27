package iodemo.charstreamdemos;

import java.io.*;

public class ReadWriteLine {
    public static void main(String[] args) {
        ReadWriteLine readWriteLine=new ReadWriteLine();
        readWriteLine.execute();
    }
    void execute(){
        InputStream inputStream=System.in;
        OutputStream outputStream=System.out;
        Reader reader=null;
        Writer writer=null;
        try{
            reader=new InputStreamReader(inputStream);
            writer=new OutputStreamWriter(outputStream);
            BufferedReader bufferedReader=new BufferedReader(reader);
            BufferedWriter bufferedWriter=new BufferedWriter(writer);
            System.out.println("Reading line and will printed back");
            String line=bufferedReader.readLine();
            bufferedWriter.write(line);
            bufferedWriter.flush();
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
        try {
            if(reader!=null){
                reader.close();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
    void close(Writer writer){
        try {
            if(writer!=null){
                writer.close();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}
