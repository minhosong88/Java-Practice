package thread;

class PriorityThread extends Thread {
    public void run() {
        int sum = 0;
        Thread thread = Thread.currentThread();
        System.out.println(thread + " start");
        for (int i = 0; i < 100000; i++) {
            sum += i;
        }
        System.out.println(sum);
        System.out.println(thread.getPriority() + " end");
    }


}

public class PriorityThreadTest {
    public static void main(String[] args) {
        int i;
        for (i = Thread.MIN_PRIORITY; 1 < Thread.MAX_PRIORITY; i++) {
            PriorityThread pt = new PriorityThread();
            pt.setPriority(i);
            pt.start();
        } // 반복할 때 마다 새로운 thread를 만들어서 우선순위를 붙여서 실행시킨다.
            //실행된 thread의 내용은 위에 정의된 run() 메서드.
    }
}
