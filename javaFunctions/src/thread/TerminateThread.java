package thread;

import java.io.IOException;

public class TerminateThread extends Thread {
        private boolean flag = false;
        int i;

    public TerminateThread(String name) {
        super(name);

    }
    public void run() {
        while (!flag) { //무한루프를 돌릴 때에 멈출 일이 있을 수도 있으므로, flag를 두고 setFlag를 통해 멈춘다.
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(getName() + " end");
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public static void main(String[] args) {
        TerminateThread threadA = new TerminateThread("A");
        TerminateThread threadB = new TerminateThread("B");
        TerminateThread threadC = new TerminateThread("C");

        threadA.start();
        threadB.start();
        threadC.start();

        int in;
        while (true) {
            try {
                in = System.in.read ();

            if (in == 'A') {
                threadA.setFlag(true);
            } else if (in == 'B') {
                threadB.setFlag(true);
            } else if (in == 'C') {
                threadC.setFlag(true);
            } else if (in == 'M') {
                threadA.setFlag(true);
                threadB.setFlag(true);
                threadC.setFlag(true);
                break;
            }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("main end");
    }
}

