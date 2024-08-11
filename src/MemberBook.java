import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MemberBook implements Serializable {
    private static final long serialVersionUID = 1L;
    private ArrayList<Member> memberBook;

    public MemberBook() {
        this.memberBook = new ArrayList<>();
        // Load members from file on initialization
        try {
        this.memberBook = FileManager.loadMembersFromFile();}
        
        catch(Exception e) {
        	
        }
    }

    public ArrayList<Member> getMemberBook() {
        return memberBook;
    }

    public void setMemberBook(ArrayList<Member> memberBook) {
        this.memberBook = memberBook;
        // Save members to file after setting the book
        FileManager.saveMembersToFile(memberBook);
    }

    public void addMember(Member member) {
        memberBook.add(member);
        FileManager.saveMembersToFile(memberBook);
    }

    public void editMember(Member member, String newName, String newName2, String phone) {
        member.setFname(newName);
        member.setLname(newName2);
        member.setPhone(phone);
        FileManager.saveMembersToFile(memberBook);
    }

    public void deleteMember(Member member) {
        if (memberBook.remove(member)) {
            FileManager.saveMembersToFile(memberBook);
            JOptionPane.showMessageDialog(null, "Member deleted successfully.", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Error deleting member: Member not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
}