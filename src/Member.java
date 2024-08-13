import java.io.Serializable;
import java.util.ArrayList;

public class Member extends User implements Serializable{
    private static final long serialVersionUID = 1L;
    private static int membershipFee = 0;

	
	private String phone;
	private ArrayList<Session> sessions;
	private String username;
	private String password;
	private int sessionFee = 0;

	// initialize the membershipFee to solve return to 0 problem
	static {
        membershipFee = FileManager.loadMembershipFee(); // Load the membership fee at startup
    }

    // Constructors
    public Member() {
        super();
        sessions = new ArrayList<>();
        membershipFee += 25;
        FileManager.saveMembershipFee(membershipFee); // Save the fee after adding a new member
    }

    public Member(String fname, String lname) {
        super(fname, lname);
        sessions = new ArrayList<>();
        membershipFee += 25;
        FileManager.saveMembershipFee(membershipFee);
    }

    public Member(String fname, String lname, String phone) {
        super(fname, lname);
        this.phone = phone;
        sessions = new ArrayList<>();
        membershipFee += 25;
        FileManager.saveMembershipFee(membershipFee);
    }

    public Member(String fname, String lname, String phone, String username, String password) {
        super(fname, lname);
        this.phone = phone;
        this.sessions = new ArrayList<>();
        this.username = username;
        this.password = password;
        membershipFee += 25;
        FileManager.saveMembershipFee(membershipFee);
    }
	// Getters and Setters
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    public ArrayList<Session> getSessions() {
    	return sessions;
    }
    
    public static int getMembershipFee() {
    	return membershipFee;
    }

	public int getSessionFee() {
		return sessionFee;
	}

	public void setSessionFee(int sessionFee) {
		this.sessionFee = sessionFee;
	}
	
	// increment session fee by $50
	public void incrementSessionFee() {
		this.sessionFee += 50;
	}
	
	// Override toString to display member information
    @Override
    public String toString() {
        return getFname() + " " + getLname() + " (" + phone + ")";
    }
    

}
