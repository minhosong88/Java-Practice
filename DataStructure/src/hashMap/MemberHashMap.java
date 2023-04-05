package hashMap;

import java.util.HashMap;
import java.util.Iterator;

public class MemberHashMap {

    private HashMap<Integer, Member> hashMap;

    public MemberHashMap() {
        hashMap = new HashMap<Integer, Member>();
    }

    public void addMember(Member member) {
        hashMap.put(member.getMemberID(), member);
    }

    public boolean removeMember(int memberID) {
        if (hashMap.containsKey(memberID)) {
            hashMap.remove(memberID);
            System.out.println(memberID + "removed");
            System.out.println();

            return true;
        }
        System.out.println("MemberID does not exist");
        System.out.println();
        return false;
    }

    public void showAll() {
        Iterator<Integer> ir = hashMap.keySet().iterator(); //hashMap의 'keyset'을 iterate 한다.
        while (ir.hasNext()) { //iterator에 다음 값이 있으면
            int memberID = ir.next(); //다음 iterator의 값을 임의의 int 값에 매칭한 다음에
            Member member = hashMap.get(memberID);
            // hashmap에서 memberID(key 값)를 검색한 다음에 member에 매칭한다.
            System.out.println(member);
        }
        System.out.println();
    }
}
