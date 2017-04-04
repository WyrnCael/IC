package estructuras;

import java.util.ArrayList;

public class Nodo {
	private ArrayList<Nodo> hijos;
	private int positivos;
	private int negativos;
	
	public Nodo(){
		hijos = new ArrayList<Nodo>();
		this.positivos = 0;
		this.negativos = 0;
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

	public int getPositivos() {
		return positivos;
	}

	public void setPositivos(int positivos) {
		this.positivos = positivos;
	}
	
	public void addPositivo(){
		this.positivos++;
	}

	public int getNegativos() {
		return negativos;
	}

	public void setNegativos(int negativos) {
		this.negativos = negativos;
	}
	
	public void addNegativo(){
		this.negativos++;
	}
}
