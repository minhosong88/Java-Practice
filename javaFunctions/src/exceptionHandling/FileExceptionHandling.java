package exceptionHandling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileExceptionHandling {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("a.txt"); //이 경우에 file이 없는 경우가 있으므로 일단 try하고
        } catch (FileNotFoundException e) {
            System.out.println(e); //없으면 메세지를 출력하도록 함.
            //return;
        } finally {
            if (fis != null) { //그리고 finally 로 넘어와서 수행한다. finally 내부는 오류가 있든 없든 항상 수행된다.
                try { // fis == null 이므로 아래는 실행 안됨.
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Finally 내부문은 항상 수행됩니다.");
        }
        System.out.println("여기도 수행됩니다.");

    }
}
