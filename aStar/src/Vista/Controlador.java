package Vista;

import aStar.Mapa;

public class Controlador {

	private Mapa mapa;
	private static Controlador instance = null;
	private boolean botonInicio;
	private boolean botonDestino;
	
	public Controlador(){
		botonInicio = false;
		botonDestino = false;
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
		this.botonInicio = botonInicio;
	}

	public boolean isBotonDestino() {
		return botonDestino;
	}

	public void setBotonDestino(boolean botonDestino) {
		this.botonDestino = botonDestino;
	}
	
	public void setInicio(int i, int j){
		
	}
}
