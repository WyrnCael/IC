package Vista;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import aStar.Mapa;
import aStar.Nodo;
import aStar.TipoNodo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tablero extends JPanel {

	/**
	 * Create the panel.
	 */
	private JButton[][] casillas;
	
	public Tablero() {	
		
		onCreate();
	}
	
	private void onCreate(){
		dibujaMapa();	
		
		/*this.setSize(new Dimension(550, 550));
		this.setPreferredSize(new Dimension(550, 550));
		this.setMinimumSize(new Dimension(550, 550));
		this.setMaximumSize(new Dimension(550, 550));*/
		
	}
	
	public void dibujaMapa(){
		this.removeAll();
		Mapa mapa = Controlador.getInstance().getMapa();
		setLayout(new GridLayout(mapa.getFilas(), mapa.getColumnas()));
		casillas = new JButton[mapa.getFilas()][mapa.getColumnas()];
		GridBagConstraints c1 = new GridBagConstraints();
		c1.fill = GridBagConstraints.BOTH;
		c1.anchor = GridBagConstraints.CENTER;
		c1.weightx = 1.0;
		c1.weighty = 1.0;
		
		for(int i = 0; i < mapa.getFilas(); i++){
			for(int j = 0; j < mapa.getColumnas(); j++){
				c1.gridx = j;
				c1.gridy = i;
				
				casillas[i][j] = new JButton();
				
				if(mapa.getCasilla(i, j).isInicio())
					casillas[i][j].setBackground(Color.GREEN);
				else if(mapa.getCasilla(i, j).isDestino())
					casillas[i][j].setBackground(Color.BLACK);
				else if(mapa.getCasilla(i, j).isAlcanzable())
					casillas[i][j].setBackground(Color.BLUE);
				else if(mapa.getCasilla(i, j).isCamino())
						casillas[i][j].setBackground(Color.YELLOW);
				else
					casillas[i][j].setBackground(Color.RED);
				
				casillas[i][j].setBorder(null);
				
				casillas[i][j].addActionListener(new ActionListcasilla(i, j));
				
				this.add(casillas[i][j], c1);
				
			}
		}
		
		this.revalidate();
		this.repaint();
	}
	
	private class ActionListcasilla implements ActionListener {
	    private int i;
	    private int j;

	    public ActionListcasilla(int i, int j) {
	        this.i = i;
	        this.j = j;
	    }

	    public void actionPerformed(ActionEvent e) {
	        if(Controlador.getInstance().isBotonInicio()){
	        	Controlador.getInstance().getMapa().setNodoInicial(new Nodo(TipoNodo.INICIO, i, j));
	        	casillas[i][j].setBackground(Color.GREEN);
	        	Controlador.getInstance().setBotonInicio(false);
	        }
	        else if(Controlador.getInstance().isBotonDestino()){
	        	Controlador.getInstance().getMapa().setNodoDestino(new Nodo(TipoNodo.DESTINO, i, j));
	        	casillas[i][j].setBackground(Color.BLACK);
	        	Controlador.getInstance().setBotonDestino(false);
	        }
	        else if(Controlador.getInstance().isBotonObstaculo()){
	        	if(Controlador.getInstance().getMapa().getNodo(i, j).isDestino()){
	        		if (JOptionPane.showConfirmDialog(null, "¿Desea elimimar el nodo destino y cambiarlo por un obstaculo?", "¡Atención!",
					        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					    Controlador.getInstance().getMapa().removeNodoDestino();
					    Controlador.getInstance().getMapa().setNodo(i, j, TipoNodo.INALCANZABLE);
			        	casillas[i][j].setBackground(Color.RED);
					}
	        	}
	        	else if(Controlador.getInstance().getMapa().getNodo(i, j).isInicio()){
	        		if (JOptionPane.showConfirmDialog(null, "¿Desea elimimar el nodo incial y cambiarlo por un obstaculo?", "¡Atención!",
					        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					    Controlador.getInstance().getMapa().removeNodoInicial();
					    Controlador.getInstance().getMapa().setNodo(i, j, TipoNodo.INALCANZABLE);
					    casillas[i][j].setBackground(Color.RED);
					}
	        	}
	        	else{
	        		Controlador.getInstance().getMapa().setNodo(i, j, TipoNodo.INALCANZABLE);
				    casillas[i][j].setBackground(Color.RED);
	        	}
	        	
	        }
	        revalidate();
			repaint();
	    }
	}


}
