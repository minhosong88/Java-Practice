package linkedList;

public class MyLinkedList {

    private MyListNode head;
    int count;

    public MyLinkedList() { //생성자 생성하면 기본 값이 설정된다.
        this.head = null; //나중에 요소 추가할 때 MyListNode 생성해서 추가해야함.
        this.count = 0;
    }

    public MyListNode addElement(String data) {
        MyListNode newNode;
        if (head == null) {
            newNode = new MyListNode(data);
            head = newNode; // 새 노드를 생성해서 head 자리에 넣어준다. newNode (head(data), null)
        } else{
            newNode = new MyListNode(data);
            MyListNode temp = head; //이런식으로 사용할 때는 head 값의 직접 변경없이 head 값을 이용할 때이다.
            while (temp.next != null) { //temp.next라는 변수가 null이 아닐 때까지
                temp = temp.next; //temp는 잠시 값을 저장하는 저장소.
            } //while 문을 빠져나왔다는 것은 temp.next = null 이라는 뜻.
            temp.next = newNode;
        }
        count++;
        return newNode;//newNode는 (newNode(data), null)로 구성됨.
    } //newNode2 추가 시, newNode(data, newNode2(data)) newNode2(newNode2(data), null) 방식으로 연결.

    public MyListNode insertElement(int position, String data) {
        int i;
        MyListNode tempNode = head;
        MyListNode newNode = new MyListNode(data); //초기 생성되는 newNode 는 (data, null)
        if (position < 0 || position > count) {
            System.out.println("Error in the insertion location");
            return null;
        }
        if (position == 0) {
            newNode.next = head; //원래  head 값은 다음 값에
            head = newNode; // 새 값은 head에 대입한다.
        } else {
            MyListNode preNode = null;
            for(i=0; i < position; i++){
                preNode = tempNode;
                tempNode = tempNode.next;
            }
            newNode.next = preNode.next; //
            preNode.next = newNode;
        }
        count++;
        return newNode; //여기서 반환되는 newNode 는 (data, data.next)가 채워져있다.
    }

    public MyListNode removeElement(int position){
        int i;
        MyListNode tempNode = head;
        if (position < 0 || position > count) {
            System.out.println("Error in the removing location.");
            return null;
        }
        if (position == 0) {
            head = tempNode.next;
        } else{
            MyListNode preNode = null;
            for (i = 0; i < position; i++) {
                preNode = tempNode;
                tempNode = tempNode.next;
            }
            preNode.next = tempNode.next; //tempNode 건너뛰고 연결한다.
        }
        count--;
        return tempNode;
    }

    public String getElement(int position) {
        int i;
        MyListNode tempNode = head;
        if (position < 0 || position > count) {
            System.out.println("error in location data");
            return null;
        }
        if (position == 0) {
            return head.getData();
        } else{
            for (i = 0; i < position; i++) {
                tempNode = tempNode.next;
            }
            return tempNode.getData();
        }
    }

    public void printAll() {
        if (count == 0) {
            System.out.println("no data to print");
            return;
        }
        MyListNode tempNode = head;
        while (tempNode != null) {
            System.out.print(tempNode.getData());
            tempNode = tempNode.next;
            if (tempNode != null) {
                System.out.print("->");
            }
        }
        System.out.println(" ");
    }

    public int getSize() {
        return count;
    }

}
