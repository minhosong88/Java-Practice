package thread;

import exceptionHandling.ThrowsException;

import java.util.ArrayList;

class FastLibrary {
    public ArrayList<String> shelf = new ArrayList<>();

    public FastLibrary() { //객체 생성하면 함께 생성되는 책들.
        shelf.add("Art");
        shelf.add("Science");
        shelf.add("Technology");
        shelf.add("Economics");

    }

    public synchronized String lendBook() throws InterruptedException {
        Thread t = Thread.currentThread();
        while (shelf.size() == 0) { //다 빌려가서 배열에 항목이 없는 경우 기다렷다가 빌리는 것.
            System.out.println(t.getName()+" waiting starts");
            wait(); //여러 Thread 중에서 이 메서드를 수행하고 있는 Thread를 non-runnable 상태로 만드는 것.
            System.out.println(t.getName() + " waiting ends");
        }
        if (shelf.size() > 0) {
            String book = shelf.remove(0);
            System.out.println(t.getName()+": "+ book + " lent");

            return book;
        }else return null;

    }

    public synchronized void returnBook(String book) {
        Thread t = Thread.currentThread();
        shelf.add(book);
        //notify();
        notifyAll(); // 책이 없는 경우 Thread들이 wait() 상태에 빠져 있는데
                                    // 책이 반납되면 notify가 Thread를 깨워서 동작시킨다.
        //notifyAll()이 권장된다.
        System.out.println(t.getName() + ": " + book + " returned");
    }

}

class Student extends Thread {
    public void run() {
        try {
            String title = LibraryMain.library.lendBook(); //책을 빌렸다가
            if (title == null) {
                System.out.println(getName()+" failed to lend a book");
                return;
            }
            sleep(5000);        // 5초 쉬다가
            LibraryMain.library.returnBook(title); // 책을 반납하는 Thread.
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

}
public class LibraryMain {
    public static FastLibrary library = new FastLibrary();
    public static void main(String[] args) {
        Student Lee = new Student();
        Student Kim = new Student();
        Student Park = new Student();
        Student Song = new Student();
        Student Lim = new Student();
        Student Son = new Student();
        Student Han = new Student();

        Lee.start();
        Kim.start();
        Park.start();
        Song.start();
        Lim.start();
        Son.start();
        Han.start();

    }
}
