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
	 * 
	 */
	private static final long serialVersionUID = -4637363831661512075L;

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
	
	@SuppressWarnings("unchecked")
	@Override
	public void removeAll(){
		super.removeAll();
		add(new JLabel(" "));
		JLabel titulo = new JLabel("Méritos de atributos:");
		titulo.setFont(new Font("Tahoma", Font.BOLD, 18));
		Font font = titulo.getFont();
		@SuppressWarnings("rawtypes")
		Map attributes = font.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		titulo.setFont(font.deriveFont(attributes));
		titulo.setAlignmentX(CENTER_ALIGNMENT);
		titulo.setAlignmentY(CENTER_ALIGNMENT);
		add(titulo);
		setBorder(new TitledBorder("Méritos atributos del nodo:"));
		add(new JLabel(" "));
	}

}
