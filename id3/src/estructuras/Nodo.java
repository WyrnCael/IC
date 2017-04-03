package estructuras;

import java.util.ArrayList;

public class Nodo {
	private ArrayList<Nodo> hijos;
	
	public Nodo(){
		hijos = new ArrayList<Nodo>();
	}

	public ArrayList<Nodo> getHijos() {
		return hijos;
	}

	public void setHijos(ArrayList<Nodo> hijos) {
		this.hijos = hijos;
	}
	
	public void addHijo(Nodo hijo){
		this.hijos.add(hijo);
	}
}
