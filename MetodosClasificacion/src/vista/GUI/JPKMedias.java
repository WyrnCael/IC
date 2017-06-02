package vista.GUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import Datos.Datos;
import algoritmos.Bayes;
import algoritmos.KMeans;
import util.MatrizToVectorVector;
import util.StringToMatriz;

import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout.Alignment;

public class JPKMedias extends JPanel {
	
	private final JPanel panel_3 = new JPanel();
	private JPResultados panelResultados;
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
		textField.setText(Datos.getCentros1String());
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
		textField_1.setText(Datos.getCentros2String());
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
		
		panelResultados = new JPResultados();
		panelResultados.setBorder(new TitledBorder("Comprobación: "));
		add(panelResultados);
		
		JButton btnComprobar = panelResultados.getButton();
		
		for( ActionListener al : btnComprobar.getActionListeners() ) {
			btnComprobar.removeActionListener( al );
	    }
		
		btnComprobar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String[] nombre_clases = {Datos.getClases().get(0), Datos.getClases().get(1)};
				double[][] datos_centros = Datos.getCentros();
				
				double[][] datos_entrenamiento = new double[Datos.getDatosClases().get(0).length + Datos.getDatosClases().get(1).length][Datos.getDatosClases().get(0)[0].length]; 
						
				int pos = 0;
				for(int i = 0; i < Datos.getDatosClases().get(0).length; i++){
					datos_entrenamiento[pos+i] = Datos.getDatosClases().get(0)[i];
				}				
				pos = Datos.getDatosClases().get(0).length;
				for(int i = 0; i < Datos.getDatosClases().get(1).length; i++){
					datos_entrenamiento[pos+i] = Datos.getDatosClases().get(1)[i];
				}
				
				double[][] datos_prueba = new double[Datos.getEjemplos().size()][Datos.getEjemplos().get(0).length];
				for(int i = 0; i < Datos.getEjemplos().size(); i++){
					datos_prueba[i] = Datos.getEjemplos().get(i);
				}

				double tolerancia = 0.01,
						peso_exponencial = 2;

				KMeans kmeans = new KMeans(datos_centros, nombre_clases, datos_entrenamiento, tolerancia, peso_exponencial);
				
				String s = "";
				int i = 1;
				for (Vector<Double> ejemplo : MatrizToVectorVector.metodoCutre(datos_prueba)) {
					s += i + "º = " + kmeans.comprobarPunto(ejemplo);
					s += "\n";
					i++;
				}
				
				panelResultados.setResultados(s);
			}
			
			
		});
		
	}

}
