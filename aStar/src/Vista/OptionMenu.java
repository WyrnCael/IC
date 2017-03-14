package Vista;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import javax.swing.JTextField;

import aStar.Mapa;

import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

public class OptionMenu extends JPanel {
	private JTextField textFieldFilas;
	private JTextField textFieldColumnas;

	/**
	 * Create the panel.
	 */
	public OptionMenu() {
		
		JLabel lblMapa = new JLabel("Opciones del mapa:");
		lblMapa.setFont(new Font("Tahoma", Font.PLAIN, 23));
		
		JButton btnGenerarVacio = new JButton("Generar vacio");
		
		JButton btnGenerarAleatorio = new JButton("Generar aleatorio");
		
		JLabel lblFilas = new JLabel("Filas (M):");
		
		textFieldFilas = new JTextField();
		textFieldFilas.setColumns(10);
		
		JLabel lblColumnas = new JLabel("Columnas (N):");
		
		textFieldColumnas = new JTextField();
		textFieldColumnas.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		
		JSeparator separator = new JSeparator();
		
		JLabel lblInsertarNuevosElementos = new JLabel("Insertar nuevos elementos:");
		lblInsertarNuevosElementos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblInicio = new JLabel("Inicio:");
		lblInicio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnNewButton = new JButton("New button");
		
		JLabel lblDestino = new JLabel("Destino:");
		lblDestino.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton button = new JButton("New button");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(26)
							.addComponent(lblFilas, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldFilas, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(lblColumnas, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldColumnas, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(8)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(separator, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 306, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnGenerarVacio, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
									.addGap(20)
									.addComponent(btnGenerarAleatorio, GroupLayout.PREFERRED_SIZE, 154, Short.MAX_VALUE))))
						.addComponent(lblMapa)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblInsertarNuevosElementos)
							.addPreferredGap(ComponentPlacement.RELATED, 48, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(lblInicio)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblDestino, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblMapa, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFieldFilas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblFilas)
								.addComponent(lblColumnas)
								.addComponent(textFieldColumnas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(14)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnGenerarAleatorio)
								.addComponent(btnGenerarVacio))
							.addGap(13)
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblInsertarNuevosElementos)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDestino, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(button)
								.addComponent(lblInicio)
								.addComponent(btnNewButton)))
						.addComponent(separator_1, GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE))
					.addGap(0))
		);
		setLayout(groupLayout);
		
		btnGenerarVacio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try{
					int filas = Integer.valueOf(textFieldFilas.getText());
					int columnas = Integer.valueOf(textFieldColumnas.getText());
					if(filas == 0 || columnas == 0)
						throw new NumberFormatException();
					VistaPrincipal.getInstance().setMapa(new Mapa(filas, columnas));
				} catch(NumberFormatException nF){
					JOptionPane.showMessageDialog(null, "El campo filas y columnas deben contener dígitos y ser mayor a 0.");
				}
				
			}
		});
		
	}
}
