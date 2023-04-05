package arrayListPractice;

import java.util.ArrayList;

public class MemberArrayList {

    private ArrayList<Member> arrayList;

    public MemberArrayList() {
        arrayList = new ArrayList<Member>();
    }

    public void addMember(Member member) {
        arrayList.add(member);
    }

    public boolean removeMember(int memberID) {
        for (int i = 0; i < arrayList.size(); i++) {
            Member member = arrayList.get(i);
            int tempID = member.getMemberID();
            if (tempID == memberID) {
                arrayList.remove(i);
                return true;
            }

        }
        System.out.println("Given ID does not exist.");
        return false;
    }

    //public boolean removeMember(int memberID){ //Implementing removeMember method with Iterator.
    // Iterator<Member> ir = arrayList.iterator(); // arrayList 안에 있는 Member 타입의 변수 순회
    // while(ir.hasNext()){
    //      Member member = ir.next();
    //      int tempID = member.getMemberID;
    //          if(tempID == member.getMemberID){
    //               ir.remove();
    //               return true;
    //          }
    //      }
    // }



    public void showAllMembers() {
        for (Member member : arrayList) {
            System.out.println(member);
        }
        System.out.println();
    }


}
