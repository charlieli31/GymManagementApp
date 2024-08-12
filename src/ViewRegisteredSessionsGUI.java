import java.awt.EventQueue;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.util.ArrayList;


import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.JList;

import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;


public class ViewRegisteredSessionsGUI extends JFrame {


	private JPanel contentPane;

	private JButton btnReschedule;

	private JButton btnCancelSession;

	private JButton btnCancel;

	private JList sessions;

	private MemberBook memberBook;

	private Member activeMember;

	private TrainerBook trainerBook;




	/**

	 * Create the frame.

	 */

	public ViewRegisteredSessionsGUI(MemberBook memberBook, Member activeMember, TrainerBook trainerBook) {

		this.memberBook = memberBook;

		this.activeMember = activeMember;

		this.trainerBook = trainerBook;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 450, 300);

		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));


		setContentPane(contentPane);

		contentPane.setLayout(null);

		

		btnReschedule = new JButton("Reschedule");

		btnReschedule.setBounds(37, 186, 115, 29);

		//btnReschedule.setBounds(100, 100, 450, 300);

		contentPane.add(btnReschedule);

		

		

		btnCancel = new JButton("Cancel");

		btnCancel.setBounds(334, 186, 86, 29);

		//btnCancel.setBounds(100, 100, 450, 300);

		contentPane.add(btnCancel);

		

		btnCancelSession = new JButton("Cancel Session");

		btnCancelSession.setBounds(178, 193, 138, 15);

		contentPane.add(btnCancelSession);

		

		sessions= new JList<>(convertToJList(activeMember.getSessions()));

		sessions.setBounds(80, 11, 293, 170);

        contentPane.add(sessions);

        

        btnCancel.addActionListener(

        		new ActionListener() {

        			public void actionPerformed(ActionEvent e) {

                        dispose();

                    }

                });

        

        btnCancelSession.addActionListener(

        		new ActionListener() {

        			public void actionPerformed(ActionEvent e) {//c

                        btn_cancelSession_clk();

                    }

                });

        			

		

	

		btnReschedule.addActionListener(

        		new ActionListener() {

        			public void actionPerformed(ActionEvent e) {//c

        				btn_rescheduleSession_clk();

                    }

                });

        			

		}

        		

        		

    

        

        

        

        		

        		

        		

		

	private void btn_cancelSession_clk() {

		Session  session = (Session) sessions.getSelectedValue();

		activeMember.getSessions().remove(sessions.getSelectedValue());

		session.getTrainer().getSessions().add(session);

		

		//remove(session);

		

		

		FileManager.saveMembersToFile(memberBook.getMemberBook());

		FileManager.saveTrainersToFile(trainerBook.getTrainers());

		

		dispose();

	}

	

	


    private Session[] convertToJList(ArrayList<Session> sessions) {

        return sessions.toArray(new Session[0]);

    }


}
