import java.io.Serializable;

public class Member extends User implements Serializable{
	private String phone;

	// Constructor
	public Member(String fname, String lname) {
		super(fname, lname);
		// TODO Auto-generated constructor stub
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
	

}
