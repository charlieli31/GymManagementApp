import java.io.Serializable;
import java.util.ArrayList;

public class Member extends User implements Serializable{
    private static final long serialVersionUID = 1L;

	
	private String phone;
	private ArrayList<Session> sessions;

	// Constructor
	
	// No-argument constructor
    public Member() {
        super();
        sessions = new ArrayList<Session>();
    }
    
	public Member(String fname, String lname) {
		super(fname, lname);
		sessions = new ArrayList<Session>();
	}

	public Member(String fname, String lname, String phone) {
		super(fname, lname);
		this.phone = phone;
		sessions = new ArrayList<Session>();
	}
	
	// Getters and Setters
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	// Override toString to display member information
    @Override
    public String toString() {
        return getFname() + " " + getLname() + " (" + phone + ")";
    }
    
    public ArrayList<Session> getSessions() {
    	return sessions;
    }

}
