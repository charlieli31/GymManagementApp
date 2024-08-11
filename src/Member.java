import java.io.Serializable;

public class Member extends User implements Serializable{
    private static final long serialVersionUID = 1L;

	
	private String phone;

	// Constructor
	
	// No-argument constructor
    public Member() {
        super();
    }
    
	public Member(String fname, String lname) {
		super(fname, lname);
	}

	public Member(String fname, String lname, String phone) {
		super(fname, lname);
		this.phone = phone;
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

}
