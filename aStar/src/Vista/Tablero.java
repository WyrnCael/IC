package Vista;

import javax.swing.JButton;
import javax.swing.JPanel;

import aStar.Nodo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

public class Tablero extends JPanel {

	/**
	 * Create the panel.
	 */
	private int rows;
	private int cols;
	private JButton[][] casillas;
	
	public Tablero(int rows, int cols) {		
		this.rows = rows;
		this.cols = cols;
		
		setLayout(new GridLayout(this.rows, this.cols, 0, 0));	
		onCreate();
	}
	
	private void onCreate(){
		Nodo[][] matriz = new Nodo[this.rows][this.cols];
		casillas = new JButton[this.rows][this.cols];
		
		// matriz[1][0].setAlcanzable(false);
		
		for(int i = 0; i < this.rows; i++){
			for(int j = 0; j < this.cols; j++){
				matriz[i][j] = new Nodo();
				casillas[i][j] = new JButton();
				if(i == 1 && j == 1)
					matriz[i][j].setAlcanzable(false);
				
				if(!matriz[i][j].isAlcanzable())
					casillas[i][j].setBackground(Color.BLACK);
				
				this.add(casillas[i][j]);
				
			}
		}
		
		this.setSize(new Dimension(100, 100));
		this.setPreferredSize(new Dimension(100, 100));
		this.setMaximumSize(new Dimension(100, 100));
		this.setMinimumSize(new Dimension(100, 100));
	}

}
