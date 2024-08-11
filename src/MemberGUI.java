import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class MemberGUI extends JFrame {

	private JPanel contentPane;

	private JButton btnViewTrainers;
	private JButton btnViewSessions;
	private Member activeMember;
	private TrainerBook trainerBook;

	/**
	 * Create the frame.
	 */
	public MemberGUI(Member activeMember, TrainerBook trainerBook) {
		this.activeMember = activeMember;
		this.trainerBook = trainerBook;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//JButton btnNewButton = new JButton("New button");
		//contentPane.add(btnNewButton);
		
		btnViewTrainers = new JButton("View Trainers");
		btnViewTrainers.setBounds(161, 66, 128, 29);
		contentPane.add(btnViewTrainers);
		
		btnViewSessions = new JButton("View Registered Sessions");
		btnViewSessions.setBounds(131, 131, 193, 30);
		contentPane.add(btnViewSessions);
		
		
		//btnViewSessions
		btnViewTrainers.addActionListener(
				
				
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btn_viewTrainers_clk();
					}
				}
				
				
				);
		
		
		
		btnViewSessions.addActionListener(
			new ActionListener()
				{
			   public void actionPerformed(ActionEvent e) {
	                btn_viewSessions_clk();
			
			   			}
			   }
			);
		
		
		//EventListener()
	//}

			}
	
	
		void btn_viewTrainers_clk() {
			
			BrowseTrainersGUI btGUI = new BrowseTrainersGUI(activeMember, trainerBook);
			btGUI.setVisible(true);
		}
	
		void btn_viewSessions_clk() {
			
		}
	
	
}
