package treeSet;

public class Member implements Comparable<Member>{

    private int memberID;
    private String memberName;

    public Member(int memberID, String memberName) {
        this.memberID = memberID;
        this.memberName = memberName;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    @Override
    public String toString() {
        return "The ID of " + memberName + " is " + memberID;
    }


    @Override
    public int compareTo(Member member) {
        return (this.memberID - member.memberID)*(-1); //음수면 내림차순, 양수면 오름차순
    }
}
