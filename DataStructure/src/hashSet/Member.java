package hashSet;

public class Member {  //Set은 중복되지 않게 자료를 관리할 때 쓴다. //아예 중복을 허용 안함

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
        return "The ID of "+ memberName+ " is "+ memberID+".";
    }

    @Override
    public int hashCode() {
        return memberID;
    }

    @Override
    public boolean equals(Object obj) { //중복여부를 검사하기 위해 동일성 검토를 한다.
        if (obj instanceof Member) {
            Member member = (Member) obj;
            if (this.memberID == member.memberID) {
                return true;
            }
            else return false;
        }
        return false;
    }
}
