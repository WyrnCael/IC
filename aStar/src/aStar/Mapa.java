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
	
	public void creaMapaAleatorio(int M, int N){
		this.filas = M;
		this.columnas = N;
		this.inicio = false;
		this.destino = false;		
		matriz = new Nodo[this.filas][this.columnas];
		
		// Generar inicio
		int inicioI = generaNumeroAleatorio(0, this.filas - 1);
		int inicioJ = generaNumeroAleatorio(0, this.columnas - 1);
		this.inicio = true;	
		this.matriz[inicioI][inicioJ] = new Nodo(TipoNodo.INICIO);
		
		// Generar destino
		int destinoI = generaNumeroAleatorio(0, this.filas - 1);
		int destinoJ = generaNumeroAleatorio(0, this.columnas - 1);
		this.destino = true;
		this.matriz[destinoI][destinoJ] = new Nodo(TipoNodo.DESTINO);	
		
		// Generar obstaculos
		int numeroDeObstaculos = generaNumeroAleatorio(0, (M*N) - 2);
		for(int i = 0; i < numeroDeObstaculos; i++){
			int obsI = generaNumeroAleatorio(0, this.filas - 1);
			int obsJ = generaNumeroAleatorio(0, this.columnas - 1);
			if(this.matriz[obsI][obsJ] == null)
				this.matriz[obsI][obsJ] = new Nodo(TipoNodo.INALCANZABLE);	
		}
		
		// Generamos los alcanzables
		for(int i = 0; i < this.filas; i++){
			for(int j = 0; j < this.columnas; j++){
				if(this.matriz[i][j] == null){
					
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
