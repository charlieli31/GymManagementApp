import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class MemberGUI extends JFrame {

	private JPanel contentPane;

	private JButton btnViewTrainers;
	private JButton btnViewSessions;
	private Member activeMember;
	private TrainerBook trainerBook;
	private MemberBook memberBook;
	private JButton btnBack;

	/**
	 * Create the frame.
	 */
	public MemberGUI(MemberBook memberBook, Member activeMember, TrainerBook trainerBook) {
		this.activeMember = activeMember;
		this.trainerBook = trainerBook;
		this.memberBook = memberBook;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnViewTrainers = new JButton("View Trainers");
		btnViewTrainers.setBounds(161, 60, 128, 29);
		contentPane.add(btnViewTrainers);
		
		btnViewSessions = new JButton("View Registered Sessions");
		btnViewSessions.setBounds(135, 123, 200, 30);
		contentPane.add(btnViewSessions);

		btnBack = new JButton("Log Out");
		btnBack.setBounds(131, 194, 193, 29);
		contentPane.add(btnBack);
		
		// Browse Trainers event
		btnViewTrainers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_viewTrainers_clk();
			}
		});
		
		// View Registered Session event
		btnViewSessions.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				btn_viewSessions_clk();
			}
		});
		
		// Back event
		btnBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
	
	// click Browse Trainers
	private void btn_viewTrainers_clk() {
		BrowseTrainersGUI btGUI = new BrowseTrainersGUI(memberBook, activeMember, trainerBook);
		btGUI.setVisible(true);
	}
	
	// click View Registered Sessions
	private void btn_viewSessions_clk() {
		ViewRegisteredSessionsGUI vrgGUI = new ViewRegisteredSessionsGUI(memberBook, activeMember, trainerBook);
		vrgGUI.setVisible(true);
	}
	
}
