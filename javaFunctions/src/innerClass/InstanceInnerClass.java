package innerClass;
class OutClass {
    private int num = 15;
    private static int sNum = 25;
    private InClass inClass;

    public OutClass() {
        inClass = new InClass();
    }

    class InClass { //클래스 내부에 또 다른 클래스를 생성. 인스턴스처럼 사용가능.
        int inNum = 30;
        static int sInNum = 15; //에러 나야하는데 안남.

        void inTest() {
            System.out.println("OutClass num: " + num + " 외부 클래스 인스턴스 변수");
            System.out.println("OutClass.sNum " + sNum + " 외부 클래스 정적 변수");
            System.out.println("InClass.inNum " + inNum + " 내부 클래스 인스턴스 변수");
        }
    }

    public void usingClass() { //외부클래스를 만들면 내부클래스 변수를 사용하여 메서드 사용가능
        inClass.inTest(); //외부클래스 메서드의 내용이 내부 클래스의 메서드를 호출하는 것.
    }
}
public class InstanceInnerClass {

    public static void main(String[] args) {
        OutClass outClass = new OutClass();
        System.out.println("외부클래스 인스턴스로 내부클래스 메서드 호출");
        outClass.usingClass();
        System.out.println();

        System.out.println("내부클래스 생성해서 메서드 호출");
        OutClass.InClass inClass = outClass.new InClass(); //호출경로가 다름.
        inClass.inTest();
    }
}
