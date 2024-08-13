import java.io.Serializable;


import java.util.ArrayList;



public class TrainerBook implements Serializable{

	private ArrayList<Trainer> trainers;

	// default constructor loading data
	public TrainerBook() {
			try {
		       this.trainers = FileManager.loadTrainersFromFile();}
	        catch(Exception e) {
	        	this.trainers = new ArrayList<Trainer>();
	        	// initialize
	        	initializeTrainers();
	        }
	}

	// initialization process with hand coded trainers and sessions
	private void initializeTrainers() {
		Trainer trainer1 = new Trainer("Alex Manko");
		Trainer trainer2 = new Trainer("Eli Sun");
		Trainer trainer3 = new Trainer("Charlie Li");
		Trainer trainer4 = new Trainer("LeBron James");
		Trainer trainer5 = new Trainer("Kevin Durant");

		for (int i = 1; i <= 5; i++) {
			trainer1.addSession(new Session("2024-08-" + i, "10:00 AM", trainer1));
			trainer2.addSession(new Session("2024-08-" + i, "11:00 AM", trainer2));
	        trainer3.addSession(new Session("2024-08-" + i, "12:00 PM", trainer3));
	        trainer4.addSession(new Session("2024-08-" + i, "01:00 PM", trainer4));
	        trainer5.addSession(new Session("2024-08-" + i, "02:00 PM", trainer5));
	    }
		 
		trainers.add(trainer1);
		trainers.add(trainer2);
		trainers.add(trainer3);
		trainers.add(trainer4);
        trainers.add(trainer5);
	}

	ArrayList<Trainer> getTrainers(){
		return trainers;
	}

}
