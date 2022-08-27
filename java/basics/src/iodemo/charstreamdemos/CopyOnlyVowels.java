package iodemo.charstreamdemos;

import java.io.*;

public class CopyOnlyVowels {
    public static void main(String[] args) {
        CopyOnlyVowels copyOnlyVowels=new CopyOnlyVowels();
        copyOnlyVowels.execute();
    }

    void execute() {
        File inputFile = new File("D:/sania/dir/fruits.txt");
        File outputFile = new File("D:/sania/dir/fruitsVowelsCopy.txt");
        Reader reader = null;
        Writer writer = null;
        try {
            reader = new FileReader(inputFile);
            writer = new FileWriter(outputFile);
            int readChar;
            int vowelsCount = 0;
            while ((readChar = reader.read()) != -1) {
                char ch = (char) readChar;
                if(ch=='\n'){
                    writer.write('\n');
                }
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                        ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                    writer.write(ch);
                    vowelsCount++;
                }
            }
            System.out.println("file copy done and vowels count= " + vowelsCount);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
