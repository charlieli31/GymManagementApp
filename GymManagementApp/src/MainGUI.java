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
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MainGUI frame = new MainGUI();
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
	public MainGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnadmin = new JButton("Admin");
		btnadmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminGUI aGUI = new AdminGUI();
				aGUI.setVisible(true);
			}
		});
		btnadmin.setBounds(165, 49, 117, 29);
		contentPane.add(btnadmin);
		
		btnmember = new JButton("Member");
		btnmember.setBounds(165, 112, 117, 29);
		contentPane.add(btnmember);
		
		btnBusinessAnalyst = new JButton("Business Analyst");
		btnBusinessAnalyst.setBounds(144, 179, 171, 29);
		contentPane.add(btnBusinessAnalyst);
		
		
	}
}
