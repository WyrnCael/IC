package Vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import aStar.Mapa;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class VistaPrincipal extends JFrame {

	private JPanel contentPane;
	private static VistaPrincipal instance;
	private Tablero tablero;

	public static VistaPrincipal getInstance(){
		if(instance == null)
			instance = new VistaPrincipal();
		return instance;
	}

	/**
	 * Create the frame.
	 */
	public VistaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		OptionMenu optionMenu = new OptionMenu();		
		getContentPane().add(optionMenu, BorderLayout.EAST);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		// Añadiendo tablero
		Mapa mapa = new Mapa();
		mapa.creaMapaVacio(20, 20);
		Controlador.getInstance().setMapa(mapa);
		this.tablero = new Tablero();
		this.tablero.setBorder(new EmptyBorder(0, 1, 0, 1));
		panel.add(tablero);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.NORTH);
		
		JLabel lblMapa_1 = new JLabel("Mapa:");
		lblMapa_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblMapa_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addComponent(lblMapa_1, GroupLayout.DEFAULT_SIZE, 1377, Short.MAX_VALUE)
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addComponent(lblMapa_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
		);
		panel_1.setLayout(gl_panel_1);
		
		this.setSize(1071, 698);
		this.setMinimumSize(new Dimension(1071, 698));
		this.setLocationRelativeTo(null);
		//this.setExtendedState( this.getExtendedState()|JFrame.MAXIMIZED_BOTH );
		this.setVisible(true);
	}
	
	public void refreshMapa(){
		this.tablero.dibujaMapa();
	}
}
