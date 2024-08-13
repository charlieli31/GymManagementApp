import java.io.Serializable;
import java.util.ArrayList;

public class Trainer implements Serializable {
	private String name;
	private ArrayList<Session> sessions;
	
	// constructor
	public Trainer(String name) {
		this.name = name;
		sessions = new ArrayList<Session>();
	}
	
	
	void addSession(Session newSession) {
		sessions.add(newSession);
	}
	
	
	public String toString() {
		return name;
	}
	
	ArrayList<Session> getSessions(){
		return sessions;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
