package vista.GUI;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;

public class Datos extends JPanel {

	/**
	 * Create the panel.
	 */
	public Datos() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JTextArea textArea = new JTextArea();
		JScrollPane scroll = new JScrollPane (textArea, 
				   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBorder(new TitledBorder("Clase 1: "));
		add(scroll);
		
		JTextArea textArea2 = new JTextArea();
		JScrollPane scroll2 = new JScrollPane (textArea2, 
				   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll2.setBorder(new TitledBorder("Clase 2: "));
		add(scroll2);
		

	}

}
