package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Vista extends JPanel
{
	static final Dimension DIMENSION_CAMPO = new Dimension(200, 25);
	
	public Vista() {
		super(new BorderLayout());
		JTabbedPane pestañas = new JTabbedPane();
		pestañas.add("K-Means", new VistaKMeans());
		pestañas.add("Bayes", new VistaBayes());
		pestañas.add("Lloyd", new VistaLloyd());
		pestañas.add("SOM", new VistaSOM());
		add(pestañas, BorderLayout.CENTER);
	}
	
	public static void main (String args[]) {
		JFrame f = new JFrame("IC Práctica 3");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
		f.setContentPane(new Vista());
		f.pack();
		f.setVisible(true);
	}
}
