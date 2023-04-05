package iOStream;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStream_ByteArray {
    public static void main(String[] args) {
        int i;
        try (FileInputStream fis = new FileInputStream("input.txt")) {
            byte[] bs = new byte[10];
            while ((i = fis.read(bs)) != -1) {

/*                for (int ch : bs) { //이 코드를 쓰면 buffer(bs)에 남는 자료가 마지막에 함께 출력된다.
                    System.out.print((char)ch);
*/
                for (int j = 0; j < i; j++) {
                    System.out.print((char) bs[j]);
                }
                System.out.println(" : " + i + "bytes read");
            }
        } catch (IOException ex) {
           ex.printStackTrace();
        }
    }
}
