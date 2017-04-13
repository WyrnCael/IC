package estructuras;

import java.util.ArrayList;

public class Ejemplos {
	private ArrayList<Ejemplo> ejemplos;
	
	public Ejemplos(){
		this.ejemplos = new ArrayList<Ejemplo>();
	}

	public ArrayList<Ejemplo> getEjemplos() {
		return ejemplos;
	}

	public void setEjemplos(ArrayList<Ejemplo> Ejemplo) {
		this.ejemplos = Ejemplo;
	}
	
	public void addEjemplo(Ejemplo ejemplo){
		this.ejemplos.add(ejemplo);
	}
}
