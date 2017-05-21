package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;


import java.util.function.IntToDoubleFunction;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import algoritmos.Lloyd;
import util.StringToMatriz;


public class VistaLloyd extends JPanel
{
	EntradaString clases, centros, datos, prueba;
	EntradaParametros params;
	JTextArea text_area;
	public VistaLloyd() {
		super(new BorderLayout());
		Dimension d = new Dimension(200, 100);
		
		clases = new EntradaString("Nombre de las clases", d);
		centros = new EntradaString("Centros de las clases", d);
		datos = new EntradaString("Ejemplos de entrenamiento", d);
		prueba = new EntradaString("Ejemplos de prueba", d);
		JPanel entradas = new JPanel(new GridLayout(0,1));
		entradas.add(clases); entradas.add(centros); entradas.add(datos); entradas.add(prueba);
		
		params = new EntradaParametros(new String[]{"razón aprendizaje", "tolerancia", "max iteraciones"});
		
		text_area = new JTextArea(); text_area.setLineWrap(true); text_area.setWrapStyleWord(true);
		JScrollPane scroll = new JScrollPane(text_area);
		JButton ejecutar = new JButton("Ejecutar"); ejecutar.addActionListener((e) -> {
			String[] nombre_clases = clases.text_area.getText().split("\n");
			double[][] datos_centros = StringToMatriz.metodoCutre(centros.text_area.getText());
			double[][] datos_entrenamiento = StringToMatriz.metodoCutre(datos.text_area.getText());
			double[][] datos_prueba = StringToMatriz.metodoCutre(prueba.text_area.getText());
			IntToDoubleFunction funcion = (i) -> Double.parseDouble(params.campos.get("razón aprendizaje").getText());
			double tolerancia = Double.parseDouble(params.campos.get("tolerancia").getText());
			int max_iteraciones = Integer.parseInt(params.campos.get("max iteraciones").getText());
			
			Lloyd lloyd = new Lloyd(datos_centros, nombre_clases, datos_entrenamiento, funcion, tolerancia, max_iteraciones);
			text_area.setText("");
			for (double[] prueba : datos_prueba) {
				text_area.append(lloyd.predecirClase(prueba));
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
