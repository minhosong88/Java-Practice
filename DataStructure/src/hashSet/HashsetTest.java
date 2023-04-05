package hashSet;

public class HashsetTest {
    public static void main(String[] args) {
        MemberHashSet memberHashSet = new MemberHashSet();
        Member Lee = new Member(1001, "Lee");
        Member Kim = new Member(1002, "Kim");
        Member Kang = new Member( 1003, "Kang");


        memberHashSet.addMember(Lee);
        memberHashSet.addMember(Kim);
        memberHashSet.addMember(Kang);

        memberHashSet.showAll();

        Member Song = new Member(1003, "Song");
        memberHashSet.addMember(Song);
        memberHashSet.showAll();

    }
}
