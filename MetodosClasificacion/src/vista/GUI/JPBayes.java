package vista.GUI;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import Datos.Datos;
import algoritmos.Bayes;
import util.StringToMatriz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;

public class JPBayes extends JPanel {
	
	private JPResultados panelResultados;
	private final JPanel panel_3 = new JPanel();

	/**
	 * Create the panel.
	 */
	public JPBayes() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
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
				Bayes bayes = new Bayes();
				
				
				for (int i = 0; i < Datos.getClases().size(); i++) {
					bayes.aprenderClase(Datos.getDatosClases().get(i), Datos.getClases().get(i));
				}
				
				String s = "";
				int i = 1;
				for (double[] ejemplo : Datos.getEjemplos()) {
					s += i + "º = " + bayes.predecirClase(ejemplo);
					s += "\n";
					i++;
				}
				
				panelResultados.setResultados(s);
			}
			
			
		});
		
	}

}
