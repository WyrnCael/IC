package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import aStar.Mapa;

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
		contentPane.setLayout(new GridLayout(1, 2));
		setContentPane(contentPane);
		
		// Añadiendo tablero
		this.tablero = new Tablero(new Mapa(50,30));
		this.add(tablero);
		this.add(new OptionMenu());
		
		this.setSize(800, 800);
		this.setVisible(true);
	}
	
	public void setMapa(Mapa mapa){
		this.tablero.cambiaMapa(mapa);
		this.tablero.revalidate();
		this.tablero.repaint();
	}

}
