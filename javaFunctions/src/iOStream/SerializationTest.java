package iOStream;

import java.io.*;

class Person implements Serializable{

    String name;
    String job; // transient를 Socket 같은 serialize가 불가능한 객체 앞에 사용하면 그 객체는 무시하고 직렬화함.

    public Person(){}
    public Person(String name, String job) {
        this.name = name;
        this.job = job;
    }

    @Override
    public String toString() {
        return name + ", "+ job;
    }
}

public class SerializationTest {
    public static void main(String[] args) {

        Person lee = new Person("Lee", "CEO");
        Person kim = new Person("Kim", "CFO");

        try (FileOutputStream fos = new FileOutputStream("serial.txt");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(lee);
                oos.writeObject(kim);
        } catch (IOException e) {
            System.out.println(e);
        }

        try (FileInputStream fis = new FileInputStream("serial.txt");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            Person plee = (Person) ois.readObject();
            Person pkim = (Person) ois.readObject();
            System.out.println(plee);
            System.out.println(pkim);
        } catch (IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);

        }
    }
}

