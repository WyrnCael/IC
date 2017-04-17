package estructuras;

public class Resultado {
	@SuppressWarnings("unused")
	private String resultado;
	private boolean sePuede;
	
	public Resultado(String resultado){
		this.resultado = resultado;
		if(resultado.equals("si"))
			this.sePuede = true;
		else
			this.sePuede = false;
	}

	public boolean isSePuede() {
		return sePuede;
	}

	public void setSePuede(boolean sePuede) {
		this.sePuede = sePuede;
	}
}
