package arrayListPractice;

public class MemberArrayListTest {
    public static void main(String[] args) {
        MemberArrayList memberArrayList = new MemberArrayList();

        Member memberLee = new Member(1000, "Lee");
        Member memberKim = new Member(1001, "Kim");
        Member memberPark = new Member(1002, "Park");
        Member memberSong = new Member(1003, "Song");

        memberArrayList.addMember(memberLee);
        memberArrayList.addMember(memberKim);
        memberArrayList.addMember(memberPark);
        memberArrayList.addMember(memberSong);

        memberArrayList.showAllMembers();

        memberArrayList.removeMember(1003);
        memberArrayList.showAllMembers();

    }

}
