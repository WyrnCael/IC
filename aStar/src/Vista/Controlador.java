package Vista;

import aStar.Mapa;

public class Controlador {

	private Mapa mapa;
	private static Controlador instance = null;
	private boolean botonInicio;
	private boolean botonDestino;
	private boolean botonObstaculo;
	private boolean botonAlcanzable;
	private boolean botonWayPoint;
	
	public Controlador(){
		botonInicio = false;
		botonDestino = false;
		botonObstaculo = false;
		botonAlcanzable = false;
		botonWayPoint = false;
	}
	
	public static Controlador getInstance(){
		if(instance == null){
			instance = new Controlador();
		}
		
		return instance;
	}

	public Mapa getMapa() {
		return mapa;
	}

	public void setMapa(Mapa mapa) {
		this.mapa = mapa;
	}
	
	public void refreshMapa(){
		VistaPrincipal.getInstance().refreshMapa();
	}

	public boolean isBotonInicio() {
		return botonInicio;
	}

	public void setBotonInicio(boolean botonInicio) {
		this.botonDestino = false;
		this.botonObstaculo = false;
		this.botonAlcanzable = false;
		this.botonWayPoint = false;
		this.botonInicio = botonInicio;
		
	}

	public boolean isBotonDestino() {
		return botonDestino;
	}

	public void setBotonDestino(boolean botonDestino) {
		this.botonInicio = false;
		this.botonObstaculo = false;
		this.botonAlcanzable = false;
		this.botonWayPoint = false;
		this.botonDestino = botonDestino;
	}
	
	public boolean isBotonObstaculo() {
		return botonObstaculo;
	}

	public void setBotonObstaculo(boolean botonObstaculo) {
		this.botonDestino = false;
		this.botonInicio = false;
		this.botonAlcanzable = false;
		this.botonWayPoint = false;
		this.botonObstaculo = botonObstaculo;
	}

	public boolean isBotonAlcanzable() {
		return botonAlcanzable;
	}

	public void setBotonAlcanzable(boolean botonAlcanzable) {
		this.botonDestino = false;
		this.botonInicio = false;
		this.botonObstaculo = false;
		this.botonWayPoint = false;
		this.botonAlcanzable = botonAlcanzable;
	}

	public boolean isBotonWayPoint() {
		return botonWayPoint;
	}

	public void setBotonWayPoint(boolean botonWayPoint) {
		this.botonDestino = false;
		this.botonInicio = false;
		this.botonObstaculo = false;
		this.botonAlcanzable = false;
		this.botonWayPoint = botonWayPoint;
	}
}
