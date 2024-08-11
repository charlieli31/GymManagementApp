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
    private JButton btnSave;
    private JButton btnCancel;
    private MemberBook memberBook;

    public RegisterMemberGUI(MemberBook memberBook) {
        this.memberBook = memberBook;
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

        txtLname = new JTextField();
        txtLname.setBounds(159, 104, 130, 26);
        contentPane.add(txtLname);
        txtLname.setColumns(10);

        txtPhone = new JTextField();
        txtPhone.setBounds(159, 168, 130, 26);
        contentPane.add(txtPhone);
        txtPhone.setColumns(10);

        JLabel lblFname = new JLabel("First Name");
        lblFname.setBounds(69, 50, 82, 16);
        contentPane.add(lblFname);

        JLabel lblLname = new JLabel("Last Name");
        lblLname.setBounds(69, 109, 76, 16);
        contentPane.add(lblLname);

        JLabel lblPhone = new JLabel("Phone");
        lblPhone.setBounds(69, 173, 61, 16);
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
    }

    void btn_save_clk() {
        String fname = txtFname.getText();
        String lname = txtLname.getText();
        String phone = txtPhone.getText();
        if (!fname.isEmpty() && !lname.isEmpty() && !phone.isEmpty()) {
            Member newMember = new Member(fname, lname, phone);
            memberBook.addMember(newMember);
            JOptionPane.showMessageDialog(RegisterMemberGUI.this, "Member added successfully.");
            dispose();
        } else {
            JOptionPane.showMessageDialog(RegisterMemberGUI.this, "Please fill in all fields.");
        }
    }
}