package GUI;

import java.awt.Font;
import java.awt.font.TextAttribute;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JLabel;

import datos.Datos;
import estructuras.Atributo;
import estructuras.AtributoEntropia;
import estructuras.Ejemplo;
import estructuras.Nodo;

public class Controlador {
	private static Controlador instance = null;
	private Nodo arbol;
	
	public Controlador(){
		
	}
	
	public static Controlador getInstance(){
		if(instance == null)
			instance = new Controlador();
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
				texto.setFont(new Font("Tahoma", Font.BOLD, 14));
			else{
				texto.setFont(new Font("Tahoma", Font.PLAIN, 14));
			}
			jEntropias.addLabel(texto);
		}
		jEntropias.addLabel(new JLabel(" "));
		jEntropias.revalidate();
		jEntropias.repaint();
	}

	public Nodo getArbol() {
		return arbol;
	}

	public void setArbol(Nodo arbol) {
		this.arbol = arbol;
	}
	
	public String compruebaDatos(ArrayList<Ejemplo> datos){
		String aux = encuentraSolucion(arbol, datos);
		return encuentraSolucion(arbol, datos);
	}
	
	private String encuentraSolucion(Nodo nodo, ArrayList<Ejemplo> datos){
		if(nodo.getNombre().equals("SI")){
			return "SI";
		} else if (nodo.getNombre().equals("NO")){
			return "NO";
		} else {
			int index = -1;
			for(Atributo atr: Datos.getAtributos()){
				if(atr.getNombre().equals(nodo.getNombre())){
					index = Datos.getAtributos().indexOf(atr);
				}
			}
			
			int i = 0;
			while(i < nodo.getHijos().size() && !datos.get(index).getNombre().equals(nodo.getHijos().get(i).getNombre())){				
				i++;
			}
			if(i >= nodo.getHijos().size())
				return "INDETERMINADO";
			else
				return encuentraSolucion(nodo.getHijos().get(i).getHijos().get(0), datos);
		}			
	}
}
