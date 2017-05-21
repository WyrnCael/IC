package vista;

import java.awt.GridLayout;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EntradaParametros extends JPanel
{
	HashMap<String, JTextField> campos;
	
	public EntradaParametros(String[] nombres) {
		super(new GridLayout(0,2));
		campos = new HashMap<String, JTextField>();
		for (String nombre : nombres) {
			JLabel etiqueta = new JLabel(nombre);
			JTextField campo = new JTextField(); campo.setPreferredSize(Vista.DIMENSION_CAMPO);
			campos.put(nombre, campo);
			add(etiqueta); add(campo);
		}
	}
}
