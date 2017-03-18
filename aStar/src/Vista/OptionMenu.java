package Vista;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import javax.swing.JTextField;

import aStar.AlgoritmoAEstrella;
import aStar.Mapa;

import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ResourceBundle.Control;

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
	private boolean calculado;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public OptionMenu() {
		calculado = false;
		
		JLabel lblMapa = new JLabel("Generar mapa:");
		lblMapa.setFont(new Font("Tahoma", Font.PLAIN, 23));
		
		JButton btnGenerarVacio = new JButton("Generar vacio");
		
		JButton btnGenerarAleatorio = new JButton("Generar aleatorio");
		
		JLabel lblFilas = new JLabel("Filas (M):");
		
		textFieldFilas = new JTextField("100");
		textFieldFilas.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				textFieldFilas.setText("");
			}
		});
		textFieldFilas.setColumns(10);
		
		JLabel lblColumnas = new JLabel("Columnas (N):");
		
		textFieldColumnas = new JTextField("100");
		textFieldColumnas.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				textFieldColumnas.setText("");
			}
		});
		textFieldColumnas.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		
		JSeparator separator = new JSeparator();
		
		JLabel lblInsertarNuevosElementos = new JLabel("Insertar nuevos elementos:");
		lblInsertarNuevosElementos.setFont(new Font("Tahoma", Font.PLAIN, 23));
		
		JLabel lblInicio = new JLabel("Inicio:");
		lblInicio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnNuevoInicio = new JButton("New button");
		
		JLabel lblDestino = new JLabel("Destino:");
		lblDestino.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnNuevoDestino = new JButton("New button");
		
		JButton btnEvaluate = new JButton("Calcular camino");
		
		JLabel lblObstaculo = new JLabel("Obstaculo:");
		lblObstaculo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnObstaculo = new JButton("New button");
		
		JButton btnReiniciarMapa = new JButton("Borrar camino");
		
		JLabel lblObstaculosAleatorios = new JLabel("Obstaculos aleatorios:");
		lblObstaculosAleatorios.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNumeroDeObstculos = new JLabel("Numero de Obst\u00E1culos:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		
		JLabel lblEliminarObstaculo = new JLabel("Eliminar obstaculo:");
		lblEliminarObstaculo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnRemoveObstaculo = new JButton("New button");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(separator, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 323, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblObstaculo, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnObstaculo, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
							.addGap(174))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGap(4)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblInicio)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnNuevoInicio, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblDestino, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnEvaluate)
										.addComponent(lblNumeroDeObstculos, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
											.addComponent(btnRemoveObstaculo)
											.addComponent(btnReiniciarMapa)))))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton)
								.addComponent(btnNuevoDestino, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)))
						.addGroup(Alignment.TRAILING, groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblFilas, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textFieldFilas, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addGap(28)
								.addComponent(lblColumnas, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textFieldColumnas, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(btnGenerarVacio, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(btnGenerarAleatorio, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)))
						.addComponent(lblObstaculosAleatorios, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMapa, Alignment.TRAILING)
						.addComponent(lblInsertarNuevosElementos, Alignment.TRAILING)
						.addComponent(lblEliminarObstaculo, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(separator_1, GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
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
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnGenerarVacio)
						.addComponent(btnGenerarAleatorio))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(lblInsertarNuevosElementos)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDestino, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNuevoDestino)
						.addComponent(lblInicio)
						.addComponent(btnNuevoInicio))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblObstaculo, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnObstaculo))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblObstaculosAleatorios, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNumeroDeObstculos)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEliminarObstaculo, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnRemoveObstaculo))
					.addPreferredGap(ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEvaluate)
						.addComponent(btnReiniciarMapa))
					.addGap(90))
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
					Mapa mapa = new Mapa();
					mapa.creaMapaVacio(filas, columnas);
					Controlador.getInstance().setMapa(mapa);
					Controlador.getInstance().refreshMapa();
					calculado = false;
				} catch(NumberFormatException nF){
					JOptionPane.showMessageDialog(null, "El campo filas y columnas deben contener dígitos y ser mayor a 0.");
				}
				
			}
		});
		
		btnGenerarAleatorio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try{
					int filas = Integer.valueOf(textFieldFilas.getText());
					int columnas = Integer.valueOf(textFieldColumnas.getText());
					if(filas == 0 || columnas == 0)
						throw new NumberFormatException();
					Mapa mapa = new Mapa();
					mapa.creaMapaAleatorio(filas, columnas);
					Controlador.getInstance().setMapa(mapa);
					Controlador.getInstance().refreshMapa();
					calculado = false;
				} catch(NumberFormatException nF){
					JOptionPane.showMessageDialog(null, "El campo de filas y de columnas deben contener dígitos y ser mayor a 0.", "¡Error!", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		
		btnEvaluate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(Controlador.getInstance().getMapa().getNodoInicial() != null && Controlador.getInstance().getMapa().getNodoDestino() != null){
					Controlador.getInstance().getMapa().resetMapa();
					Controlador.getInstance().refreshMapa();
					AlgoritmoAEstrella algoritmo = new AlgoritmoAEstrella(Controlador.getInstance().getMapa());
					Mapa mapa = algoritmo.getCamino();					
					if(mapa == null){
						JOptionPane.showMessageDialog(null, "No se puede llegar al destino desde el inicio.", "No hay camino", JOptionPane.INFORMATION_MESSAGE);
					}
					else{
						calculado = true;
						Controlador.getInstance().setMapa(mapa);
						Controlador.getInstance().refreshMapa();
					}	
				}
				else if (Controlador.getInstance().getMapa().getNodoInicial() == null){
					JOptionPane.showMessageDialog(null, "¡Falta el nodo inicial!", "Error", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, "¡Falta el nodo destino!", "Error", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		btnNuevoInicio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(calculado){
					JOptionPane.showMessageDialog(null, "El camino ya ha sido calculado, debe generar un nuevo mapa.", "Error", JOptionPane.INFORMATION_MESSAGE);
				}
				else if(Controlador.getInstance().getMapa().getNodoInicial() == null){
					Controlador.getInstance().setBotonInicio(true);
				}
				else {
					if (JOptionPane.showConfirmDialog(null, "Ya existe un nodo inicial, ¿desea eliminarlo y crear uno nuevo?", "¡Atención!",
					        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					    Controlador.getInstance().getMapa().removeNodoInicial();
					    Controlador.getInstance().refreshMapa();
					    Controlador.getInstance().setBotonInicio(true);
					}
				}
			}
		});
		
		btnNuevoDestino.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(calculado){
					JOptionPane.showMessageDialog(null, "El camino ya ha sido calculado, debe generar un nuevo mapa.", "Error", JOptionPane.INFORMATION_MESSAGE);
				}
				else if(Controlador.getInstance().getMapa().getNodoDestino() == null){
					Controlador.getInstance().setBotonDestino(true);
				}
				else {
					if (JOptionPane.showConfirmDialog(null, "Ya existe un nodo de destino, ¿desea eliminarlo y crear uno nuevo?", "¡Atención!",
					        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					    Controlador.getInstance().getMapa().removeNodoDestino();
					    Controlador.getInstance().refreshMapa();
					    Controlador.getInstance().setBotonDestino(true);
					}
				}
			}
		});
		
		btnObstaculo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Controlador.getInstance().getMapa().resetMapa();
				Controlador.getInstance().setBotonObstaculo(true);
			}
		});
		
		btnReiniciarMapa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Controlador.getInstance().getMapa().resetMapa();
				Controlador.getInstance().refreshMapa();
			}
		});
	}
}
