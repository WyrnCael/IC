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

import util.FicheroToString;
import util.StringToMatriz;
import algoritmos.Bayes;
import algoritmos.Lloyd;

public class VistaBayes extends JPanel
{
	EntradaString datos, prueba;
	EntradaParametros params;
	JTextArea text_area;
	public VistaBayes() {
		super(new BorderLayout());
		Dimension d = new Dimension(200, 100);
		datos = new EntradaString("Ejemplos de entrenamiento", d);
		prueba = new EntradaString("Ejemplos de prueba", d);
		JPanel entradas = new JPanel(new GridLayout(0,1));
		entradas.add(datos); entradas.add(prueba);
		
		text_area = new JTextArea(); text_area.setLineWrap(true); text_area.setWrapStyleWord(true);
		JScrollPane scroll = new JScrollPane(text_area);
		JButton ejecutar = new JButton("Ejecutar"); ejecutar.addActionListener((e) -> {
			
			Bayes bayes = new Bayes();
			
			String[] datos_entrada = datos.text_area.getText().split("\\s{3,}");
			for (int i = 0; i < datos_entrada.length; i+=2) {
				bayes.aprenderClase(StringToMatriz.metodoCutre(datos_entrada[i+1]), datos_entrada[i]);
			}
			
			double[][] datos_prueba = StringToMatriz.metodoCutre(prueba.text_area.getText());
			
			text_area.setText("");
			
			for (double[] prueba : datos_prueba) {
				text_area.append(bayes.predecirClase(prueba));
				text_area.append("\n");
			}
		});
		JPanel panel_aux = new JPanel(); panel_aux.setLayout(new BoxLayout(panel_aux, BoxLayout.Y_AXIS));
		panel_aux.add(scroll); panel_aux.add(ejecutar);
		
		add(entradas, BorderLayout.CENTER);
		add(panel_aux, BorderLayout.EAST);
	}
}
