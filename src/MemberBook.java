import java.util.*;
import java.io.*;


public class MemberBook implements Serializable{
	private ArrayList<Member> memberBook;
	

	public MemberBook() {
//		super();
		this.memberBook = new ArrayList<Member>();
	}

	public ArrayList<Member> getMemberBook() {
		return memberBook;
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
	
	// Method to load contacts from file
    public ArrayList<Member> loadMembersFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("mb.bin"))) {
            return (ArrayList<Member>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
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
