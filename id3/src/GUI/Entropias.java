package GUI;

import javax.swing.JPanel;

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
		add(label);
	}
	
	@Override
	public void removeAll(){
		super.removeAll();
		JLabel titulo = new JLabel("Entropias:");
		titulo.setFont(new Font("Courier New", Font.BOLD, 18));
		Font font = titulo.getFont();
		Map attributes = font.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		titulo.setFont(font.deriveFont(attributes));
		titulo.setAlignmentX(CENTER_ALIGNMENT);
		titulo.setAlignmentY(CENTER_ALIGNMENT);
		add(titulo);
		add(new JLabel(" "));
	}

}
