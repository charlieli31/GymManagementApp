//pull this line over here
public class main {
	public static void main(String[] args) {
		MemberBook memberBook = new MemberBook();
		TrainerBook trainerBook = new TrainerBook();
		MainGUI mGUI = new MainGUI(memberBook, trainerBook);
		mGUI.setVisible(true);
	
	}

}
