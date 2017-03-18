package aStar;

import java.util.ArrayList;

public class AlgoritmoAEstrella {
	private Mapa mapa;
	private ListaAbiertaOrdenada listaAbiertaOrdenada;
	private ArrayList<Nodo> listaCerrada;
	
	public AlgoritmoAEstrella(Mapa mapa){
		this.mapa = mapa;
		this.listaAbiertaOrdenada = new ListaAbiertaOrdenada();
		this.listaCerrada = new ArrayList<Nodo>();
	}
	
	public Mapa getCamino(){
		double costeH;
		
		// Inicializamos la salida
		Nodo inicial = mapa.getNodoInicial();
		costeH = funcionH(inicial);
		inicial.setCosteDesdeInicio(0);
		listaAbiertaOrdenada.addNodo(inicial);
		
		// While		
		while(listaAbiertaOrdenada.size() > 0){	
			Nodo nodoActual = listaAbiertaOrdenada.getPrimero();
			this.listaCerrada.add(nodoActual);
			
			if(nodoActual == this.mapa.getNodoDestino()){
				return getMapaResuelto();
			}
			
			costeH = funcionH(nodoActual);
			ArrayList<Nodo> adyacentesActual = mapa.getAdyacentes(nodoActual);
			for(Nodo adyacente : adyacentesActual){
				double costeF, costeG;
				if(!listaCerrada.contains(adyacente)){
					costeG = funcionG(nodoActual, adyacente);
					costeF = costeH + costeG;					
					if(!listaAbiertaOrdenada.contiene(adyacente)){	
						adyacente.setCosteDesdeInicio(costeG);
						adyacente.setNodoPredecesor(nodoActual);
						listaAbiertaOrdenada.addNodo(adyacente);						
					}
					else{
						costeG = funcionG(nodoActual, adyacente);
						double costeFNuevo = costeH + costeG;
						if(costeFNuevo < costeF){
							adyacente.setCosteDesdeInicio(costeG);
							adyacente.setNodoPredecesor(nodoActual);		
						}
					}
				}			
			}				
		}		
		return null;
	}
	
	private Mapa getMapaResuelto(){
		Nodo nodoActual = mapa.getNodoDestino().getNodoPredecesor();
		while(nodoActual.getNodoPredecesor() != null){
			nodoActual.setTipo(TipoNodo.CAMINO);
			nodoActual = nodoActual.getNodoPredecesor();
		}
		return this.mapa;
	}
	
	private double funcionG(Nodo nodo, Nodo adyacente){
		return nodo.getCosteDesdeInicio() + distanciaEntreActualYAdjacente(nodo, adyacente);
	}
	
	private double funcionH(Nodo nodo){
		Nodo destino = mapa.getNodoDestino();
		double g = Math.sqrt( Math.pow((nodo.getPosX() - destino.getPosX()), 2) + Math.pow((nodo.getPosY() - destino.getPosY()), 2));
		return g;
	}
	
	private double distanciaEntreActualYAdjacente(Nodo nodo, Nodo adyacente){
		double d = 0;
		if( (adyacente.getPosX() == nodo.getPosX() && adyacente.getPosY() != nodo.getPosY())
				|| (adyacente.getPosY() == nodo.getPosY() && adyacente.getPosX() != nodo.getPosX())){
			d = 1;
		} else {
			d = Math.sqrt(2);
		}
		return d;
	}
}
