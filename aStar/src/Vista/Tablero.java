package Vista;

import javax.swing.JButton;
import javax.swing.JPanel;

import aStar.Mapa;
import aStar.Nodo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
		
		/*this.setSize(new Dimension(550, 550));
		this.setPreferredSize(new Dimension(550, 550));
		this.setMinimumSize(new Dimension(550, 550));
		this.setMaximumSize(new Dimension(550, 550));*/
		
	}
	
	public void cambiaMapa(Mapa mapa){
		this.mapa = mapa;
		this.removeAll();
		dibujaMapa();
	}
	
	private void dibujaMapa(){
		setLayout(new GridLayout(this.mapa.getFilas(), this.mapa.getColumnas()));
		casillas = new JButton[this.mapa.getFilas()][this.mapa.getColumnas()];
		GridBagConstraints c1 = new GridBagConstraints();
		c1.fill = GridBagConstraints.BOTH;
		c1.anchor = GridBagConstraints.CENTER;
		c1.weightx = 1.0;
		c1.weighty = 1.0;
		
		for(int i = 0; i < this.mapa.getFilas(); i++){
			for(int j = 0; j < this.mapa.getColumnas(); j++){
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
				
				this.add(casillas[i][j], c1);
				
			}
		}
		
		this.revalidate();
		this.repaint();
	}

}
