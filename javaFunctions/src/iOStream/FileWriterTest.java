package iOStream;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {
    public static void main(String[] args) {

        try (FileWriter fw = new FileWriter("writer.txt")) {
            fw.write('A');
            char[] buf = { 'B', 'C', 'D','E','F','G' };
            fw.write(buf); //Array
            fw.write("안녕하세요. 잘 써지네요"); // String
            fw.write(buf, 1, 4); // Array, offset from which to start writing, # of characters to write
            fw.write("1988"); // number

        } catch (IOException e) {
        e.printStackTrace();
        }
        System.out.println("Writing is complete.");
    }
}