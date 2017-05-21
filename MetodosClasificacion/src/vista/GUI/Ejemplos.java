package vista.GUI;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.BorderLayout;

public class Ejemplos extends JPanel {

	/**
	 * Create the panel.
	 */
	public Ejemplos() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JTextArea textArea = new JTextArea();
		JScrollPane scroll = new JScrollPane (textArea, 
				   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		add(scroll);

	}

}
