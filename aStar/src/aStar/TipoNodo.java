package aStar;

public enum TipoNodo {
	INICIO(0),
	DESTINO(1),
	INALCANZABLE(2),
	ALCANZABLE(3),
	CAMINO(4),
	WAYPOINT(5);
	
	private final int value;

    private TipoNodo(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
