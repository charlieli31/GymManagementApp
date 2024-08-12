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

		

		

		btnBook = new JButton("Book Session");

		btnBook.setBounds(62,194,118,29);

		contentPane.add(btnBook);

		

		

		btnCancel = new JButton("Cancel");

		btnCancel.setBounds(246,194,137,29);

		contentPane.add(btnCancel);

				//btnBook);

		

		times = new JList<>(convertToJList(trainer.getSessions()));

		times.setBounds(75,33,289,149);

		contentPane.add(times);

		

		btnBook.addActionListener(

			new ActionListener() {

				//)//}//{

				public void actionPerformed(ActionEvent e) {

					//btn_add_clk()

					btn_book_clk();

					//activeMember.getSessions().add((Session)times.getSelectedValue());

					

					}

				


					});

		btnCancel.addActionListener(

				new ActionListener() {

					//)//}//{

					public void actionPerformed(ActionEvent e) {

						//btn_add_clk()

						dispose();

						//activeMember.getSessions().add((Session)times.getSelectedValue());

						

						}

					


						});

			

		

	

	}

	private void btn_book_clk() {

		Session selectedSession = (Session)times.getSelectedValue();

		if (selectedSession != null) {
			activeMember.getSessions().add(selectedSession);
			trainer.getSessions().remove(selectedSession);
			activeMember.incrementSessionFee();
			FileManager.saveMembersToFile(memberBook.getMemberBook());
			FileManager.saveTrainersToFile(trainerBook.getTrainers());
	
	        JOptionPane.showMessageDialog(BookSessionGUI.this, "Session Booked Successfully.");
	        dispose();
		}else {
			JOptionPane.showMessageDialog(BookSessionGUI.this, "No session selected.");
		}

		

	}

	

	 private Session[] convertToJList(ArrayList<Session> sessions) {
	        return sessions.toArray(new Session[0]);

	    }

	}

	

	


//}
