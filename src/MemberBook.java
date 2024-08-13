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
        FileManager.saveMembershipFee(Member.getMembershipFee()); 
    }

    public void editMember(Member member, String username, String password, String newFname, String newLname, String phone) {
    	member.setUsername(username);
    	member.setPassword(password);
        member.setFname(newFname);
        member.setLname(newLname);
        member.setPhone(phone);
        FileManager.saveMembersToFile(memberBook);
    }

    public void deleteMember(Member member, TrainerBook trainerBook) {
    	// Restore sessions back to trainers
        for (Session session : member.getSessions()) {
            Trainer trainer = session.getTrainer();
            trainer.addSession(session);
        }
        
        if (memberBook.remove(member)) {
            FileManager.saveMembersToFile(memberBook);
            FileManager.saveTrainersToFile(trainerBook.getTrainers()); // Save the trainers after restoring sessions
            JOptionPane.showMessageDialog(null, "Member deleted successfully.", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Error deleting member: Member not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

	public boolean isUsernameTaken(String username) {
		for (Member member : memberBook) {
            if (member.getUsername().equals(username)) {
                return true; // Username is already taken
            }
        }
        return false; // Username is available
	}
    
    
}