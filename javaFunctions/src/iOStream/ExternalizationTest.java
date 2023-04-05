package iOStream;

import java.io.*;

class Persons implements Externalizable {

    String name;
    String job;

    public Persons(){}
    public Persons(String name, String job) {
        this.name = name;
        this.job = job;
    }

    @Override
    public String toString() {
        return name+", "+job;
    }
    @Override
    public void writeExternal(ObjectOutput obj) throws IOException {
        obj.writeUTF(name);
        obj.writeUTF(job);
    }

    @Override
    public void readExternal(ObjectInput obj) throws IOException, ClassNotFoundException {
            name = obj.readUTF();
            job = obj.readUTF();
    }
}


public class ExternalizationTest {
    public static void main(String[] args) {


    Persons lee = new Persons("lee", "CEO");
    Persons kim = new Persons("kim", "CFO");

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("serial.txt"))) {
            oos.writeObject(lee);
            oos.writeObject(kim);

        } catch (IOException e) {
            System.out.println(e);
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("serial.txt"))) {
            Persons plee = (Persons) ois.readObject();
            Persons pkim = (Persons) ois.readObject();
            System.out.println(plee);
            System.out.println(pkim);

        } catch (IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

}
