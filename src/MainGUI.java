import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainGUI extends JFrame {

	private JPanel contentPane;
	private JButton btnadmin;
	private JButton btnmember;
	private JButton btnBusinessAnalyst;
	

//	/**
//	 * Create the frame.
//	 */
	public MainGUI(MemberBook memberBook) {
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
				btn_Admin_clk(memberBook);
			}
		});
		btnadmin.setBounds(165, 49, 117, 29);
		contentPane.add(btnadmin);
		
		// Member
		btnmember = new JButton("Member");
		btnmember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_Member_clk(memberBook);
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
		
		
	}
	
	void btn_Admin_clk(MemberBook memberBook) {
		AdminGUI aGUI = new AdminGUI(memberBook);
		aGUI.setVisible(true);
	}
	
	void btn_Member_clk(MemberBook memberBook) {
//		MemberGUI mGUI = new MemberGUI(memberBook);
//		mGUI.setVisible(true);
	}
	
	void btn_BusinessAnalyst_clk(MemberBook memberBook) {
//		BAGUI baGUI = new BAGUI(memberBook);
//		baGUI.setVisible(true);
	}
}
