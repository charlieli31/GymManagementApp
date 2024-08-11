import java.io.Serializable;

public class Session implements Serializable{
    private static final long serialVersionUID = 1L;
	String date;
	String time;
	
	public Session(String date, String time) {
		this.time = time;
		this.date = date;
	}

	public String toString() {
		return date + "," + time;
	}
}
