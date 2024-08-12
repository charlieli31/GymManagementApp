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
	private JList list;
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
		
		
		
		list = new JList<>(convertToJList(trainerBook.getTrainers()));
		list.setBounds(75,33,287,178);
		contentPane.add(list);
		
		
		//JButton 
		btnViewTimes = new JButton("View Times");
		//btnNewButton
		btnViewTimes.setBounds(48, 222, 117, 29);
		contentPane.add(btnViewTimes);
				//NewButton
		
//		btnCancel = new JButton("Cancel");
//		btnCancel.setBounds(256, 214, 20, 45);
//		contentPane.add(btnCancel);
		
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(242, 223, 130, 29);
		contentPane.add(btnCancel);
	
		btnViewTimes.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					//BookSessionGUI bsGUI = new BookSessionGUI();
					//bsGUI.setVisible(true);
						btn_viewTimes_clk();
						}
				//);
		//btnViewTimes.addActionListener(
			   
					});


		btnCancel.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					//BookSessionGUI bsGUI = new BookSessionGUI();
					//bsGUI.setVisible(true);
						dispose();
						}
					});
	}

	void btn_viewTimes_clk() {
		Trainer selectedTrainer = (Trainer) list.getSelectedValue();
		if (selectedTrainer != null) {
			BookSessionGUI bsGUI = new BookSessionGUI(memberBook,trainerBook, activeMember, selectedTrainer);
			bsGUI.setVisible(true);
		}else {
			JOptionPane.showMessageDialog(BrowseTrainersGUI.this, "No trainer selected.");
		}
	}
	
  private Trainer[] convertToJList(ArrayList<Trainer> trainers) {
        return trainers.toArray(new Trainer[0]);
    }
}
