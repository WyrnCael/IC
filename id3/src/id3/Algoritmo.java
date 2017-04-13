package id3;

import java.util.ArrayList;

import datos.Datos;
import estructuras.Atributo;
import estructuras.Ejemplo;
import estructuras.Ejemplos;
import estructuras.Nodo;

public class Algoritmo {
	
	public Algoritmo(){
		
	}
	
	public void getAlgorythm(){
		ArrayList<Atributo> atributos = new ArrayList<Atributo>();
		for(int i = 0; i < Datos.getAtributos().size() - 1; i++)
			atributos.add(new Atributo(Datos.getAtributos().get(i).getNombre()));
		Nodo mejor = rellenaArbol(atributos);		
		System.out.println(mejor.getNombre());
	}
	
	private Nodo rellenaArbol(ArrayList<Atributo> atributos){
		Nodo mejor = null;
		
		// Contar positivos y negativos de cada atributo
		for(int i = 0; i < atributos.size(); i++){
			Nodo arbol = new Nodo(atributos.get(i).getNombre());
			
			int j = 0;
			for(Ejemplos ejs: Datos.getEjemplos()){
				boolean encontrado = false;
				String nombre = ejs.getEjemplos().get(i).getNombre();
				for(Nodo hijo: arbol.getHijos()){					
					if(hijo.getNombre().equals(nombre)){
						encontrado = true;
						setPositivoNegativo(hijo, j);
					}				
				}
				if(!encontrado) {
					Nodo hijoNuevo = new Nodo(nombre);			
					arbol.addHijo(hijoNuevo);
					setPositivoNegativo(hijoNuevo, j);
				}
				j++;
			}
			getEHijos(arbol);
			if(mejor == null)
				mejor = arbol;
			else if (mejor.getEntropia() < arbol.getEntropia())
				mejor = arbol;			
		}
		
		return mejor;
	}
	
	private void recursividadTotal(Nodo mejor, ArrayList<Atributo> atributos){
		ArrayList<Atributo> aux = atributos;
		for(int i = 0; i < atributos.size(); i++)
			aux.add(new Atributo(Datos.getAtributos().get(i).getNombre()));
		//Nodo mejor = rellenaArbol();		
		System.out.println(mejor.getNombre());
	}
	
	private void setPositivoNegativo(Nodo nodo, int i){
		if(Datos.getResultados().get(i).isSePuede()){
			nodo.addPositivo();
		} else {
			nodo.addNegativo();
		}
		nodo.addNum();
	}
	
	private void getEHijos(Nodo arbol){
		double e = 0;
		for(Nodo hijo: arbol.getHijos()){
			e += G(hijo);
		}
		
		System.out.println(arbol.getNombre());
		System.out.println(e);
		arbol.setEntropia(e);
	}
	
	private double G(Nodo nodo){
		double n = nodo.getNegativos() / nodo.getNum();
		double p = nodo.getPositivos() / nodo.getNum();
		double r = nodo.getNum() / Datos.getEjemplos().size();
		
		double entropia = 0;
		
		if(n == 0) {
			entropia = ( -p*((Math.log(p)/Math.log(2)) ));
		}
		else if (p==0) {
			entropia = (- (n*(Math.log(n)/Math.log(2)) ));
		}
		else {
			entropia = ( -p*((Math.log(p)/Math.log(2)) ) - (n*(Math.log(n)/Math.log(2)) ));
		}
		
		return r*entropia;
	}
}
