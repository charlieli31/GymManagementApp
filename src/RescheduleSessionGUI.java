import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class RescheduleSessionGUI extends JFrame {

	private JPanel contentPane;
	private JList times;
	private JButton btnReschedule;
	private JButton btnCancel;
	private JLabel lblOriginalTime;
	private JLabel lblBookedTime;
	private Trainer trainer;
	private Member activeMember;
	private MemberBook memberBook;
	private TrainerBook trainerBook;
	private Session session;


	/**
	 * Create the frame.
	 */
	public RescheduleSessionGUI(Member activeMember, Session session, MemberBook memberBook, TrainerBook trainerBook) {
		
		trainer = session.getTrainer();
		this.activeMember = activeMember;
		this.session = session;
		this.memberBook = memberBook;
		this.trainerBook = trainerBook;
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// JList "times" showing available times
		times = new JList<>(convertToJList(trainer.getSessions()));
		times.setBounds(157, 30, 265, 167);
		contentPane.add(times);
		
		// Reschedule or swap function
		btnReschedule = new JButton("Reschedule");
		btnReschedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_reschedule_clk();
				// OptionPane to pop up successful message
			}
		});
		btnReschedule.setBounds(157, 209, 117, 29);
		contentPane.add(btnReschedule);
		
		// Cancel
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(305, 209, 117, 29);
		contentPane.add(btnCancel);
		
		lblOriginalTime = new JLabel("Original Time");
		lblOriginalTime.setBounds(30, 30, 104, 16);
		contentPane.add(lblOriginalTime);
		
		// Showing original Booked Time
		lblBookedTime = new JLabel(session.getDate() + ", " + session.getTime());
		lblBookedTime.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		lblBookedTime.setBounds(30, 58, 117, 16);
		contentPane.add(lblBookedTime);
	}
	
	private Session[] convertToJList(ArrayList<Session> sessions) {
        return sessions.toArray(new Session[0]);
    }
	
	void btn_reschedule_clk() {
		
		
		// Deleting the original session
		activeMember.getSessions().remove(session);
		trainer.getSessions().add(session);
		
		// Adding the new session
		activeMember.getSessions().add((Session)times.getSelectedValue());
		trainer.getSessions().remove((Session)times.getSelectedValue());
		
		FileManager.saveMembersToFile(memberBook.getMemberBook());
		FileManager.saveTrainersToFile(trainerBook.getTrainers());
		
		// Show success message and close the window
        JOptionPane.showMessageDialog(this, "Session rescheduled successfully.");
        dispose();
	}
	
}
