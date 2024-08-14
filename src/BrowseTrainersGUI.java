import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;

public class BrowseTrainersGUI extends JFrame {

	private JPanel contentPane;
	private JList trainersList;
	private JButton btnViewTimes;
	private JButton btnCancel;
	private Member activeMember;
	private MemberBook memberBook;
	private TrainerBook trainerBook;

	/**
	 * Create the frame.
	 */
	public BrowseTrainersGUI(MemberBook memberBook, Member activeMember, TrainerBook trainerBook) {
		this.memberBook = memberBook;
		this.activeMember = activeMember;
		this.trainerBook =  trainerBook;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Trainers List
		trainersList = new JList<>(convertToJList(trainerBook.getTrainers()));
		trainersList.setBounds(75,33,287,178);
		contentPane.add(trainersList);
		
		// View times button
		btnViewTimes = new JButton("View Times");
		btnViewTimes.setBounds(48, 222, 117, 29);
		contentPane.add(btnViewTimes);
		
		// Cancel button
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(242, 223, 130, 29);
		contentPane.add(btnCancel);
	
		// View times event
		btnViewTimes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_viewTimes_clk();
			}
		});

		// Cancel event
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}

	// click View Times
	private void btn_viewTimes_clk() {
		Trainer selectedTrainer = (Trainer) trainersList.getSelectedValue();
		if (selectedTrainer != null) {
			BookSessionGUI bsGUI = new BookSessionGUI(memberBook,trainerBook, activeMember, selectedTrainer);
			bsGUI.setVisible(true);
		}else {
			// handle the case if the user did not select a trainer
			JOptionPane.showMessageDialog(BrowseTrainersGUI.this, "No trainer selected.");
		}
	}
	
	// convert to JList
	private Trainer[] convertToJList(ArrayList<Trainer> trainers) {
        return trainers.toArray(new Trainer[0]);
    }
}
