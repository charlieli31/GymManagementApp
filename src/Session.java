
public class Session {
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
