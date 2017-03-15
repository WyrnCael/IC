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
		
		int inicioI = generaNumeroAleatorio(0, this.filas - 1);
		int inicioJ = generaNumeroAleatorio(0, this.columnas - 1);
		int destinoI = generaNumeroAleatorio(0, this.filas - 1);
		int destinoJ = generaNumeroAleatorio(0, this.columnas - 1);
		
		int obstaculos = 0;
		for(int i = 0; i < this.filas; i++){
			for(int j = 0; j < this.columnas; j++){
				if(i == inicioI && j == inicioJ){
					this.inicio = true;	
					this.matriz[i][j] = new Nodo(TipoNodo.INICIO);
				}
				else if (i == destinoI && j == destinoJ){
					this.destino = true;
					this.matriz[i][j] = new Nodo(TipoNodo.DESTINO);					
				}				
				else if(obstaculos <= numObstaculos){					
					int randomNum = generaNumeroAleatorio(2, 3);
					if(TipoNodo.values()[randomNum] == TipoNodo.INALCANZABLE)
						obstaculos++;
					this.matriz[i][j] = new Nodo(TipoNodo.values()[randomNum]);
				}
				else{
					this.matriz[i][j] = new Nodo(TipoNodo.ALCANZABLE);
				}
			}
		}
	}
	
	private int generaNumeroAleatorio(int minimo,int maximo){
        
       int num=(int)Math.floor(Math.random()*(maximo-minimo+1)+(minimo));
       return num;
   }
}
