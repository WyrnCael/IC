package aStar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListaAbiertaOrdenada {
	private ArrayList<Nodo> listaNodos;
	
	public ListaAbiertaOrdenada(){
		listaNodos = new ArrayList<Nodo>();
	}
	
	public void addNodo(Nodo nodo){
		listaNodos.add(nodo);
		Collections.sort(listaNodos, new ComparadorDeCostes());
	}
	
	public void removeNodo(Nodo nodo){
		listaNodos.remove(nodo);
	}
	
	public Nodo getPrimero(){
		Nodo aux = listaNodos.get(0);
		listaNodos.remove(0);
		return aux;
	}
	
	public void reset(){
		listaNodos = new ArrayList<Nodo>();
	}
	
	public int size(){
		return listaNodos.size();
	}
	
	public boolean contiene(Nodo nodo){
		return listaNodos.contains(nodo);
	}
	
	private class ComparadorDeCostes implements Comparator<Nodo>{

		@Override
		public int compare(Nodo nodo1, Nodo nodo2) {
			// TODO Auto-generated method stub
			if (nodo1.getCosteDesdeInicio() < nodo2.getCosteDesdeInicio()) return -1;
			else if (nodo1.getCosteDesdeInicio() > nodo2.getCosteDesdeInicio()) return 1;
	        return 0;
		}
	    
	}
}
