package aStar;

import java.util.concurrent.ThreadLocalRandom;

public class Mapa {
	
	private int filas;
	private int columnas;
	private Nodo[][] matriz;
	private boolean inicio;
	private boolean destino;
	
	public Mapa(){	}

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
	
	public void creaMapaVacio(int M, int N){
		this.filas = M;
		this.columnas = N;
		this.inicio = false;
		this.destino = false;		
		matriz = new Nodo[this.filas][this.columnas];
		
		for(int i = 0; i < this.filas; i++){
			for(int j = 0; j < this.columnas; j++){
				this.matriz[i][j] = new Nodo(TipoNodo.ALCANZABLE);
			}
		}
	}
	
	public void creaMapaAleatorio(int M, int N, int numObstaculos){
		this.filas = M;
		this.columnas = N;
		this.inicio = false;
		this.destino = false;		
		matriz = new Nodo[this.filas][this.columnas];
		
		for(int i = 0; i < this.filas; i++){
			for(int j = 0; j < this.columnas; j++){
				int randomNum;
				if(!this.inicio){
					randomNum = generaNumeroAleatorio(0, 3);					
				}
				else if (!this.destino){
					randomNum = generaNumeroAleatorio(1, 3);
					
				}				
				else{
					randomNum = generaNumeroAleatorio(2, 3);
				}
				this.matriz[i][j] = new Nodo(TipoNodo.values()[randomNum]);
				asignacion(TipoNodo.values()[randomNum]);
			}
		}
	}
	
	private void asignacion(TipoNodo tipo){
		System.out.println(tipo);
		if(tipo == TipoNodo.INICIO){
			this.inicio = true;
		}
		else if (tipo == TipoNodo.DESTINO){
			this.destino = true;
		}
	}
	
	private int generaNumeroAleatorio(int minimo,int maximo){
        
       int num=(int)Math.floor(Math.random()*(maximo-minimo+1)+(minimo));
       return num;
   }
}
