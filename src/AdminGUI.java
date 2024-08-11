import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class AdminGUI extends JFrame {

	private JPanel contentPane;
	private JButton btnRegister;
	private JButton btnViewMember;
	private JButton btnBack;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AdminGUI frame = new AdminGUI();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 */
	public AdminGUI(MemberBook memberBook) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnRegister = new JButton("Register New Member");
		btnRegister.setBounds(120, 49, 198, 29);
		contentPane.add(btnRegister);
		
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterMemberGUI rmGUI = new RegisterMemberGUI(memberBook);
				rmGUI.setVisible(true);
			}
		});
		
		btnViewMember = new JButton("View Member Profiles");
		
		btnViewMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewMembersGUI vmGUI = new ViewMembersGUI(memberBook);
				vmGUI.setVisible(true);
			}
		});
		btnViewMember.setBounds(120, 120, 198, 29);
		contentPane.add(btnViewMember);
		
		btnBack = new JButton("Go Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Close the current window
                dispose();
			}
		});
		btnBack.setBounds(161, 188, 117, 29);
		contentPane.add(btnBack);
	}
}
