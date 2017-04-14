package estructuras;

import java.util.ArrayList;

public class Nodo {
	private ArrayList<Nodo> hijos;
	private double positivos;
	private double negativos;
	private double num;
	private double entropia;
	private String nombre;
	private ArrayList<Ejemplos> ejemplos;
	
	public Nodo(String nombre){
		hijos = new ArrayList<Nodo>();
		this.positivos = 0;
		this.negativos = 0;
		this.num = 0;
		this.nombre = nombre;
		this.entropia = 0;
		this.ejemplos = new ArrayList<Ejemplos>();
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

	public double getPositivos() {
		return positivos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPositivos(int positivos) {
		this.positivos = positivos;
	}
	
	public void addPositivo(){
		this.positivos++;
	}

	public double getNegativos() {
		return negativos;
	}

	public void setNegativos(int negativos) {
		this.negativos = negativos;
	}
	
	public void addNegativo(){
		this.negativos++;
	}

	public double getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	public void addNum(){
		this.num++;
	}

	public double getEntropia() {
		return entropia;
	}

	public void setEntropia(double entropia) {
		this.entropia = entropia;
	}

	public ArrayList<Ejemplos> getEjemplos() {
		return ejemplos;
	}

	public void setEjemplos(ArrayList<Ejemplos> ejemplos) {
		this.ejemplos = ejemplos;
	}
	
	public void addEjemplos(Ejemplos ejemplos){
		this.ejemplos.add(ejemplos);
	}
}
