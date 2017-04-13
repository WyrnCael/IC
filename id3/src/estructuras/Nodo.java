package estructuras;

import java.util.ArrayList;

public class Nodo {
	private ArrayList<Nodo> hijos;
	private double positivos;
	private double negativos;
	private double num;
	private String nombre;
	
	public Nodo(String nombre){
		hijos = new ArrayList<Nodo>();
		this.positivos = 0;
		this.negativos = 0;
		this.num = 0;
		this.nombre = nombre;
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
}
