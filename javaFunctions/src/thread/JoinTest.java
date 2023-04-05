package thread;

public class JoinTest extends Thread {
    int start;
    int end;
    int total;
    public JoinTest(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public void run() {

        int i;
        for (i = start; i <= end; i++) {
            total += i;
        }
    }

    public static void main(String[] args) throws InterruptedException {

        System.out.println(Thread.currentThread() + " start");
        JoinTest joinTest = new JoinTest(1, 50);
        JoinTest joinTest2 = new JoinTest(51, 100);

        joinTest.start();
        joinTest2.start();

        try {
            joinTest.join();//join 메서드를 사용하면 main thread가 non-runnable이 되면서 다른 thread가
            joinTest2.join(); // 끝날 때까지 기다려준다.

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int sum = joinTest.total + joinTest2.total;
        System.out.println("first :" + joinTest.total);
        System.out.println("second :"+ joinTest2.total);
        System.out.println("total: " + sum);
        System.out.println(Thread.currentThread() + " end");

    }
}
