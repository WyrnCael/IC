package Vista;

import aStar.Mapa;

public class Controlador {

	private Mapa mapa;
	private static Controlador instance = null;
	
	public Controlador(){
		
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
		VistaPrincipal.getInstance().setMapa(this.mapa);
	}
}
