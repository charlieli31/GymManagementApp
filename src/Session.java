import java.io.Serializable;


public class Session implements Serializable{

    private static final long serialVersionUID = 1L;
	private String date;
	private String time;
	private Trainer trainer;

	

	public Session(String date, String time, Trainer trainer) {
		this.time = time;
		this.date = date;
		this.trainer = trainer;
	}


	public String toString() {
		return trainer.getName() + ": " + date + ", " + time;
	}

	

	public Trainer getTrainer() {
		return trainer;
	}
	
	public String getTime() {
		return time;
	}
	
	public String getDate() {
		return date;
	}

}
