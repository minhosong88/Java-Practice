package iOStream;

import java.io.IOException;

public class SystemInTestR {
        public static void enterAlphabets(){ //객체생성 없이 쓰려면 static으로 선언.
            int i;
            System.out.println("Type alphabets in and press Enter: ");
            for(int j = 0; j < 100; j++) {
                //while(true)를 했기 때문에 if문의 조건을 빠져 나와도 다시 while에 걸려서 무한 반복된다.
                try {
                    if ((i = System.in.read()) != '\n') {
                        System.out.print((char) i);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("message is limited to 100 characters");


        }
    public static void main(String[] args) {
        enterAlphabets();

    }
}
