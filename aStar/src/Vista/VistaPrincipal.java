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
		contentPane.setLayout(null);
		OptionMenu optionMenu = new OptionMenu();
		optionMenu.setBounds(593, 46, 330, 550);
		getContentPane().add(optionMenu);
		
		JLabel lblMapa = new JLabel("Mapa:");
		lblMapa.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMapa.setBounds(10, 11, 95, 27);
		contentPane.add(lblMapa);
		
		JLabel lblOpciones = new JLabel("Opciones:");
		lblOpciones.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblOpciones.setBounds(583, 11, 95, 27);
		contentPane.add(lblOpciones);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(570, 470, -10, -458);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(570, 0, 2, 610);
		contentPane.add(separator_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 46, 550, 550);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		// Añadiendo tablero
		this.tablero = new Tablero(new Mapa(100,100));
		panel.add(tablero);
		
		this.setSize(950, 650);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public void setMapa(Mapa mapa){
		this.tablero.cambiaMapa(mapa);
		this.revalidate();
		this.repaint();
	}
}
