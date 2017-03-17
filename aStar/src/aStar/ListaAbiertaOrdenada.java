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
		return listaNodos.get(0);
	}
	
	public void reset(){
		listaNodos = new ArrayList<Nodo>();
	}
	
	public int size(){
		return listaNodos.size();
	}
	
	private class ComparadorDeCostes implements Comparator<Nodo>{

		@Override
		public int compare(Nodo nodo1, Nodo nodo2) {
			// TODO Auto-generated method stub
			if (nodo1.getCoste() < nodo2.getCoste()) return -1;
			else if (nodo1.getCoste() > nodo2.getCoste()) return 1;
	        return 0;
		}
	    
	}
}
