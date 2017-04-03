package datos;

import java.util.ArrayList;

import estructuras.Atributo;
import estructuras.Ejemplo;
import estructuras.Ejemplos;
import estructuras.Resultado;

public final class Datos {
	private static ArrayList<Atributo> atributos;
	private static ArrayList<Ejemplos> ejemplos;	
	private static ArrayList<Resultado> resultados;
	
	public static ArrayList<Atributo> getAtributos() {
		return atributos;
	}
	public static void setAtributos(ArrayList<Atributo> atributos) {
		Datos.atributos = atributos;
	}
	
	public static void addAtributo(Atributo atributo){
		if(atributos == null) atributos = new ArrayList<Atributo>();
		
		atributos.add(atributo);
	}
	
	public static ArrayList<Ejemplos> getEjemplos() {
		return ejemplos;
	}
	public static void setEjemplos(ArrayList<Ejemplos> ejemplos) {
		Datos.ejemplos = ejemplos;
	}
	
	public static void addEjemplos(Ejemplos ejempls){
		if(ejemplos == null) ejemplos = new ArrayList<Ejemplos>();
		
		ejemplos.add(ejempls);
	}

	public static ArrayList<Resultado> getResultados() {
		return resultados;
	}

	public static void setResultados(ArrayList<Resultado> resultados) {
		Datos.resultados = resultados;
	}
	
	public static void addResultado(Resultado resultado){
		if(resultados == null) resultados = new ArrayList<Resultado>();
		resultados.add(resultado);
	}
}
