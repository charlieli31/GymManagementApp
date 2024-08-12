import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;

public class RegisterMemberGUI extends JFrame {

    private JPanel contentPane;
    private JTextField txtFname;
    private JTextField txtLname;
    private JTextField txtPhone;
    private JTextField txtUsername;
    private JTextField txtPassword;
    private JButton btnSave;
    private JButton btnCancel;
    private MemberBook memberBook;
    private JLabel lblFname;
    private JLabel lblLname;
    private JLabel lblPhone;
    private JLabel lblUsername;
    private JLabel lblPassword;

    public RegisterMemberGUI(MemberBook memberBook) {
        this.memberBook = memberBook;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        txtFname = new JTextField();
        txtFname.setBounds(227, 97, 130, 26);
        contentPane.add(txtFname);
        txtFname.setColumns(10);

        txtLname = new JTextField();
        txtLname.setBounds(227, 130, 130, 26);
        contentPane.add(txtLname);
        txtLname.setColumns(10);

        txtPhone = new JTextField();
        txtPhone.setBounds(227, 163, 130, 26);
        contentPane.add(txtPhone);
        txtPhone.setColumns(10);

        lblFname = new JLabel("First Name");
        lblFname.setBounds(90, 102, 82, 16);
        contentPane.add(lblFname);

        lblLname = new JLabel("Last Name");
        lblLname.setBounds(90, 135, 76, 16);
        contentPane.add(lblLname);

        lblPhone = new JLabel("Phone");
        lblPhone.setBounds(90, 168, 82, 16);
        contentPane.add(lblPhone);

        btnSave = new JButton("Save");
        btnSave.setBounds(80, 220, 117, 29);
        contentPane.add(btnSave);

        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_save_clk();
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
        
        txtUsername = new JTextField();
        txtUsername.setBounds(227, 21, 130, 26);
        contentPane.add(txtUsername);
        txtUsername.setColumns(10);
        
        txtPassword = new JTextField();
        txtPassword.setBounds(227, 58, 130, 26);
        contentPane.add(txtPassword);
        txtPassword.setColumns(10);
        
        lblUsername = new JLabel("Username");
        lblUsername.setBounds(90, 26, 82, 16);
        contentPane.add(lblUsername);
        
        lblPassword = new JLabel("Password");
        lblPassword.setBounds(90, 63, 82, 16);
        contentPane.add(lblPassword);
    }

    void btn_save_clk() {
    	String username = txtUsername.getText();
    	String password = txtPassword.getText();
        String fname = txtFname.getText();
        String lname = txtLname.getText();
        String phone = txtPhone.getText();
        if (!fname.isEmpty() && !lname.isEmpty() && !phone.isEmpty() && !username.isEmpty() && !password.isEmpty()) {
            Member newMember = new Member(fname, lname, phone, username, password);
            memberBook.addMember(newMember);
            JOptionPane.showMessageDialog(RegisterMemberGUI.this, "Member added successfully.");
            dispose();
        } else {
            JOptionPane.showMessageDialog(RegisterMemberGUI.this, "Please fill in all fields.");
        }
    }
}