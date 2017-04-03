package id3;

import datos.Datos;
import estructuras.Ejemplo;
import estructuras.Ejemplos;
import estructuras.Resultado;
import lecturaFicheros.ReadAtributos;
import lecturaFicheros.ReadEjemplos;

public class main {
	
	public static void main (String [ ] args) {
		ReadAtributos.read();
		ReadEjemplos.read();
		
		
		
		for(Ejemplos ejs : Datos.getEjemplos()){
			for(Ejemplo ej: ejs.getAtributos()){
				System.out.print(ej.getNombre() + ",");
			}			
			System.out.println(" ");
		}
		
		for(Resultado res : Datos.getResultados()){
			System.out.println(res.isSePuede());
		}
	}
}
