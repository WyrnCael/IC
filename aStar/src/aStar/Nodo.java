package aStar;

public class Nodo {
	private TipoNodo tipo;
	private double coste;
	
	public Nodo(TipoNodo tipo){
		this.tipo = tipo;
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

	public double getCoste() {
		return coste;
	}

	public void setCoste(double coste) {
		this.coste = coste;
	}
	
	
}
