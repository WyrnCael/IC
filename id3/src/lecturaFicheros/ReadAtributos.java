package lecturaFicheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import datos.Datos;
import estructuras.Atributo;

public final class ReadAtributos {
	
	public static void read(){
		File file = new File(ReadAtributos.class.getResource("/ficheros/AtributosJuego.txt").getFile());
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		       // process the line.
		    	String[] atributos = line.split(",");
		    	for(String atributo : atributos){
		    		Datos.addAtributo(new Atributo(atributo));
		    	}
		    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
