package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import javax.swing.JScrollPane;

public class MainWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8685131023948071190L;
	private static MainWindow instance = null;
	private Entropias jEntropias;
	
	public static MainWindow getInstance(){
		if(instance == null)
			instance = new MainWindow();
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
		
		setSize(585, 575);
		setMinimumSize(new Dimension(585, 575));
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public Entropias getPanelEntropias(){
		return jEntropias;
	}

}
