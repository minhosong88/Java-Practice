package linkedList;

public class LinkedListTest {

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();


        list.addElement("A");
        list.addElement("B");
        list.addElement("C");
        list.addElement("D");

        list.printAll();
        System.out.println(list.getSize());

        System.out.println(list.getElement(3));
        list.removeElement(2);
        System.out.println(list.getSize());

        list.printAll();
        list.insertElement(2, "See");
        list.printAll();

    }


}
