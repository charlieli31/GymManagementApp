import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class AdminGUI extends JFrame {

    private JPanel contentPane;
    private JButton btnRegister;
    private JButton btnViewMember;
    private JButton btnBack;
    private MemberBook memberBook;

    public AdminGUI(MemberBook memberBook) {
        this.memberBook = memberBook;
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
                btn_registerMember_clk();
            }
        });

        btnViewMember = new JButton("View Member Profiles");
        btnViewMember.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_viewMember_clk();
            }
        });
        btnViewMember.setBounds(120, 120, 198, 29);
        contentPane.add(btnViewMember);

        btnBack = new JButton("Go Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnBack.setBounds(161, 188, 117, 29);
        contentPane.add(btnBack);
    }

    void btn_registerMember_clk() {
        RegisterMemberGUI rmGUI = new RegisterMemberGUI(memberBook);
        rmGUI.setVisible(true);
    }

    void btn_viewMember_clk() {
        ViewMembersGUI vmGUI = new ViewMembersGUI(memberBook);
        vmGUI.setVisible(true);
    }
}