package iOStream;

import java.io.*;

public class BufferedStreamTest {
    public static void main(String[] args) {
        long millisecond = 0;
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("a.zip"));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("copy.zip"))){

            millisecond = System.currentTimeMillis();

            int i;
            while ((i = bis.read()) != -1) {
                bos.write(i);
            }
            millisecond = System.currentTimeMillis() - millisecond;
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("It took "+ millisecond + "millisecond to complete copying the file.");

    }
}
