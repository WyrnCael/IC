package id3;

import java.util.ArrayList;

import datos.Datos;
import estructuras.Atributo;
import estructuras.AtributoEntropia;
import estructuras.Ejemplo;
import estructuras.Ejemplos;
import estructuras.Nodo;

public class Algoritmo {
	
	public Algoritmo(){
		
	}
	
	public Nodo getAlgorythm(){
		ArrayList<Atributo> atributos = new ArrayList<Atributo>();
		for(int i = 0; i < Datos.getAtributos().size() - 1; i++)
			atributos.add(new Atributo(Datos.getAtributos().get(i).getNombre()));
		Nodo mejor = rellenaArbol(atributos);		
		System.out.println(mejor.getNombre());
		recursividadTotal(mejor, atributos);
		
		System.out.println("------------");
		pintaArbol(mejor);
		return mejor;
	}
	
	private Nodo rellenaArbol(ArrayList<Atributo> atributos){
		Nodo mejor = null;
		
		// Contar positivos y negativos de cada atributo
		for(int i = 0; i < atributos.size(); i++){
			Nodo arbol = new Nodo(atributos.get(i).getNombre());
			
			for(Ejemplos ejs: Datos.getEjemplos()){
				boolean encontrado = false;
				String nombre = ejs.getEjemplos().get(i).getNombre();
				for(Nodo hijo: arbol.getHijos()){					
					if(hijo.getNombre().equals(nombre)){
						encontrado = true;
						setPositivoNegativo(hijo, ejs.getEjemplos().get(i).getPos());
						hijo.addEjemplos(ejs);
					}				
				}
				if(!encontrado) {
					Nodo hijoNuevo = new Nodo(nombre);			
					arbol.addHijo(hijoNuevo);
					setPositivoNegativo(hijoNuevo, ejs.getEjemplos().get(i).getPos());
					hijoNuevo.addEjemplos(ejs);
				}
			}
			getEHijos(arbol);
			if(mejor == null){
				mejor = arbol;
				mejor.addAtributosentorpias(new AtributoEntropia(arbol.getNombre(), arbol.getEntropia()));
			}
			else{
				mejor.addAtributosentorpias(new AtributoEntropia(arbol.getNombre(), arbol.getEntropia()));
			}			
			if (mejor.getEntropia() > arbol.getEntropia()){
				arbol.setAtributosentorpias(mejor.getAtributosentorpias());
				mejor = arbol;			
			}	
		}
		
		return mejor;
	}
	
	private void recursividadTotal(Nodo mejor, ArrayList<Atributo> atributos){
		ArrayList<Atributo> aux = new ArrayList<Atributo>();
		System.out.println("");
		System.out.println("Nueva recursion " + mejor.getNombre());
		
		if(atributos.size() == 1){
			for(Nodo hijo: mejor.getHijos()){
				System.out.println("");
				System.out.println("Nueva recursion hijo " + hijo.getNombre());
				if(hijo.getPositivos() > 0 && hijo.getNegativos() == 0){
					hijo.addHijo(new Nodo("SI"));
					System.out.println("SI");
				} else if (hijo.getNegativos() > 0 && hijo.getPositivos() == 0){
					hijo.addHijo(new Nodo("NO"));
					System.out.println("NO");
				} 
			}		
		}
		else{
			// Quitamos el mejor anterior
			int nAtr = -1;
			for(int i = 0; i < atributos.size(); i++){
				if(atributos.get(i).getNombre().equals(mejor.getNombre()))
					nAtr = i;
				else
					aux.add(new Atributo(atributos.get(i).getNombre()));
			}
			
			for(Nodo hijo: mejor.getHijos()){
				for(int i = 0; i < hijo.getEjemplos().size(); i++){
					for(int j = 0; j < hijo.getEjemplos().get(i).getEjemplos().size(); j++){
						if(j == nAtr){
							hijo.getEjemplos().get(i).getEjemplos().remove(j);
						}
					}
				}
				
				System.out.println("");
				System.out.println("Nueva recursion hijo " + hijo.getNombre());
					
				if(hijo.getPositivos() > 0 && hijo.getNegativos() == 0){
					hijo.addHijo(new Nodo("SI"));
					System.out.println("SI");
				} else if (hijo.getNegativos() > 0 && hijo.getPositivos() == 0){
					hijo.addHijo(new Nodo("NO"));
					System.out.println("NO");
				} else {	
					Nodo nuevoMejor = rellenaArbolRecursividad(hijo, aux);		
					hijo.addHijo(nuevoMejor);
					System.out.println(nuevoMejor.getNombre());
					recursividadTotal(nuevoMejor, aux);
				}	
			}		
		}		
	}
	
	private Nodo rellenaArbolRecursividad(Nodo actual, ArrayList<Atributo> atributos){
		Nodo mejor = null;
		
		// Contar positivos y negativos de cada atributo
		for(int i = 0; i < atributos.size(); i++){
			Nodo arbol = new Nodo(atributos.get(i).getNombre());
			
			for(Ejemplos ejs: actual.getEjemplos()){
				boolean encontrado = false;
				String nombre = ejs.getEjemplos().get(i).getNombre();
				for(Nodo hijo: arbol.getHijos()){					
					if(hijo.getNombre().equals(nombre)){
						encontrado = true;
						setPositivoNegativo(hijo, ejs.getEjemplos().get(i).getPos());
						hijo.addEjemplos(ejs);
					}				
				}
				if(!encontrado) {
					Nodo hijoNuevo = new Nodo(nombre);			
					arbol.addHijo(hijoNuevo);
					setPositivoNegativo(hijoNuevo, ejs.getEjemplos().get(i).getPos());
					hijoNuevo.addEjemplos(ejs);
				}
			}	
			getEHijos(arbol);
			if(mejor == null){
				mejor = arbol;
				mejor.addAtributosentorpias(new AtributoEntropia(atributos.get(i).getNombre(), arbol.getEntropia()));
			}
			else{
				mejor.addAtributosentorpias(new AtributoEntropia(atributos.get(i).getNombre(), arbol.getEntropia()));
			}			
			if (mejor.getEntropia() > arbol.getEntropia()){
				arbol.setAtributosentorpias(mejor.getAtributosentorpias());
				mejor = arbol;			
			}
		}
		
		return mejor;
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
	
	private void pintaArbol(Nodo origen){
		System.out.println("");
		System.out.println("Origen: " + origen.getNombre());
		for(Nodo hijo : origen.getHijos()){
			System.out.println(hijo.getNombre());
			pintaArbol(hijo);
		}
	}
}
