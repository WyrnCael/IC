package vista.GUI;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.BoxLayout;

public class Bayes extends JPanel {
	private final JPanel panel_3 = new JPanel();

	/**
	 * Create the panel.
	 */
	public Bayes() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		Datos datos = new Datos();
		datos.setBorder(new TitledBorder("Datos: "));
		add(datos);
		
		Ejemplos ejemplos = new Ejemplos();
		ejemplos.setBorder(new TitledBorder("Ejemplos: "));
		add(ejemplos);
		
		JPanel panel_4 = new JPanel();
		add(panel_4);
		
	}

}
