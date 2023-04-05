package linkedList;

public class MyListNode {

    private String data;
    public MyListNode next; //이 변수가 ListNode 타입인 이유는 next가 Node 순서 결정에 사용될 변수이기 때문.
    //MyListNode 와 MyListNode.next 에 각각 값을 부여함으로써 순서를 구현한다.
    //LinkedList는 결국 Array 안에 데이터를 순차적으로 넣는 것이 아니라, 노드라는 개별 값에 데이터를 연동해서
    //각 노드들 사이에 미리 정해진 순서(관계)를 통해 데이터 관리를 구현하는 것. 누구 앞에 누구, 누구 뒤에 누구 등.

    public MyListNode() { //리스트 노드를 처음 생성하면 비어있다.
        this.data = null;
        this.next = null;
    }

    public MyListNode(String data) {
        this.data = data;
        this.next = null;
        //하나는 String data, 다른 하나는 MyListNode 타입의 임의의 노드 node.next = data 를 통해서 입력.
    }

    public MyListNode(String data, MyListNode link) {
        this.data = data;
        this.next = link;
        //이 형식의 생성자를 통해 생성하는 경우 data 2개 생성.

    }

    public String getData() {
        return data;
    }
}
