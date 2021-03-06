package aStar;

import java.util.ArrayList;

public class Mapa{
	private int filas;
	private int columnas;
	private Nodo[][] matriz;
	private Nodo nodoInicial;
	private Nodo nodoDestino;
	private ArrayList<Nodo> waypoints;
	
	public Mapa(){
		this.waypoints = new ArrayList<Nodo>();
	}
	
	// Para hacer una copia del objeto
	public Mapa(Mapa mapa){
		this.filas = mapa.filas;
		this.columnas = mapa.columnas;
		this.matriz = new Nodo[this.filas][this.columnas];
		this.waypoints = new ArrayList<Nodo>();
		
		for(int i = 0; i < this.filas; i++){
			for(int j = 0; j < this.columnas; j++){				
				Nodo nodo = new Nodo(mapa.getNodo(i, j).getTipo(), i, j);
				this.matriz[i][j] = nodo;
				if(nodo.isInicio())
					nodoInicial = nodo;
				else if (nodo.isDestino())
					nodoDestino = nodo;
			}
		}
		
		for(Nodo waypoint : mapa.getWayPoints()){
			this.waypoints.add(new Nodo(TipoNodo.WAYPOINT, waypoint.getPosX(), waypoint.getPosY()));
		}
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
	
	public Nodo getNodoInicial() {
		return nodoInicial;
	}

	public void setNodoInicial(Nodo nodoInicial) {
		this.nodoInicial = nodoInicial;
		int i = this.nodoInicial.getPosX();
		int j = this.nodoInicial.getPosY();
		this.matriz[i][j] = this.nodoInicial;
	}
	
	public void removeNodoInicial(){
		int i = this.nodoInicial.getPosX();
		int j = this.nodoInicial.getPosY();
		this.matriz[i][j] = new Nodo(TipoNodo.ALCANZABLE, i, j);
		this.nodoInicial = null;
	}

	public Nodo getNodoDestino() {
		return nodoDestino;
	}

	public void setNodoDestino(Nodo nodoDestino) {
		this.nodoDestino = nodoDestino;
		int i = this.nodoDestino.getPosX();
		int j = this.nodoDestino.getPosY();
		this.matriz[i][j] = this.nodoDestino;
	}
	
	public void removeNodoDestino(){
		int i = this.nodoDestino.getPosX();
		int j = this.nodoDestino.getPosY();
		this.matriz[i][j] = new Nodo(TipoNodo.ALCANZABLE, i, j);
		this.nodoDestino = null;
	}
	
	public Nodo getNodo(int i, int j){
		return this.matriz[i][j];
	}
	
	public void setNodo(int i, int j, TipoNodo tipo){
		if(this.matriz[i][j] != null && this.matriz[i][j].isWayPoint())
			removeWayPoint(this.matriz[i][j]);
		this.matriz[i][j] = new Nodo(tipo, i, j);
		if(tipo == TipoNodo.WAYPOINT)
			addWayPoint(this.matriz[i][j]);
			
	}
	
	public void addWayPoint(Nodo waypoint){
		this.waypoints.add(waypoint);
		waypoint.setWayPointPos(this.waypoints.size());
	}
	
	public void removeWayPoint(Nodo waypoint){
		this.matriz[waypoint.getPosX()][waypoint.getPosY()] = new Nodo(TipoNodo.ALCANZABLE, waypoint.getPosX(), waypoint.getPosY());
		this.waypoints.remove(waypoint);
		for(int i = 0; i < this.waypoints.size(); i++){
			this.waypoints.get(i).setWayPointPos(i+1);
		}
	}
	
	public ArrayList<Nodo> getWayPoints(){
		return this.waypoints;
	}
	
	public ArrayList<Nodo> getAdyacentes(Nodo nodo){
		ArrayList<Nodo> adyacentes = new ArrayList<Nodo>();
		int i = nodo.getPosX();
		int j = nodo.getPosY();
		for(int h = i-1; h <= i+1; h++){
			for(int w = j-1; w <= j+1; w++){
				// Si no es el nodo acutal
				if(!(h == i && w == j)){					
					// Si est� dentro del mapa
					if(h >= 0 && h < filas && w >= 0 && w < columnas){
						if(matriz[h][w].getTipo() != TipoNodo.INALCANZABLE){
							adyacentes.add(matriz[h][w]);	
						}
					}
				}
			}
		}
		return adyacentes;			
	}

	public void creaMapaVacio(int M, int N){
		this.filas = M;
		this.columnas = N;
		matriz = new Nodo[this.filas][this.columnas];
		
		for(int i = 0; i < this.filas; i++){
			for(int j = 0; j < this.columnas; j++){
				this.matriz[i][j] = new Nodo(TipoNodo.ALCANZABLE, i, j);
			}
		}
	}
	
	public void creaMapaAleatorio(int M, int N){
		this.filas = M;
		this.columnas = N;
		matriz = new Nodo[this.filas][this.columnas];
		
		// Generar inicio
		int inicioI = generaNumeroAleatorio(0, this.filas - 1);
		int inicioJ = generaNumeroAleatorio(0, this.columnas - 1);
		this.nodoInicial = new Nodo(TipoNodo.INICIO, inicioI, inicioJ);
		this.matriz[inicioI][inicioJ] = this.nodoInicial;
		
		// Generar destino
		int destinoI = 0, destinoJ = 0;
		do{
			destinoI = generaNumeroAleatorio(0, this.filas - 1);
			destinoJ = generaNumeroAleatorio(0, this.columnas - 1);			
		} while(this.matriz[destinoI][destinoJ] != null);
		this.nodoDestino = new Nodo(TipoNodo.DESTINO, destinoI, destinoJ);
		this.matriz[destinoI][destinoJ] = this.nodoDestino;	
		
		
		// Generar obstaculos
		int numeroDeObstaculos = generaNumeroAleatorio(0, (M*N) - 2);
		for(int i = 0; i < numeroDeObstaculos; i++){
			int obsI = generaNumeroAleatorio(0, this.filas - 1);
			int obsJ = generaNumeroAleatorio(0, this.columnas - 1);
			if(this.matriz[obsI][obsJ] == null)
				this.matriz[obsI][obsJ] = new Nodo(TipoNodo.INALCANZABLE, obsI, obsJ);	
		}
		
		// Generamos los alcanzables
		for(int i = 0; i < this.filas; i++){
			for(int j = 0; j < this.columnas; j++){
				if(this.matriz[i][j] == null){
					
					this.matriz[i][j] = new Nodo(TipoNodo.ALCANZABLE, i, j);
				}
			}
		}
	}
	
	public void resetMapa(){
		for(int i = 0; i < this.filas; i++){
			for(int j = 0; j < this.columnas; j++){
				if(this.matriz[i][j].isCamino()) 
					this.matriz[i][j] = new Nodo(TipoNodo.ALCANZABLE, i, j);
			}
		}
	}
	
	public void generarObstaculosAleatorios(int n){
		int i = 0;
		while(i < n){
			int obsI = generaNumeroAleatorio(0, this.filas - 1);
			int obsJ = generaNumeroAleatorio(0, this.columnas - 1);
			if(this.matriz[obsI][obsJ].isAlcanzable()){
				this.matriz[obsI][obsJ] = new Nodo(TipoNodo.INALCANZABLE, obsI, obsJ);
				i++;
			}
		}
	}
	
	public int getPosicionesAlcanzables(){
		int a = 0;
		for(int i = 0; i < this.filas; i++){
			for(int j = 0; j < this.columnas; j++){
				if(this.matriz[i][j].isAlcanzable()) 
					a++;
			}
		}
		return a;
	}
	
	private int generaNumeroAleatorio(int minimo,int maximo){        
       int num=(int)Math.floor(Math.random()*(maximo-minimo+1)+(minimo));
       return num;
   }
}
