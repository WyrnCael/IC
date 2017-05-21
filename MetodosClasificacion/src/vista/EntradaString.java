package vista;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import util.FicheroToString;

public class EntradaString extends JPanel
{
	JTextArea text_area;
	JButton boton_carga;
	JTextField text_field;
	
	public EntradaString(String titulo, Dimension dimension) {
		super(); setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		text_area = new JTextArea(); text_area.setLineWrap(true); text_area.setWrapStyleWord(true);
		JScrollPane scroll = new JScrollPane(text_area); scroll.setPreferredSize(dimension);
		
		text_field = new JTextField(); text_field.setPreferredSize(Vista.DIMENSION_CAMPO);
		boton_carga = new JButton("Cargar de fichero"); boton_carga.addActionListener((e) -> {
			text_area.setText(FicheroToString.metodoCutre(text_field.getText()));
		});
		JPanel panel_aux = new JPanel(new GridLayout(0, 2));
		panel_aux.add(boton_carga); panel_aux.add(text_field);
		panel_aux.setAlignmentX(CENTER_ALIGNMENT);
		
		add(scroll); add(panel_aux);
		setBorder(BorderFactory.createTitledBorder(titulo));
	}
}
