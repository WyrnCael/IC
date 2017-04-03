package estructuras;

import java.util.ArrayList;

public class Ejemplos {
	private ArrayList<Ejemplo> ejemplos;
	
	public Ejemplos(){
		this.ejemplos = new ArrayList<Ejemplo>();
	}

	public ArrayList<Ejemplo> getAtributos() {
		return ejemplos;
	}

	public void setAtributos(ArrayList<Ejemplo> Ejemplo) {
		this.ejemplos = Ejemplo;
	}
	
	public void addAtributo(Ejemplo ejemplo){
		this.ejemplos.add(ejemplo);
	}
}
