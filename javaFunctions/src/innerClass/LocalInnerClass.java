package innerClass;
class LocalOut{
    private int outNum = 40;
    private static int sNum = 15;

    Runnable getRunnable(int i) { //Runnable은 Thread로 실행하는 인터페이스
        //메서드에서 내부클래스 생성 시 메서드의 지역변수와 매개변수는 final 처리된다.
        int num = 45;
        class MyRunnable implements Runnable{ //메서드 내부에서 클래스 생성해서 로컬내부클래스.
            int localNum =10;
            @Override
            public void run() {
                localNum *=2;
                System.out.println("i: " + i);
                System.out.println("num: " + num);
                System.out.println("localNum: " + localNum);
                System.out.println("outNum: " + outNum + " 외부 인스턴스 변수");
                System.out.println("sNum: " + sNum + " 외부 정적변수");

            }
        }
        return new MyRunnable(); //메서드 호출되면 새 내부클래스가 생성된다.
    }
}
public class LocalInnerClass {

    public static void main(String[] args) {
        LocalOut localOut = new LocalOut();
        Runnable runner = localOut.getRunnable(7); //러너블 변수에 외부클래스의 메서드를 호출
        //호출하면 내부클래스 생성하게 됨.
        runner.run();
        //생성된 Runnable 변수로 내부클래스에 정의된 메서드를 호출한다.
    }
}
