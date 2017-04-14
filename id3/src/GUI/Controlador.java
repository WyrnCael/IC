package GUI;

import java.awt.Font;
import java.awt.font.TextAttribute;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JLabel;

import estructuras.AtributoEntropia;
import estructuras.Nodo;

public class Controlador {
	private static Controlador instance = null;
	
	public Controlador(){
		
	}
	
	public static Controlador getInstance(){
		if(instance == null)
			return new Controlador();
		else
			return instance;
	}
	
	public void setEntropias(Nodo nodo){
		Entropias jEntropias = MainWindow.getInstance().getPanelEntropias();
		jEntropias.removeAll();
		DecimalFormat df = new DecimalFormat("#.####");
		df.setRoundingMode(RoundingMode.CEILING);
		for(AtributoEntropia atr: nodo.getAtributosentorpias()){
			JLabel texto = new JLabel("  " + atr.getNombre() + ": " + df.format(atr.getEntropia()));
			if(nodo.getNombre().equals(atr.getNombre())) 
				texto.setFont(new Font("Courier New", Font.BOLD, 15));
			else{
				texto.setFont(new Font("Courier New", Font.PLAIN, 14));
			}
			jEntropias.addLabel(texto);
		}
		jEntropias.addLabel(new JLabel(" "));
		jEntropias.revalidate();
		jEntropias.repaint();
	}
}
