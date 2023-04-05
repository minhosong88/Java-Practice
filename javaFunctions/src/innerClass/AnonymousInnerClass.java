package innerClass;
class AnonymousOutClass{
    //원래 대로라면 클래스를 만들어 인스턴스 생성한 후에 Runnable 인터페이스를 implements 해서, 객체 생성 후 사용
    // new parents class() 또는 new interface() 를 사용.
    Runnable getRunnable(int i) {
        int num =25;
        return new Runnable() { // 객체 생성 따로 없이 new Runnable(인터페이스)() 사용 후 { 클래스 내용 }
            // 여기서는 인터페이스 내용인 run() 메서드를 정의했다. //localInnerClass와 비교해보면 됨.
            @Override
            public void run() {
                System.out.println("i: " + i);
                System.out.println("num: " + num);

            }
        };
    }

    Runnable runner = new Runnable() { //여기는 변수에 대입할 값에 익명클래스를 사용했다.
        @Override
        public void run() {
            System.out.println("Runnable이 구현된 익명 클래스 변수");
        }
    };
}

public class AnonymousInnerClass {
    public static void main(String[] args) {
        AnonymousOutClass out = new AnonymousOutClass();

        Runnable runnable = out.getRunnable(10);
        runnable.run();

        out.runner.run();

    }
}
