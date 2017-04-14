package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ResourceBundle.Control;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import estructuras.Nodo;
import id3.Algoritmo;
import lecturaFicheros.ReadAtributos;
import lecturaFicheros.ReadEjemplos;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private static MainWindow instance = null;
	private Entropias jEntropias;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {	
		
		ReadAtributos.read();
		ReadEjemplos.read();
		
		Algoritmo alg = new Algoritmo();
		Nodo arbol = alg.getAlgorythm();
		
		Controlador.getInstance().setArbol(arbol);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					instance = frame;
					frame.setSize(1250, 800);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static MainWindow getInstance(){
		return instance;
	}

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		super("ID3 - Juan José Prieto");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		
		getContentPane().setLayout(new BorderLayout());
		
		GraphEditor Graph = new GraphEditor(Controlador.getInstance().getArbol());
		JScrollPane jscroll = new JScrollPane(Graph);
		jscroll.setBorder(new TitledBorder("Árbol de decisión:"));
		getContentPane().add(jscroll, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		jEntropias = new Entropias();
		panel.add(jEntropias, BorderLayout.CENTER);
		
		BuscarSolucion panel_1 = new BuscarSolucion();
		panel.add(panel_1, BorderLayout.LINE_END);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Controlador.getInstance().setEntropias(Controlador.getInstance().getArbol());
			}
		});		
	}
	
	public Entropias getPanelEntropias(){
		return jEntropias;
	}

}
