package aStar;

import java.util.ArrayList;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class AlgoritmoAEstrella {
	private Mapa mapa;
	private Mapa mapaWayPoints;
	private ListaAbiertaOrdenada listaAbiertaOrdenada;
	private ArrayList<Nodo> listaCerrada;
	
	public AlgoritmoAEstrella(Mapa mapa){
		this.mapa = mapa;
		this.mapaWayPoints = new Mapa(mapa);
		this.listaAbiertaOrdenada = new ListaAbiertaOrdenada();
		this.listaCerrada = new ArrayList<Nodo>();
	}
	
	public Mapa getCamino(){
		double costeH;
		
		listaAbiertaOrdenada.reset();
		this.listaCerrada = new ArrayList<Nodo>();
		
		// Inicializamos la salida
		Nodo inicial = mapaWayPoints.getNodoInicial();
		costeH = funcionH(inicial);
		inicial.setCosteDesdeInicio(0);
		listaAbiertaOrdenada.addNodo(inicial);
		
		// While		
		while(listaAbiertaOrdenada.size() > 0){	
			Nodo nodoActual = listaAbiertaOrdenada.getPrimero();
			this.listaCerrada.add(nodoActual);
			
			if(nodoActual == this.mapaWayPoints.getNodoDestino()){
				return getMapaResueltoWaypoints();
			}
			
			costeH = funcionH(nodoActual);
			ArrayList<Nodo> adyacentesActual = mapaWayPoints.getAdyacentes(nodoActual);
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
	
	public Mapa getCaminoFinal(){
		Nodo destinoFinal = mapaWayPoints.getNodoDestino();
		while(mapaWayPoints.getWayPoints().size() > 0){
			Nodo waypoint = getWayPointMasCercano(mapaWayPoints.getNodoInicial());
			mapaWayPoints.getWayPoints().remove(waypoint);
			waypoint.setTipo(TipoNodo.DESTINO);
			mapaWayPoints.setNodoDestino(waypoint);
			if(getCamino() == null){
				return null;
			} else {
				waypoint.setTipo(TipoNodo.INICIO);
				mapaWayPoints.setNodoInicial(waypoint);
				mapaWayPoints.setNodoDestino(destinoFinal);
			}
		}
		Mapa aux = getCamino();
		if(aux == null){
			return null;
		} else {
			return getMapaResuelto();
		}
	}
	
	private Nodo getWayPointMasCercano(Nodo actual){
		double menorCoste = Double.MAX_VALUE;
		Nodo nodo = null;
		for(Nodo waypoint : mapaWayPoints.getWayPoints()){
			System.out.println("1");
			if(waypoint != actual){
				double fH = funcionHWayPoint(actual, waypoint);
				if(fH < menorCoste){
					menorCoste = fH;
					nodo = waypoint;
				}
			}			
		}
		return nodo;
	}
	
	private Mapa getMapaResueltoWaypoints(){
		Nodo nodoActual = mapaWayPoints.getNodoDestino().getNodoPredecesor();
		while(nodoActual.getNodoPredecesor() != null){
			System.out.println("2" + nodoActual);
			if(!nodoActual.isInicio()){
				nodoActual.setTipo(TipoNodo.CAMINO);
				this.mapa.getCasilla(nodoActual.getPosX(), nodoActual.getPosY()).setTipo(TipoNodo.CAMINO);
			}	
			Nodo aux = nodoActual;
			nodoActual = nodoActual.getNodoPredecesor();
			aux.setNodoPredecesor(null);
		}
		return this.mapaWayPoints;
	}
	
	private Mapa getMapaResuelto(){
		return this.mapa;
	}
	
	private double funcionG(Nodo nodo, Nodo adyacente){
		return nodo.getCosteDesdeInicio() + distanciaEntreActualYAdjacente(nodo, adyacente);
	}
	
	private double funcionH(Nodo nodo){
		Nodo destino = mapaWayPoints.getNodoDestino();
		double g = Math.sqrt( Math.pow((nodo.getPosX() - destino.getPosX()), 2) + Math.pow((nodo.getPosY() - destino.getPosY()), 2));
		return g;
	}
	
	private double funcionHWayPoint(Nodo nodo, Nodo waypoint){
		double g = Math.sqrt( Math.pow((nodo.getPosX() - waypoint.getPosX()), 2) + Math.pow((nodo.getPosY() - waypoint.getPosY()), 2));
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
