package iOStream;

import java.io.IOException;

public class SystemInTest {

    public static void main(String[] args) {
        System.out.println("Type an alphabet in and press ENTER: ");
        int i;

        try {
            i = System.in.read();
            System.out.println(i);
            System.out.println((char) i);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
