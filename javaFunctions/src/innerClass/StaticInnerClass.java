package innerClass;
class OuterClass{

    private int num = 150;
    private static int sNum = 250;

    public OuterClass() {
    }

    static class InnerStaticClass{ //내부 클래스라도 정적클래스면 다른 모든 클래스 생성 이전에 메모리가 잡힌다.
        int inNum = 350;
        static int sInNum = 50;

        void inTest() {
            sNum+=5;
            System.out.println("num: 외부 인스턴스 변수 사용불가");
            System.out.println("sNum:"  + sNum + " 외부 정적 변수");
            System.out.println("inNum: " + inNum + " 내부 인스턴스 변수");
            System.out.println("sInNum: " + sInNum + " 내부 정적 변수");
            System.out.println("=====================================");
        }

        static void sTest() { //정적 메소드는 인스턴스 생성 이전에 메모리 할당됨.
            sNum -= 5;
            sInNum %= 5;
            System.out.println("num: 외부 인스턴스 변수 사용불가");
            System.out.println("sNum:"  + sNum + " 외부 정적 변수");
            System.out.println("inNum: 내부 인스턴스 변수 사용불가");
            System.out.println("sInNum: " + sInNum + " 내부 정적 변수");
            System.out.println("=====================================");

        }
    }
}


public class StaticInnerClass {
    public static void main(String[] args) {
        OuterClass.InnerStaticClass sInnerClass = new OuterClass.InnerStaticClass();
        // 정적내부클래스는 내부에 있어서 경로는 OuterClass 다음에 배정된다.
        // 외부클래스를 먼저 생성할 필요는 없지만, 만들 때 OuterCLass.를 통해 배정된 경로를 따라 생성함.
        // 인스턴스 내부 클래스는 이미 생성된 외부클래스의 인스턴스의 경로로 내부클래스 인스턴스 생성함.
        System.out.println("정적내부클래스 일반 메서드:");
        sInnerClass.inTest();
        System.out.println("정적내부클래스 정적 메서드:");
        sInnerClass.sTest();

    }
}
