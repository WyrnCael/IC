package GUI;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JLabel;

public class Entropias extends JPanel {

	/**
	 * Create the panel.
	 */
	public Entropias() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

	}
	
	public void addLabel(JLabel label){
		label.setAlignmentX(CENTER_ALIGNMENT);
		label.setAlignmentY(CENTER_ALIGNMENT);
		add(label);
	}
	
	@Override
	public void removeAll(){
		super.removeAll();
		JLabel titulo = new JLabel("Entropias:");
		titulo.setFont(new Font("Tahoma", Font.BOLD, 18));
		Font font = titulo.getFont();
		Map attributes = font.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		titulo.setFont(font.deriveFont(attributes));
		titulo.setAlignmentX(CENTER_ALIGNMENT);
		titulo.setAlignmentY(CENTER_ALIGNMENT);
		add(titulo);
		setBorder(new TitledBorder("Entropías del nodo:"));
		add(new JLabel(" "));
	}

}
