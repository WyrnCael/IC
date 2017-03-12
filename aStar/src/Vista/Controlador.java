package Vista;

public class Controlador {

	private VistaPrincipal vistaPricipal;
	private Tablero tablero;
	private static Controlador instance = null;
	
	public Controlador(){
		
	}
	
	public static Controlador getIntance(){
		if(instance == null){
			instance = new Controlador();
		}
		
		return instance;
	}
	
	public void setTablero(Tablero tab){
		this.tablero = tab;
	}
	
	public void setVistaPrincipal(VistaPrincipal vPri){
		this.vistaPricipal = vPri;
	}
	
	
	
}
