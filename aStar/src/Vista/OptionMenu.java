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

public class OptionMenu extends JPanel {
	private JTextField textFieldFilas;
	private JTextField textFieldColumnas;

	/**
	 * Create the panel.
	 */
	public OptionMenu() {
		setLayout(null);
		
		JLabel lblMapa = new JLabel("Mapa:");
		lblMapa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMapa.setBounds(10, 11, 61, 20);
		add(lblMapa);
		
		JButton btnGenerarVacio = new JButton("Generar vacio");
		btnGenerarVacio.setBounds(10, 73, 132, 23);
		add(btnGenerarVacio);
		
		JButton btnGenerarAleatorio = new JButton("Generar aleatorio");
		btnGenerarAleatorio.setBounds(162, 73, 158, 23);
		add(btnGenerarAleatorio);
		
		JLabel lblFilas = new JLabel("Filas (M):");
		lblFilas.setBounds(20, 42, 51, 14);
		add(lblFilas);
		
		textFieldFilas = new JTextField();
		textFieldFilas.setBounds(81, 39, 40, 20);
		add(textFieldFilas);
		textFieldFilas.setColumns(10);
		
		JLabel lblColumnas = new JLabel("Columnas (N):");
		lblColumnas.setBounds(149, 42, 83, 14);
		add(lblColumnas);
		
		textFieldColumnas = new JTextField();
		textFieldColumnas.setColumns(10);
		textFieldColumnas.setBounds(242, 39, 40, 20);
		add(textFieldColumnas);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 112, 330, 2);
		add(separator);
		
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
