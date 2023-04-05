package thread;

class Bank { //공유자원에 두 Thread가 동시에 접근할 때 오류를 막기 위해 사용.
    private int money = 10000; //공유자원 : Bank 타입의 money.

 /*   public void saveMoney(int save) { //이 방법은 synchronized를 메서드 안으로 넣고 객체를 감싸서
        synchronized (this) {       // 다른 thread가 작동하는 동안 그 객체를 다른 thread에서 못 쓰게
            int m = getMoney();    // block처리를 하는 것.
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            setMoney(m+save);
        }
    }*/

    public synchronized void saveMoney(int save) {
        int m = getMoney();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setMoney(m + save);
    }

    public synchronized void withdrawMoney(int minus) {
        int m = getMoney();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setMoney(m - minus);


    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}

class Park extends Thread {
    public void run() {
        System.out.println("saving money");
        SyncMain.myBank.saveMoney(3000);
        System.out.println("save Money(3000):" + SyncMain.myBank.getMoney() );

    }
}

class Parkwife extends Thread {
    public void run() {
        System.out.println("withdrawing money");
        SyncMain.myBank.withdrawMoney(1000);
        System.out.println("withdraw  Money(1000):" + SyncMain.myBank.getMoney() );
    }
}

public class SyncMain {
    public static Bank myBank = new Bank();

    public static void main(String[] args) {

        Park p = new Park();
        p.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Parkwife pw = new Parkwife();
        pw.start();
    }
}
