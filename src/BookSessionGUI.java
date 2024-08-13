import java.awt.EventQueue;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.util.ArrayList;


import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.JList;

import javax.swing.JOptionPane;

import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;


public class BookSessionGUI extends JFrame {

	private JPanel contentPane;
	private JButton btnBook;
	private JButton btnCancel;
	private JList times;
	private Member activeMember;
	private Trainer trainer;
	private MemberBook memberBook;
	private TrainerBook trainerBook;


	/**

	 * Create the frame.

	 */

	public BookSessionGUI(MemberBook memberBook, TrainerBook trainerBook, Member activeMember, Trainer trainer) {

		// initialize
		this.memberBook  = memberBook;
		this.activeMember = activeMember;
		this.trainer =  trainer;
		this.trainerBook =  trainerBook;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Book Session button
		btnBook = new JButton("Book Session");
		btnBook.setBounds(62,194,118,29);
		contentPane.add(btnBook);

		// Cancel button
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(246,194,137,29);
		contentPane.add(btnCancel);

		// JList
		times = new JList<>(convertToJList(trainer.getSessions()));
		times.setBounds(75,33,289,149);
		contentPane.add(times);

		
		btnBook.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btn_book_clk();
				}
			});
		btnCancel.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// return to last page
					dispose();
				}
			});
		
		// refreshing the page
		refreshSessionList();
	}

	// click book button
	private void btn_book_clk() {
		// select a session
		Session selectedSession = (Session)times.getSelectedValue();
		if (selectedSession != null) {
			activeMember.getSessions().add(selectedSession);
			trainer.getSessions().remove(selectedSession);
			activeMember.incrementSessionFee();
			FileManager.saveMembersToFile(memberBook.getMemberBook());
			FileManager.saveTrainersToFile(trainerBook.getTrainers());
			// show a message booked successfully
	        JOptionPane.showMessageDialog(BookSessionGUI.this, "Session Booked Successfully.");
	        refreshSessionList();
	        dispose();
		}else {
			// handle the case if the user did not select a session
			JOptionPane.showMessageDialog(BookSessionGUI.this, "No session selected.");
		}

		

	}
	private void refreshSessionList() {
        times.setListData(convertToJList(trainer.getSessions())); // Update the JList data
    }

	

	private Session[] convertToJList(ArrayList<Session> sessions) {
	        return sessions.toArray(new Session[0]);
	}
	
}
