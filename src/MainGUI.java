import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class MainGUI extends JFrame {

	private JPanel contentPane;
	private JButton btnadmin;
	private JButton btnmember;
	private JButton btnBusinessAnalyst;
	private JLabel lbltitle;
	private TrainerBook trainerBook;
	

//	/**
//	 * Create the frame.
//	 */
	public MainGUI(MemberBook memberBook, TrainerBook trainerBook) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Admin
		btnadmin = new JButton("Admin");
		btnadmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// modified to pass trainerBook
				btn_Admin_clk(memberBook, trainerBook);
			}
		});
		btnadmin.setBounds(165, 49, 117, 29);
		contentPane.add(btnadmin);
		
		// Member
		btnmember = new JButton("Member");
		btnmember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_Member_clk(memberBook, trainerBook);
			}
		});
		btnmember.setBounds(165, 112, 117, 29);
		contentPane.add(btnmember);
		
		// BA
		btnBusinessAnalyst = new JButton("Business Analyst");
		btnBusinessAnalyst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_BusinessAnalyst_clk(memberBook);
			}
		});
		btnBusinessAnalyst.setBounds(144, 179, 171, 29);
		contentPane.add(btnBusinessAnalyst);
		
		lbltitle = new JLabel("Welcome to our Gym!");
		lbltitle.setBounds(154, 6, 148, 31);
		contentPane.add(lbltitle);
		
	
		
		
	}

	// click Admin
	private void btn_Admin_clk(MemberBook memberBook, TrainerBook trainerBook) {
		AdminGUI aGUI = new AdminGUI(memberBook, trainerBook);
		aGUI.setVisible(true);
	}
	
	// click Member
	private void btn_Member_clk(MemberBook memberBook, TrainerBook trainerBook) {
		LoginGUI lGUI = new LoginGUI(memberBook, trainerBook);
		lGUI.setVisible(true);
	}
	
	// click BA
	private void btn_BusinessAnalyst_clk(MemberBook memberBook) {
		BusinessAnalystGUI baGUI = new BusinessAnalystGUI(memberBook);
		baGUI.setVisible(true);
	}
}
