import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class BusinessAnalystGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtMembership;
	private JTextField txtSession;
	private JTextField txtTotal;
	private MemberBook memberBook;
	private JLabel lblMembership;
	private JLabel lblSessionRevenue;
	private JLabel lblTotal;
	private JButton btnTotalRevenue;
	private JButton btnCancel;
	

	/**
	 * Create the frame.
	 */
	public BusinessAnalystGUI(MemberBook memberBook) {
		
		this.memberBook = memberBook;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblMembership = new JLabel("Membership Revenue");
		lblMembership.setBounds(72, 50, 160, 16);
		contentPane.add(lblMembership);
		
		
		lblSessionRevenue = new JLabel("Session Revenue");
		lblSessionRevenue.setBounds(71, 100, 130, 16);
		contentPane.add(lblSessionRevenue);
		
		lblTotal = new JLabel("Total Revenue");
		lblTotal.setBounds(71, 154, 130, 16);
		contentPane.add(lblTotal);
		
		txtMembership = new JTextField();
		txtMembership.setBounds(228, 45, 130, 26);
		contentPane.add(txtMembership);
		txtMembership.setColumns(10);
		
		txtTotal = new JTextField();
		txtTotal.setBounds(228, 149, 130, 26);
		contentPane.add(txtTotal);
		txtTotal.setColumns(10);
		
		txtSession = new JTextField();
		txtSession.setBounds(228, 95, 130, 26);
		contentPane.add(txtSession);
		txtSession.setColumns(10);
		
		btnTotalRevenue = new JButton("Analyze Total Revenue");
		btnTotalRevenue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_analyze_clk();
            }
        });
		btnTotalRevenue.setBounds(56, 204, 176, 29);
		contentPane.add(btnTotalRevenue);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
		btnCancel.setBounds(270, 204, 117, 29);
		contentPane.add(btnCancel);
	}
	
	// click Analyze Total Revenue
	private void btn_analyze_clk() {
		// Get Membership Revenue
		txtMembership.setText(Integer.toString(Member.getMembershipFee()));
		// Get Session Revenue
		int totalSessionFee = 0;
		int totalRevenue = 0;
		for (Member member : memberBook.getMemberBook()) {
			totalSessionFee += member.getSessionFee();
		}
		txtSession.setText(Integer.toString(totalSessionFee));
		// Get total revenue
		totalRevenue = Member.getMembershipFee() + totalSessionFee;
		txtTotal.setText(Integer.toString(totalRevenue));
	}

}
