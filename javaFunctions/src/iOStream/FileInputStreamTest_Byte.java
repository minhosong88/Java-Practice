package iOStream;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamTest_Byte {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("input.txt");

            System.out.println((char) fis.read());
            System.out.println((char) fis.read());
            System.out.println((char) fis.read());

        } catch (IOException e) {
            System.out.println(e);

        } finally{
            try {
                fis.close();
            } catch (IOException e) {
                System.out.println(e);
            } catch (NullPointerException e) { //모르겠으면 마지막에다가 Exception 으로 걸어도 됨.
                System.out.println(e);
            }
        }
        System.out.println("end");
    } //fis = null 일 때는, exception handling이 안되는 경우 비정상 종료됨. exit code 1.
}     //가능한 모든 exception이 다 처리되면 exit code 0으로 정상적으로 작동 함.
        //create a file " input.txt" in the project and run it. Then you see the code works properly.