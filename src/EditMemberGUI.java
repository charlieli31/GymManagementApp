import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;

public class EditMemberGUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtFname;
    private JTextField txtLname;
    private JTextField txtPhone;
    private JTextField txtUsername;
    private JTextField txtPassword;
    private JButton btnSave;
    private JButton btnCancel;
    private Member selectedMember;
    private JLabel lblPassword;
    private JLabel lblUsername;
    private JLabel lblFname;
    private JLabel lblLname;
    private JLabel lblPhone;

    public EditMemberGUI(MemberBook memberBook, Member selectedMember) {
        this.selectedMember = selectedMember;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        txtUsername = new JTextField();
        txtUsername.setBounds(227, 56, 130, 26);
        contentPane.add(txtUsername);
        txtUsername.setColumns(10);
        txtUsername.setText(selectedMember.getUsername());
        
        txtPassword = new JTextField();
        txtPassword.setBounds(227, 84, 130, 26);
        contentPane.add(txtPassword);
        txtPassword.setColumns(10);
        txtPassword.setText(selectedMember.getPassword());

        txtFname = new JTextField();
        txtFname.setBounds(227, 112, 130, 26);
        contentPane.add(txtFname);
        txtFname.setColumns(10);
        txtFname.setText(selectedMember.getFname());

        txtLname = new JTextField();
        txtLname.setBounds(227, 140, 130, 26);
        contentPane.add(txtLname);
        txtLname.setColumns(10);
        txtLname.setText(selectedMember.getLname());

        txtPhone = new JTextField();
        txtPhone.setBounds(227, 168, 130, 26);
        contentPane.add(txtPhone);
        txtPhone.setColumns(10);
        txtPhone.setText(selectedMember.getPhone());

        lblFname = new JLabel("First Name");
        lblFname.setBounds(90, 117, 82, 16);
        contentPane.add(lblFname);

        lblLname = new JLabel("Last Name");
        lblLname.setBounds(90, 145, 76, 16);
        contentPane.add(lblLname);

        lblPhone = new JLabel("Phone");
        lblPhone.setBounds(90, 173, 61, 16);
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
        
        lblPassword = new JLabel("Password");
        lblPassword.setBounds(90, 89, 82, 16);
        contentPane.add(lblPassword);
        
        lblUsername = new JLabel("Username");
        lblUsername.setBounds(90, 61, 82, 16);
        contentPane.add(lblUsername);
        
    }

    void btn_save_clk(MemberBook memberBook) {
        if (selectedMember != null) {
            memberBook.editMember(selectedMember, txtUsername.getText(), txtPassword.getText(), txtFname.getText(), txtLname.getText(), txtPhone.getText());
            JOptionPane.showMessageDialog(EditMemberGUI.this, "Member edited successfully.");
        } else {
            JOptionPane.showMessageDialog(EditMemberGUI.this, "No member selected.");
        }
    }
}