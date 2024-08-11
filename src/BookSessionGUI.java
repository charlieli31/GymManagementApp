import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class BookSessionGUI extends JFrame {

	private JPanel contentPane;
	private JButton btnBook;
	private JButton btnCancel;
	private JList times;

	/**
	 * Create the frame.
	 */
	public BookSessionGUI(Trainer trainer) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
//		btnBook = new JButton("Book Session");
//		btnBook.setBounds(167,55,118,29);
//		contentPane.add(btnBook);
		
		
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

	}
	
	 private Session[] convertToJList(ArrayList<Session> sessions) {
	        return sessions.toArray(new Session[0]);
	    }
	}
	
	

//}
