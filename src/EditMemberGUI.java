import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditMemberGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtFname;
	private JTextField txtLname;
	private JTextField txtPhone;
	private JLabel lblFname;
	private JLabel lblLname;
	private JLabel lblPhone;
	private JButton btnSave;
	private JButton btnCancel;
	private Member selectedMember;

	/**
	 * Create the frame.
	 */
	public EditMemberGUI(MemberBook memberBook, Member selectedMember) {
		this.selectedMember = selectedMember;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtFname = new JTextField();
		txtFname.setBounds(159, 45, 130, 26);
		contentPane.add(txtFname);
		txtFname.setColumns(10);
		
		txtFname.setText(selectedMember.getFname());//t
		
		txtLname = new JTextField();
		txtLname.setBounds(159, 104, 130, 26);
		contentPane.add(txtLname);
		txtLname.setColumns(10);
		
		txtLname.setText(selectedMember.getLname());
		
		txtPhone = new JTextField();
		txtPhone.setBounds(159, 168, 130, 26);
		contentPane.add(txtPhone);
		txtPhone.setColumns(10);
		
		txtPhone.setText(selectedMember.getPhone());
		
		lblFname = new JLabel("First Name");
		lblFname.setBounds(69, 50, 82, 16);
		contentPane.add(lblFname);
		
		lblLname = new JLabel("Last Name");
		lblLname.setBounds(69, 109, 76, 16);
		contentPane.add(lblLname);
		
		lblPhone = new JLabel("Phone");
		lblPhone.setBounds(69, 173, 61, 16);
		contentPane.add(lblPhone);
		
		btnSave = new JButton("Save");
		btnSave.setBounds(80, 220, 117, 29);
		contentPane.add(btnSave);
		
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_save_clk(memberBook);
			}
		});
		
		
		
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(240, 220, 117, 29);
		contentPane.add(btnCancel);
	}
	
	
	
	void btn_save_clk(MemberBook memberBook) {
			selectedMember.setFname(txtFname.getText());
			selectedMember.setLname(txtLname.getText());
			selectedMember.setPhone(txtPhone.getText());
			
			memberBook.saveMembersToFile();
			
			
			
            JOptionPane.showMessageDialog(EditMemberGUI.this, "Member edited successfully.");

	}
	
	
}
