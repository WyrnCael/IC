package vista.GUI;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Datos.Datos;

import java.awt.BorderLayout;
import java.awt.font.TextAttribute;

public class JPEjemplos extends JPanel {

	private JTextArea textArea;
	/**
	 * Create the panel.
	 */
	public JPEjemplos() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		textArea = new JTextArea();
		textArea.setText(Datos.getEjemplosString());
		JScrollPane scroll = new JScrollPane (textArea, 
				   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		add(scroll);

	}

}
