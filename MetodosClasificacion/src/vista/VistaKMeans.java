package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Vector;



import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;



import util.MatrizToVectorVector;
import util.StringToMatriz;
import algoritmos.KMeans;

public class VistaKMeans extends JPanel
{
	EntradaString clases, centros, datos, prueba;
	EntradaParametros params;
	JTextArea text_area;
	public VistaKMeans() {
		super(new BorderLayout());
		Dimension d = new Dimension(200, 100);
		
		clases = new EntradaString("Nombre de las clases", d);
		centros = new EntradaString("Centros de las clases", d);
		datos = new EntradaString("Ejemplos de entrenamiento", d);
		prueba = new EntradaString("Ejemplos de prueba", d);
		JPanel entradas = new JPanel(new GridLayout(0,1));
		entradas.add(clases); entradas.add(centros); entradas.add(datos); entradas.add(prueba);
		
		params = new EntradaParametros(new String[]{"tolerancia", "peso exponencial"});
		
		text_area = new JTextArea(); text_area.setLineWrap(true); text_area.setWrapStyleWord(true);
		JScrollPane scroll = new JScrollPane(text_area);
		JButton ejecutar = new JButton("Ejecutar"); ejecutar.addActionListener((e) -> {
			String[] nombre_clases = clases.text_area.getText().split("\n");
			double[][] datos_centros = StringToMatriz.metodoCutre(centros.text_area.getText());
			double[][] datos_entrenamiento = StringToMatriz.metodoCutre(datos.text_area.getText());
			double[][] datos_prueba = StringToMatriz.metodoCutre(prueba.text_area.getText());

			double tolerancia = Double.parseDouble(params.campos.get("tolerancia").getText()),
					peso_exponencial = Integer.parseInt(params.campos.get("peso exponencial").getText());

			KMeans kmeans = new KMeans(datos_centros, nombre_clases, datos_entrenamiento, tolerancia, peso_exponencial);
			text_area.setText("");
			for (Vector<Double> ejemplo : MatrizToVectorVector.metodoCutre(datos_prueba)) {
				text_area.append(kmeans.comprobarPunto(ejemplo));
				text_area.append("\n");
			}
		});
		JPanel panel_aux = new JPanel(); panel_aux.setLayout(new BoxLayout(panel_aux, BoxLayout.Y_AXIS));
		panel_aux.add(scroll); panel_aux.add(ejecutar);

		add(params, BorderLayout.WEST);
		add(entradas, BorderLayout.CENTER);
		add(panel_aux, BorderLayout.EAST);
	}
}
