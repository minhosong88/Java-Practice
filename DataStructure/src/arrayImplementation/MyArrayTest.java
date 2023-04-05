package arrayImplementation;

public class MyArrayTest {
    public static void main(String[] args) {
        MyArray myArray = new MyArray();
        myArray.addElement(0);
        myArray.addElement(1);
        myArray.addElement(2);
        myArray.addElement(3);
        myArray.addElement(4);
        myArray.printAll();
        System.out.println("=====================");
        myArray.insertElement(3, 50);
        myArray.printAll();
        System.out.println("=====================");
        System.out.println(myArray.removeElement(1));
        myArray.printAll();
        System.out.println("=====================");
        myArray.addElement(70);
        myArray.printAll();
        System.out.println("=====================");
        myArray.removeElement(1);
        myArray.printAll();
        System.out.println("=====================");

        System.out.println(myArray.getElement(2));
    }
}
