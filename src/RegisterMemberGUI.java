import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class RegisterMemberGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtFname;
	private JTextField txtLname;
	private JTextField txtPhone;
	private JLabel lblFname;
	private JLabel lblLname;
	private JLabel lblPhone;
	private JButton btnSave;
	private JButton btnCancel;
	private JLabel lblStatus;
	
	/**
	 * Create the frame.
	 */
	public RegisterMemberGUI(MemberBook memberBook) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtFname = new JTextField();
		txtFname.setBounds(210, 38, 130, 26);
		contentPane.add(txtFname);
		txtFname.setColumns(10);
		
		lblFname = new JLabel("First Name");
		lblFname.setBounds(94, 43, 89, 16);
		contentPane.add(lblFname);
		
		lblLname = new JLabel("Last Name");
		lblLname.setBounds(94, 100, 89, 16);
		contentPane.add(lblLname);
		
		txtLname = new JTextField();
		txtLname.setBounds(210, 95, 130, 26);
		contentPane.add(txtLname);
		txtLname.setColumns(10);
		
		txtPhone = new JTextField();
		txtPhone.setBounds(210, 152, 130, 26);
		contentPane.add(txtPhone);
		txtPhone.setColumns(10);
		
		lblPhone = new JLabel("Phone");
		lblPhone.setBounds(94, 157, 89, 16);
		contentPane.add(lblPhone);
		
		// Status label for displaying messages
        lblStatus = new JLabel(""); 
        lblStatus.setBounds(94, 185, 246, 16); 
        contentPane.add(lblStatus);  
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_save_clk(memberBook);
			}
		});
		btnSave.setBounds(76, 211, 117, 29);
		contentPane.add(btnSave);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Close the current window
                dispose();
            }
        });
		btnCancel.setBounds(256, 211, 117, 29);
		contentPane.add(btnCancel);
	}
	
	void btn_save_clk(MemberBook memberBook) {
		Member newMember = new Member(txtFname.getText(), txtLname.getText(), txtPhone.getText());
		memberBook.addMember(newMember);
		lblStatus.setText("Saved successfully!");
        JOptionPane.showMessageDialog(RegisterMemberGUI.this, "Member saved successfully.");
	}
}
