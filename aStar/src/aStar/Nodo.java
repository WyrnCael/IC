package aStar;

public class Nodo {
	private boolean alcanzable;

	public Nodo(){
		alcanzable = true;
	}
	
	public boolean isAlcanzable() {
		return alcanzable;
	}

	public void setAlcanzable(boolean alcanzable) {
		this.alcanzable = alcanzable;
	}
	
	
}
