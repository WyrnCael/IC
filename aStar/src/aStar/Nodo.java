package aStar;

public class Nodo {
	private TipoNodo tipo;
	private double costeDesdeInicio;
	private int posX;
	private int posY;
	private Nodo nodoPredecesor;
	private int wayPointPos;
	
	public Nodo(TipoNodo tipo, int i, int j){
		this.tipo = tipo;
		this.posX = i;
		this.posY = j;
	}
	
	public boolean isAlcanzable() {
		if(tipo == TipoNodo.ALCANZABLE)
			return true;
		return false;
	}
	
	public boolean isInicio() {
		if(tipo == TipoNodo.INICIO)
			return true;
		return false;
	}
	
	public boolean isDestino() {
		if(tipo == TipoNodo.DESTINO)
			return true;
		return false;
	}
	
	public boolean isCamino() {
		if(tipo == TipoNodo.CAMINO)
			return true;
		return false;
	}
	
	public boolean isWayPoint() {
		if(tipo == TipoNodo.WAYPOINT)
			return true;
		return false;
	}
	
	public void setTipo(TipoNodo tipo){
		this.tipo = tipo;
	}
	
	public TipoNodo getTipo(){
		return this.tipo;
	}

	public double getCosteDesdeInicio() {
		return costeDesdeInicio;
	}

	public void setCosteDesdeInicio(double coste) {
		this.costeDesdeInicio = coste;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public Nodo getNodoPredecesor() {
		return nodoPredecesor;
	}

	public void setNodoPredecesor(Nodo nodoPredecesor) {
		this.nodoPredecesor = nodoPredecesor;
	}

	public int getWayPointPos() {
		return wayPointPos;
	}

	public void setWayPointPos(int wayPointPos) {
		this.wayPointPos = wayPointPos;
	}
}
