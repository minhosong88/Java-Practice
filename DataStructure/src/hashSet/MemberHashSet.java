package hashSet;

import java.util.HashSet;
import java.util.Iterator;

public class MemberHashSet {

    private HashSet<Member> hashSet;

    public MemberHashSet() {
        hashSet = new HashSet<Member>();
    }

    public void addMember(Member member){
        hashSet.add(member);
    }

    public boolean removeMember(int memberID) {
        Iterator<Member> ir = hashSet.iterator();
        while (ir.hasNext()) {
            Member member = ir.next();
            int tempID = member.getMemberID();
            if (tempID == member.getMemberID()) {
                hashSet.remove(member);
                return true;
            }
        }
        System.out.println(memberID + " does not exist.");
        return false;
    }

    public void showAll() {
        for (Member member : hashSet) {
            System.out.println(member);
        }
        System.out.println();
    }
}
