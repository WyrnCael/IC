package aStar;

public class Mapa {
	
	private int filas;
	private int columnas;
	private Nodo[][] matriz;
	
	public Mapa(int M, int N){
		this.filas = M;
		this.columnas = N;
		
		matriz = new Nodo[this.filas][this.columnas];
		creaMapaInicial();
	}

	public int getFilas() {
		return filas;
	}

	public void setFilas(int filas) {
		this.filas = filas;
	}

	public int getColumnas() {
		return columnas;
	}

	public void setColumnas(int columnas) {
		this.columnas = columnas;
	}

	public Nodo[][] getMatriz() {
		return matriz;
	}

	public void setMatriz(Nodo[][] matriz) {
		this.matriz = matriz;
	}
	
	public void setCasilla(int fila, int columna, Nodo nodo){
		matriz[fila][columna] = nodo;
	}
	
	public Nodo getCasilla(int fila, int columna){
		return matriz[fila][columna];
	}
	
	private void creaMapaInicial(){
		for(int i = 0; i < this.filas; i++){
			for(int j = 0; j < this.columnas; j++){
				this.matriz[i][j] = new Nodo();
			}
		}
	}
}
