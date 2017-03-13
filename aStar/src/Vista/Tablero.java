package Vista;

import javax.swing.JButton;
import javax.swing.JPanel;

import aStar.Mapa;
import aStar.Nodo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

public class Tablero extends JPanel {

	/**
	 * Create the panel.
	 */
	private JButton[][] casillas;
	private Mapa mapa;
	
	public Tablero(Mapa mapa) {		
		this.mapa = mapa;
		
		onCreate();
	}
	
	private void onCreate(){
		dibujaMapa();	
		
		this.setSize(new Dimension(550, 550));
		this.setPreferredSize(new Dimension(550, 550));
		this.setMinimumSize(new Dimension(550, 550));
		
	}
	
	public void cambiaMapa(Mapa mapa){
		this.mapa = mapa;
		this.removeAll();
		dibujaMapa();
	}
	
	private void dibujaMapa(){
		setLayout(new GridLayout(this.mapa.getFilas(), this.mapa.getColumnas()));
		casillas = new JButton[this.mapa.getFilas()][this.mapa.getColumnas()];
		
		for(int i = 0; i < this.mapa.getFilas(); i++){
			for(int j = 0; j < this.mapa.getColumnas(); j++){
				casillas[i][j] = new JButton();
				/* Desde aqui es una prueba */
				if(i == 1 && j == 1){
					Nodo aux = new Nodo();
					aux.setAlcanzable(false);
					mapa.setCasilla(i, j, aux);
				}		
				
				if(!mapa.getCasilla(i, j).isAlcanzable())
					casillas[i][j].setBackground(Color.BLACK);
				/* Hasta aqui */
				
				this.add(casillas[i][j]);
				
			}
		}
		this.revalidate();
		this.repaint();
	}

}
