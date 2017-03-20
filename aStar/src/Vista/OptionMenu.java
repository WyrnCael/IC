package Vista;

import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JTextField;

import aStar.AlgoritmoAEstrella;
import aStar.Mapa;

import javax.swing.JButton;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.JSeparator;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import java.awt.Component;
import javax.swing.UIManager;

public class OptionMenu extends JPanel {
	private JTextField textFieldFilas;
	private JTextField textFieldColumnas;
	private boolean calculado;
	private JTextField textFieldObstAleatorios;

	/**
	 * Create the panel.
	 */
	public OptionMenu() {
		calculado = false;
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.X_AXIS));
		
		JLabel lblOpciones = new JLabel("Opciones:");
		lblOpciones.setBorder(new EmptyBorder(0, 0, 15, 0));
		lblOpciones.setFont(new Font("Dialog", Font.BOLD, 23));
		panel_6.add(lblOpciones);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder("Generar mapa: "));
		panel_3.setMinimumSize(new Dimension(250, 110));
		panel_1.add(panel_3);
		
		JLabel lblFilas = new JLabel("Filas (M):");
		
		textFieldFilas = new JTextField("20");
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
		
		textFieldColumnas = new JTextField("20");
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
		
		JButton btnGenerarVacio = new JButton("Generar vacio");
		
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
		
		JButton btnGenerarAleatorio = new JButton("Aleatorio");
		
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
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(12)
							.addComponent(btnGenerarVacio)
							.addGap(12)
							.addComponent(btnGenerarAleatorio, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_3.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblFilas)
							.addGap(3)
							.addComponent(textFieldFilas, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(lblColumnas)
							.addGap(4)
							.addComponent(textFieldColumnas, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(14)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(2)
							.addComponent(lblFilas))
						.addComponent(textFieldFilas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(2)
							.addComponent(lblColumnas))
						.addComponent(textFieldColumnas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addComponent(btnGenerarVacio)
						.addComponent(btnGenerarAleatorio))
					.addGap(5))
		);
		panel_3.setLayout(gl_panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder("Añadir/modificar elementos: "));
		panel_1.add(panel_4);
		
		JLabel lblInicio = new JLabel("Inicio:");
		lblInicio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnNuevoInicio = new JButton();
		btnNuevoInicio.setMargin(new Insets(0, 0, 0, 0));
		btnNuevoInicio.setBackground(Color.BLUE);
		try {
			Image image = ImageIO.read(getClass().getResource("barco.png"));
			BufferedImage img = TratadoImagen.toCompatibleImage((BufferedImage) image);
			ImageIcon icon = new ImageIcon(img);
			btnNuevoInicio.setIcon(icon);
			TratadoImagen.resizeImage(btnNuevoInicio, img);
			btnNuevoInicio.addComponentListener(new ComponentAdapter() {

                @Override
                public void componentResized(ComponentEvent e) {
                    JButton btn = (JButton) e.getComponent();
                    TratadoImagen.resizeImage(btn, img);
                }

            });
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		btnNuevoInicio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(Controlador.getInstance().getMapa().getNodoInicial() == null){
					Controlador.getInstance().setBotonInicio(true);
				}
				else {
					if (JOptionPane.showConfirmDialog(null, "Ya existe un nodo inicial, ¿desea eliminarlo y crear uno nuevo?", "¡Atención!",
					        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						Controlador.getInstance().getMapa().resetMapa();
					    Controlador.getInstance().getMapa().removeNodoInicial();
					    Controlador.getInstance().refreshMapa();
					    Controlador.getInstance().setBotonInicio(true);
					}
				}
			}
		});
		
		JLabel lblDestino = new JLabel("Destino:");
		lblDestino.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnNuevoDestino = new JButton("");
		btnNuevoDestino.setMargin(new Insets(0, 0, 0, 0));
		btnNuevoDestino.setBackground(Color.BLUE);
		try {
			Image image = ImageIO.read(getClass().getResource("moby_dick.png"));
			BufferedImage img = TratadoImagen.toCompatibleImage((BufferedImage) image);
			ImageIcon icon = new ImageIcon(img);
			btnNuevoDestino.setIcon(icon);
			TratadoImagen.resizeImage(btnNuevoDestino, img);
			btnNuevoDestino.addComponentListener(new ComponentAdapter() {

                @Override
                public void componentResized(ComponentEvent e) {
                    JButton btn = (JButton) e.getComponent();
                    TratadoImagen.resizeImage(btn, img);
                }

            });
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		btnNuevoDestino.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(Controlador.getInstance().getMapa().getNodoDestino() == null){
					Controlador.getInstance().setBotonDestino(true);
				}
				else {
					if (JOptionPane.showConfirmDialog(null, "Ya existe un nodo de destino, ¿desea eliminarlo y crear uno nuevo?", "¡Atención!",
					        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						Controlador.getInstance().getMapa().resetMapa();
					    Controlador.getInstance().getMapa().removeNodoDestino();
					    Controlador.getInstance().refreshMapa();
					    Controlador.getInstance().setBotonDestino(true);
					}
				}
			}
		});
		
		JLabel lblObstaculo = new JLabel("Obstáculos:");
		lblObstaculo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnObstaculo = new Tablero.Obstaculo();
		
		btnObstaculo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Controlador.getInstance().getMapa().resetMapa();
				Controlador.getInstance().setBotonObstaculo(true);
			}
		});		
		
		JLabel lblEliminarObstaculo = new JLabel("Eliminar obstáculos:");
		lblEliminarObstaculo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnRemoveObstaculo = new JButton("");
		btnRemoveObstaculo.setBackground(Color.BLUE);
		
		btnRemoveObstaculo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Controlador.getInstance().getMapa().resetMapa();
				Controlador.getInstance().setBotonAlcanzable(true);
			}
		});
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder("Generar obstáculos aleatorios: "));
		
		JLabel lblWayPoint = new JLabel("Way point:");
		lblWayPoint.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnWayPoint = new JButton("");
		btnWayPoint.setMargin(new Insets(0, 0, 0, 0));
		btnWayPoint.setBackground(Color.BLUE);
		try {
			Image image = ImageIO.read(getClass().getResource("fish.png"));
			BufferedImage img = TratadoImagen.toCompatibleImage((BufferedImage) image);
			ImageIcon icon = new ImageIcon(img);
			btnWayPoint.setIcon(icon);
			TratadoImagen.resizeImage(btnWayPoint, img);
			btnWayPoint.addComponentListener(new ComponentAdapter() {

                @Override
                public void componentResized(ComponentEvent e) {
                    JButton btn = (JButton) e.getComponent();
                    TratadoImagen.resizeImage(btn, img);
                }

            });
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		btnWayPoint.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Controlador.getInstance().setBotonWayPoint(true);
			}
		});
		
		
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(lblObstaculo)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnObstaculo, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(lblInicio)
							.addGap(6)
							.addComponent(btnNuevoInicio, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblDestino)
							.addGap(2)
							.addComponent(btnNuevoDestino, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap(14, Short.MAX_VALUE)
					.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(lblWayPoint, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnWayPoint, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblEliminarObstaculo))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnRemoveObstaculo, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(15))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNuevoInicio, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNuevoDestino, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addGap(23)
							.addComponent(lblDestino))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addGap(22)
							.addComponent(lblInicio)))
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addGap(18)
							.addComponent(btnObstaculo, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addGap(30)
							.addComponent(lblObstaculo)))
					.addGap(18)
					.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(lblEliminarObstaculo)
							.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel_4.createSequentialGroup()
									.addGap(29)
									.addComponent(btnWayPoint, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.TRAILING, gl_panel_4.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblWayPoint, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
									.addGap(14))))
						.addComponent(btnRemoveObstaculo, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
					.addGap(22))
		);
		
		JLabel lblNumeroDeObstculos = new JLabel("Numero de Obstáculos:");
		lblNumeroDeObstculos.setFont(new Font("Dialog", Font.PLAIN, 12));
		panel_5.add(lblNumeroDeObstculos);
		
		textFieldObstAleatorios = new JTextField();
		panel_5.add(textFieldObstAleatorios);
		textFieldObstAleatorios.setColumns(10);
		
		JButton btnGenerarObstAleatorios = new JButton("Generar");
		panel_5.add(btnGenerarObstAleatorios);
		panel_4.setLayout(gl_panel_4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder("Ejecución: "));
		panel_2.setMinimumSize(new Dimension(250, 120));
		panel_2.setPreferredSize(new Dimension(250, 120));
		panel_1.add(panel_2);
		
		JButton btnReiniciarMapa = new JButton("Borrar camino");
		btnReiniciarMapa.setBackground(new Color(255, 102, 102));
		
		JButton btnEvaluate = new JButton("Calcular camino");
		btnEvaluate.setBackground(new Color(153, 204, 153));
		
		btnEvaluate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(Controlador.getInstance().getMapa().getNodoInicial() != null && Controlador.getInstance().getMapa().getNodoDestino() != null){
					Controlador.getInstance().getMapa().resetMapa();
					Controlador.getInstance().refreshMapa();
					AlgoritmoAEstrella algoritmo = new AlgoritmoAEstrella(Controlador.getInstance().getMapa());
					Mapa mapa = algoritmo.getCaminoFinal();					
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
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap(57, Short.MAX_VALUE)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(12)
							.addComponent(btnReiniciarMapa))
						.addComponent(btnEvaluate, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
					.addGap(50))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnEvaluate)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnReiniciarMapa)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		
		btnReiniciarMapa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Controlador.getInstance().getMapa().resetMapa();
				Controlador.getInstance().refreshMapa();
			}
		});
		
		btnGenerarObstAleatorios.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Controlador.getInstance().getMapa().resetMapa();
				try{
					int numObstaculos = Integer.valueOf(textFieldObstAleatorios.getText());
					if(numObstaculos > Controlador.getInstance().getMapa().getPosicionesAlcanzables())
						throw new NumberFormatException();
					Controlador.getInstance().getMapa().generarObstaculosAleatorios(numObstaculos);
					Controlador.getInstance().refreshMapa();
				} catch(NumberFormatException nF){
					JOptionPane.showMessageDialog(null, "El número de obstaculos debe de ser un número e inferior a las posiciones alcanzables.");
				}				
			}
		});
		
		this.setMaximumSize(new Dimension(254, 1080));
		this.setPreferredSize(new Dimension(254, 550));
		this.setMinimumSize(new Dimension(254, 1080));
		setLayout(new BorderLayout(0, 0));
		add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.add(panel_1);
		
		JSeparator separator_1 = new JSeparator();
		add(separator_1, BorderLayout.WEST);
		separator_1.setOrientation(SwingConstants.VERTICAL);
	}
}