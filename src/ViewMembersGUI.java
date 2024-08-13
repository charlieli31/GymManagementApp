import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class ViewMembersGUI extends JFrame {

    private JPanel contentPane;
    private JButton btnCancel;
    private JButton btnEdit;
    private JButton btnDelete;
    private JList<Member> membersList;
    private MemberBook memberBook;

    public ViewMembersGUI(MemberBook memberBook) {
        this.memberBook = memberBook;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        membersList = new JList<>(convertToJList(memberBook.getMemberBook()));
        membersList.setBounds(78, 28, 293, 170);
        contentPane.add(membersList);

        btnEdit = new JButton("Edit");
        btnEdit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_editMember_clk();
            }
        });
        btnEdit.setBounds(35, 220, 117, 29);
        contentPane.add(btnEdit);

        btnDelete = new JButton("Delete");
        btnDelete.setBounds(164, 220, 117, 29);
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_deleteMember_clk();
            }
        });
        contentPane.add(btnDelete);

        btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnCancel.setBounds(293, 220, 117, 29);
        contentPane.add(btnCancel);
    }

    private Member[] convertToJList(ArrayList<Member> members) {
        return members.toArray(new Member[0]);
    }

    void btn_deleteMember_clk() {
        Member selectedMember = membersList.getSelectedValue();
        if (selectedMember != null) {
            memberBook.deleteMember(selectedMember);
            // Refresh the page
            membersList.setListData(convertToJList(memberBook.getMemberBook()));
        } else {
            JOptionPane.showMessageDialog(ViewMembersGUI.this, "Please select a member to delete.");
        }
    }

    void btn_editMember_clk() {
        Member selectedMember = membersList.getSelectedValue();
        if (selectedMember != null) {
            EditMemberGUI eGUI = new EditMemberGUI(memberBook, selectedMember);
            eGUI.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(ViewMembersGUI.this, "Please select a member to edit.");
        }
    }
}