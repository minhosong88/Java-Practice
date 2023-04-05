package exceptionHandling;

public class AutoCloseTest {
    public static void main(String[] args) {
        AutoCloseObj obj = new AutoCloseObj();
        try (obj){//원래 리소스를 try 내부에 선언하는데, Java 9부터 밖에 선언하고 try(변수) 방식으로 사용 가능.
            throw new Exception();
        } catch (Exception e) {
            System.out.println("예외 부분입니다.");
        }
    }
}
