package iOStream;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStream_File {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("input.txt")){
            //try의 매개변수 안에 넣으면 AutoClose가 된다.
            int i;
            while((i = fis.read()) != -1){
                System.out.println((char) i);
            }
            System.out.println();
            System.out.println("end"); //파일을 모두 다 읽어서 while 문을 빠져나오면 end가 출력된다.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
