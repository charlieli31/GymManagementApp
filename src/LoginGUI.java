import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class LoginGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JButton btnLogin;
	private JButton btnCancel;
	private MemberBook memberBook;
	private TrainerBook trainerBook;


	/**
	 * Create the frame.
	 */
	public LoginGUI(MemberBook memberBook, TrainerBook trainerBook) {
		
		this.memberBook = memberBook;
		this.trainerBook = trainerBook;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblUsername = new JLabel("Username");
		lblUsername.setBounds(103, 67, 92, 16);
		contentPane.add(lblUsername);
		
		lblPassword = new JLabel("Password");
		lblPassword.setBounds(103, 130, 92, 16);
		contentPane.add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(207, 62, 130, 26);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(207, 125, 130, 26);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_login_clk();
            }
        });
		btnLogin.setBounds(87, 191, 117, 29);
		contentPane.add(btnLogin);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
		btnCancel.setBounds(232, 191, 117, 29);
		contentPane.add(btnCancel);
	}

	private void btn_login_clk() {
	    String username = txtUsername.getText();
	    String password = txtPassword.getText();
	    
	    if (!username.isEmpty() && !password.isEmpty()) {
	        boolean found = false;  
	        boolean valid = false;
	        for (Member member : memberBook.getMemberBook()) {
	            if (member.getUsername().equals(username)) {
	                found = true;  // User is found
	                if (member.getPassword().equals(password)) {
	                    MemberGUI mGUI = new MemberGUI(memberBook, member, trainerBook);
	                    JOptionPane.showMessageDialog(LoginGUI.this, "Login Successfully.");
	                    mGUI.setVisible(true);
	                    valid = true;  // Valid password
	                    break; 
	                } else {
	                    // User found but invalid password
	                    JOptionPane.showMessageDialog(LoginGUI.this, "Password is invalid.");
	                    break;  
	                }
	            }
	        }
	        
	        // Check if the member was not found
	        if (!found) {
	            JOptionPane.showMessageDialog(LoginGUI.this, "Member cannot be found.");
	        }
	    } else {
	        JOptionPane.showMessageDialog(LoginGUI.this, "Please input your username and password.");
	    }
	    
	    refreshPage();
	}

	// refresh the page
	private void refreshPage() {
        txtUsername.setText("");
        txtPassword.setText("");
    }
}
