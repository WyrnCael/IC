package vista.GUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import Datos.Datos;

import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class JPKMedias extends JPanel {
	private final JPanel panel_3 = new JPanel();
	private JTextArea textField;
	private JTextArea textField_1;

	/**
	 * Create the panel.
	 */
	public JPKMedias() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JPanel informacion = new JPanel();
		add(informacion);
		informacion.setLayout(new BoxLayout(informacion, BoxLayout.Y_AXIS));
		
		JPanel centros = new JPanel();
		centros.setBorder(new TitledBorder("Centros de las clases: "));
		informacion.add(centros);
		centros.setLayout(new BoxLayout(centros, BoxLayout.Y_AXIS));
		
		JPanel c1 = new JPanel();
		centros.add(c1);
		c1.setLayout(new BoxLayout(c1, BoxLayout.X_AXIS));
		
		JLabel lblClase = new JLabel("Clase 1:");
		c1.add(lblClase);
		
		textField = new JTextArea();
		JScrollPane scroll = new JScrollPane (textField, 
				JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBorder(new TitledBorder("Clase 1: "));
		c1.add(scroll);
		textField.setColumns(10);
		
		JPanel c2 = new JPanel();
		centros.add(c2);
		c2.setLayout(new BoxLayout(c2, BoxLayout.X_AXIS));
		
		JLabel lblClase_1 = new JLabel("Clase 2:");
		c2.add(lblClase_1);
		
		textField_1 = new JTextArea();
		JScrollPane scroll2 = new JScrollPane (textField_1, 
				JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBorder(new TitledBorder("Clase 1: "));
		c2.add(scroll2);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Tolerancia: 0.01");
		informacion.add(lblNewLabel);
		
		JLabel lblPesoExponencial = new JLabel("Peso exponencial: 2");
		informacion.add(lblPesoExponencial);
		
		JPDatos datos = new JPDatos();
		datos.setBorder(new TitledBorder("Datos: "));
		add(datos);
		
		JPEjemplos ejemplos = new JPEjemplos();
		ejemplos.setBorder(new TitledBorder("Ejemplos: "));
		add(ejemplos);
		
		JPanel panel_4 = new JPanel();
		add(panel_4);
		
	}

}
