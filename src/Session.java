import java.io.Serializable;


public class Session implements Serializable{

    private static final long serialVersionUID = 1L;

	String date;

	String time;

	Trainer trainer;

	

	public Session(String date, String time, Trainer trainer) {

		this.time = time;

		this.date = date;

		this.trainer = trainer;

	}


	public String toString() {

		return date + "," + time;

	}

	

	public Trainer getTrainer() {

		return trainer;

	}

}
