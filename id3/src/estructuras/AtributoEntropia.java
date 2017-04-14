package estructuras;

public class AtributoEntropia {
	private String nombre;
	private double entropia;
	
	public AtributoEntropia(String nombre, double entropia){
		this.nombre = nombre;
		this.entropia = entropia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getEntropia() {
		return entropia;
	}

	public void setEntropia(double entropia) {
		this.entropia = entropia;
	}
}
