package vista.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Datos.Datos;
import Lectura.ReadEjemplos;

import javax.swing.JTabbedPane;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JPKMedias jpKMedias;
	private JPBayes jpBayes;
	private JPLloyd jpLloyd;
	private JPSom jpSom;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Cambiar
					ReadEjemplos.read();
					
					MainWindow frame = new MainWindow();
					frame.setSize(900, 600);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		super("M�todos de clasificaci�n - Juan Jos� Prieto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		jpKMedias = new JPKMedias();
		jpBayes = new JPBayes();
		jpLloyd = new JPLloyd();
		jpSom = new JPSom();
		
		JTabbedPane tabbedPane = new JTabbedPane();		
		tabbedPane.add("K-Medias", jpKMedias);
		tabbedPane.add("Bayes", jpBayes);
		tabbedPane.add("Lloyd", jpLloyd);
		tabbedPane.add("SOM", jpSom);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		tabbedPane.addChangeListener(new ChangeListener() {
	        @Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
	        	jpKMedias.refresh();
	        	jpBayes.refresh();
	        	jpLloyd.refresh();
	        	jpSom.refresh();
			}
	    });
	}

}
