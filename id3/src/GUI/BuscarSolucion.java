package GUI;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import datos.Datos;
import estructuras.Atributo;
import estructuras.Ejemplo;

import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

public class BuscarSolucion extends JPanel {
	private JTextField textFieldresultado;
	private JComboBox comboBoxViento;
	private JComboBox comboBoxHumedad;
	private JComboBox comboBoxtemperatura;
	private JComboBox comboBoxTiempoExterior;
	private String[] modelViento = new String[] {"Verdad", "Falso"};
	private String[] modelHumedad = new String[] {"Alta", "Normal"};
	private String[] modelTemperatura = new String[] {"Caluroso", "Templado", "Frio"};
	private String[] modelTiempoExterior = new String[] {"Soleado", "Nublado", "Lluvioso"};
	

	/**
	 * Create the panel.
	 */
	public BuscarSolucion() {
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder("Comprobación:"));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(20, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(separator, GroupLayout.PREFERRED_SIZE, 239, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(12)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
					.addGap(12))
		);
		
		textFieldresultado = new JTextField();
		textFieldresultado.setColumns(10);		
		
		JLabel label = new JLabel("Resultado:");
		label.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		JLabel labelviento = new JLabel("Viento:");
		labelviento.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		comboBoxViento = new JComboBox();
		comboBoxViento.setModel(new DefaultComboBoxModel(modelViento));
		comboBoxViento.addItemListener(new CustomItemListener());
		
		comboBoxHumedad = new JComboBox();
		comboBoxHumedad.setModel(new DefaultComboBoxModel(modelHumedad));
		comboBoxHumedad.addItemListener(new CustomItemListener());
		
		JLabel labelHumedad = new JLabel("Humedad:");
		labelHumedad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel labelTemperatura = new JLabel("Temperatura:");
		labelTemperatura.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		comboBoxtemperatura = new JComboBox();
		comboBoxtemperatura.setModel(new DefaultComboBoxModel(modelTemperatura));
		comboBoxtemperatura.addItemListener(new CustomItemListener());
		
		comboBoxTiempoExterior = new JComboBox();
		comboBoxTiempoExterior.setModel(new DefaultComboBoxModel(modelTiempoExterior));
		comboBoxTiempoExterior.addItemListener(new CustomItemListener());
		
		textFieldresultado.setText(Controlador.getInstance().compruebaDatos(getDatos()));
		
		JLabel labelTiempoExterior = new JLabel("Tiempo exterior:");
		labelTiempoExterior.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(labelTiempoExterior, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(comboBoxTiempoExterior, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(labelTemperatura, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(comboBoxtemperatura, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(labelHumedad, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(comboBoxHumedad, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(labelviento, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(comboBoxViento, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
							.addGap(39)
							.addComponent(textFieldresultado, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
							.addGap(14)))
					.addGap(20))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(1)
							.addComponent(labelTiempoExterior, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addComponent(comboBoxTiempoExterior, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(1)
							.addComponent(labelTemperatura, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addComponent(comboBoxtemperatura, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(1)
							.addComponent(labelHumedad, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addComponent(comboBoxHumedad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(1)
							.addComponent(labelviento, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addComponent(comboBoxViento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(2)
							.addComponent(textFieldresultado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);
	}
	
	public class CustomItemListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			textFieldresultado.setText(Controlador.getInstance().compruebaDatos(getDatos()));			
			revalidate();
			repaint();			
		}
		
	}
	
	private ArrayList<Ejemplo> getDatos(){
		ArrayList<Ejemplo> datos = new ArrayList<Ejemplo>();
		datos.add(new Ejemplo(modelTiempoExterior[comboBoxTiempoExterior.getSelectedIndex()].toLowerCase(), 0));
		datos.add(new Ejemplo(modelTemperatura[comboBoxtemperatura.getSelectedIndex()].toLowerCase(), 1));
		datos.add(new Ejemplo(modelHumedad[comboBoxHumedad.getSelectedIndex()].toLowerCase(), 2));
		datos.add(new Ejemplo(modelViento[comboBoxViento.getSelectedIndex()].toLowerCase(), 3));
		
		return datos;
	}
}
