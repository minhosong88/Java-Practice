package lambdaExpression;

public class AddTest {
  public static void main(String[] args) {
    //인터페이스 선언 = 람다식 구현
    Add addL = (x, y) -> {return x+y;};
    System.out.println(addL.add(4, 5));
    //원래 인터페이스 구현을 위해서는 인터페이스 구현한 클래스 정의, 객체 생성 후 메서드 호출
    //람다식은 인터페이스 선언과 구현을 한 줄에 할 수 있다.

  }
}