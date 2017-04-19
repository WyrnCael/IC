package lecturaFicheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import datos.Datos;
import estructuras.Ejemplo;
import estructuras.Ejemplos;
import estructuras.Resultado;

public final class ReadEjemplos {
	
	public static void read(){
		File file = new File("Juego.txt");
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    String line;
		    int i = 0;
		    while ((line = br.readLine()) != null) {
		       // process the line.
		    	String[] lineas = line.split(",");
		    	int pos = 0;		    	
		    	Ejemplos ejemplos = new Ejemplos();
		    	for(String atributo : lineas){		    		
		    		if(pos < Datos.getAtributos().size() - 1){
		    			ejemplos.addEjemplo(new Ejemplo(atributo, i));		    			
		    		}
		    		else
		    			Datos.addResultado(new Resultado(atributo));
		    		pos++;
		    	}		
		    	Datos.addEjemplos(ejemplos);
		    	i++;
		    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
