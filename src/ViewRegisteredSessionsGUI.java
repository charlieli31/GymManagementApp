import java.awt.EventQueue;

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



	/**
	 * Create the frame.
	 */
	public ViewRegisteredSessionsGUI() {
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
		
		
	}

}
