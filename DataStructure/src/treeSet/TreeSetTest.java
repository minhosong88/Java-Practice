package treeSet;

import java.util.Comparator;

class MyCompare implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        return s1.compareTo(s2);
    } // (-) if s1 > s2 // (0) if s1 = s2 // (+) if s1 < s2
}
public class TreeSetTest {
    public static void main(String[] args) {

        MemberTreeSet treeSet = new MemberTreeSet();
        Member Lee = new Member(1001, "Lee");
        Member Kim = new Member(1002, "Kim");
        Member Park = new Member(1003, "Park");

        treeSet.addMember(Lee);
        treeSet.addMember(Kim);
        treeSet.addMember(Park);

        treeSet.showAll();


    }
}
