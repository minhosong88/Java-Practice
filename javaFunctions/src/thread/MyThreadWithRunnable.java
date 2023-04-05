package thread;

class MyThreads implements Runnable {

    @Override
    public void run() {
        int i;
        for (i = 0; i < 200; i++) {
            System.out.print(i + "\t");
        }
    }
}
public class MyThreadWithRunnable {
    public static void main(String[] args) {
        System.out.println("main start");

        MyThreads mth = new MyThreads(); // Runnable interface 구현한 객체 생성
        Thread thr = new Thread(mth); // Thread 안에 run 메서드가 정의된 객체를 넣으면, thread로 실행해준다.
        thr.start();

        Thread thr2 = new Thread(new MyThreads());
        thr2.start();

        System.out.println("main end");
    }
}
