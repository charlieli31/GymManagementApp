import java.io.Serializable;

public class User implements Serializable{
    private static final long serialVersionUID = 1L;

	
	private String fname;
	private String lname;
	
	//  Constructor 
    public User() {
        // Default constructor
    }
    
	public User(String fname, String lname) {
		super();
		this.fname = fname;
		this.lname = lname;
	}
	
	// Getters and Setters
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	

}
