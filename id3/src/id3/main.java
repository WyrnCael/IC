package id3;

import datos.Datos;
import estructuras.Resultado;
import lecturaFicheros.readAtributos;
import lecturaFicheros.readEjemplos;

public class main {
	
	public static void main (String [ ] args) {
		readAtributos.read();
		readEjemplos.read();
		
		for(Resultado res : Datos.getResultados()){
			System.out.println(res.isSePuede());
		}
	}
}
