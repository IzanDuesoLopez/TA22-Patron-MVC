package views;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class View_tables extends JFrame{

	// Attributes.
	
	// Main panel
	public JPanel contentPane;
	
	public View_tables() {
		
		// Parameters of the main window.
		setBounds(400, 200, 951, 588);
		
// ---- Creating the Jpanel that will contain the components.
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
	}
}
