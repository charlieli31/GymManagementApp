import java.util.*;
import java.io.*;
import javax.swing.JOptionPane;

public class MemberBook implements Serializable{
    private static final long serialVersionUID = 1L;

	
	private ArrayList<Member> memberBook;
	

	public MemberBook() {
//		super();
		this.memberBook = new ArrayList<Member>();
	}
	
	public ArrayList<Member> getMemberBook() {
		return memberBook;
	}

	// de-serialize to get MemberBook
	public ArrayList<Member> getSerializaedMemberBook() {
		return loadMembersFromFile();
	}

	public void setMemberBook(ArrayList<Member> memberBook) {
		this.memberBook = memberBook;
	}
	
	// adding a member
	public void addMember(Member member){
		memberBook.add(member);
		// Save contacts to file
        saveMembersToFile();
	}
	
	public void deleteMember(Member member) {
		//int i = 0;
		//while (i<memberBook.length()) {	
		//}
		if (memberBook.remove(member)) {
			System.out.println("reached here");
			saveMembersToFile(); 
			JOptionPane.showMessageDialog(null, "Member deleted successfully.", "Information", JOptionPane.INFORMATION_MESSAGE);
			} 
		else { JOptionPane.showMessageDialog(null, "Error deleting member: Member not found.", "Error", JOptionPane.ERROR_MESSAGE); }
		}
		
		//memberBook.remove(member);
		//saveMembersToFile();
	
	
	// Method to load contacts from file
    public ArrayList<Member> loadMembersFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("mb.bin"))) {
            memberBook = (ArrayList<Member>) ois.readObject();
            if (memberBook.isEmpty()) {
                JOptionPane.showMessageDialog(null, "The member list is empty.", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error loading members from file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return memberBook;
    }

    // Method to save contacts to file
    public void saveMembersToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("mb.bin"))) {
            oos.writeObject(memberBook);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
