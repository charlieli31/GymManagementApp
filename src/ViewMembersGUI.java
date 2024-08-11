import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;

public class ViewMembersGUI extends JFrame {

	private JPanel contentPane;
	private JButton btnCancel;
	private JButton btnEdit;
	private JButton btnDelete;
	private JList<Member> membersList;


	public ViewMembersGUI(MemberBook memberBook) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		membersList = new JList<>(convertToJList(memberBook.getSerializaedMemberBook()));
		membersList.setBounds(78, 28, 293, 170);
		contentPane.add(membersList);
		
		// Edit
		btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_editMember_clk(memberBook);
			}
		});
		btnEdit.setBounds(35, 220, 117, 29);
		contentPane.add(btnEdit);
		
		// Delete
		btnDelete = new JButton("Delete");
		btnDelete.setBounds(164, 220, 117, 29);
		contentPane.add(btnDelete);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Close the current window
                dispose();
            }
        });
		btnCancel.setBounds(293, 220, 117, 29);
		contentPane.add(btnCancel);
	}
	// Method to convert ArrayList<Member> to Member[] for JList
    private Member[] convertToJList(ArrayList<Member> members) {
        return members.toArray(new Member[0]);
    }
    
    void btn_editMember_clk(MemberBook memberBook) {
//		EditMemberGUI eGUI = new EditMemberGUI(memberBook);
//		eGUI.setVisible(true);
	}
}
