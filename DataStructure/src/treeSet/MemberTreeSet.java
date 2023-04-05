package treeSet;

import java.util.Iterator;
import java.util.TreeSet;

public class MemberTreeSet {

    private TreeSet<Member> treeSet;

    public MemberTreeSet() {
        treeSet = new TreeSet<Member>();
    }

    public void addMember(Member member) {
        treeSet.add(member);
    }

    public boolean removeMember(int memberID) {
        Iterator<Member> ir = treeSet.iterator();
        while (ir.hasNext()) {
            Member member = ir.next();
            int tempID = member.getMemberID();
            while (tempID == memberID) {
                treeSet.remove(member);
                return true;
            }
        }
        System.out.println("Customer ID does not exist.");
        return false;
        }

    public void showAll() {
        for (Member member : treeSet) {
            System.out.println(member);
        }
    }

}
