package hashMap;

public class HashMapTest {
    public static void main(String[] args) {
        MemberHashMap hashMap = new MemberHashMap();

        Member Lee = new Member(1001, "Lee");
        Member Kim = new Member(1002, "Kim");
        Member Kang = new Member(1003, "Kang");
        Member Park = new Member(1004, "Park");

        hashMap.addMember(Lee);
        hashMap.addMember(Kim);
        hashMap.addMember(Kang);
        hashMap.addMember(Park);

        hashMap.showAll();
        Member Kimo = new Member(1002, "Kimo");
        //
        hashMap.addMember(Kimo);
        hashMap.showAll();
        hashMap.removeMember(1003);
        hashMap.showAll();
    }
}
