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
		JTabbedPane pesta�as = new JTabbedPane();
		pesta�as.add("K-Means", new VistaKMeans());
		pesta�as.add("Bayes", new VistaBayes());
		pesta�as.add("Lloyd", new VistaLloyd());
		pesta�as.add("SOM", new VistaSOM());
		add(pesta�as, BorderLayout.CENTER);
	}
	
	public static void main (String args[]) {
		JFrame f = new JFrame("IC Pr�ctica 3");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
		f.setContentPane(new Vista());
		f.pack();
		f.setVisible(true);
	}
}
