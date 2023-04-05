package hashMap;

public class Member { // HashMap은 중복key는 허용X, 중복 value는 가능. key가 중복되면 new key의 value 로 replace.

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
        return "The memberID of " + memberName+ " is " + memberID;
    }

    @Override
    public int hashCode() {
        return memberID;
    }

    /*@Override //굳이 equals로 정의할 필요가 없는 듯.
    public boolean equals(Object obj) {
        if (obj instanceof Member) { //argument의 변수가 Member에도 있는 변수인지 확인한다.
            Member member = (Member) obj; // obj 를 member 값에다 매칭.
        // obj는 Object타입이므로 Member 클래스의 메서드를 사용 못하기 때문에 Member타입의 member에 대입해서 사용.
            if (this.memberID == member.getMemberID()) {
                return true;
            }
            else return false;
        }
        return false;
    }*/
}
