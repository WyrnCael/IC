package id3;

import datos.Datos;
import estructuras.Atributo;
import estructuras.Ejemplo;
import estructuras.Ejemplos;
import estructuras.Nodo;

public class Algoritmo {

	public Algoritmo(){
		
	}
	
	public void getAlgorythm(){
		
		// Contar positivos y negativos de cada atributo
		for(int i = 0; i < Datos.getAtributos().size() - 1; i++){
			Nodo arbol = new Nodo(Datos.getAtributos().get(i).getNombre());
			
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
		}
		
		
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
		
		System.out.println(e);
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
