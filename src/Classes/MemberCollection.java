package Classes;

public class MemberCollection {
    public static MemberCollection memberInstance = new MemberCollection();
    public Member[] memberList = new Member[10];
    public int memberCounter = 0;

    public void addMember(Member member) {
        if (memberCounter != memberList.length) {
            this.memberList[memberCounter] = member;
            memberCounter++;
        }
    }
    public void printMemberDetails(Member member) {
        System.out.println("========= Printing member details =========\n");
        System.out.printf("Name: " + member.getFirstName() + " " + member.getLastName()
        + ", Residential address: " + member.getResidentialAddress() + ", Contact number: "
        + "%010d" + "\n", member.getContactNumber());
    }
    public void printAllMembers() {
        for (Member m : memberList) {
            if (m != null) {
                System.out.println("Name: " + m.getFirstName() + " " + m.getLastName()
                        + ", Residential address: " + m.getResidentialAddress() + ", Contact number: "
                        + m.getContactNumber() + ", Username: " + m.getUserName() + ", Password: " +
                        m.getPassword() + "\n");
            }
        }
    }
    public void findMember(String fullName) {
        for (Member m : memberList) {
            if (m.getFullName().equalsIgnoreCase(fullName)) {
                System.out.println("Member: " + m.getFullName()
                + ", Contact number: " + m.getContactNumber());
                break;
            }
        }
    }

}
