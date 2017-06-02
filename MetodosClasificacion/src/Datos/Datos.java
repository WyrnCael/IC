package Datos;

import java.util.ArrayList;

public final class Datos {
	private static ArrayList<String> clases;
	private static ArrayList<double[][]> datosClases;
	private static ArrayList<double[]> ejemplos;
	
	public static ArrayList<String> getClases() {
		return clases;
	}
	
	public static void setClases(ArrayList<String> clases) {
		Datos.clases = clases;
	}
	
	public static ArrayList<double[][]> getDatosClases() {
		return datosClases;
	}
	
	public static void setDatosClases(ArrayList<double[][]> datosClases) {
		Datos.datosClases = datosClases;
	}
	
	public static void addDatosClases(double[][] datosDeClase) {
		if(Datos.datosClases == null){
			Datos.datosClases = new ArrayList<double [][]>();
		}
		Datos.datosClases.add(datosDeClase);
	}

	public static ArrayList<double[]> getEjemplos() {
		return ejemplos;
	}

	public static void setEjemplos(ArrayList<double[]> ejemplos) {
		Datos.ejemplos = ejemplos;
	}
	
	public static void addEjemplo(double[] ejemp) {
		if(Datos.ejemplos == null){
			Datos.ejemplos = new ArrayList<double []>();
		}
		Datos.ejemplos.add(ejemp);
	}
	
	public static String getDatos1String(){
		String cadena = "";
		double[][] aux = datosClases.get(0);
		for(int i = 0; i < aux.length; i++){			
			for(int j = 0; j < aux[i].length; j++){
				if(j == 0)
					cadena += aux[i][j];
				else
					cadena += ", " + aux[i][j];			
			}
			cadena += "\n";
		}	
		
		return cadena;
	}
	
	public static String getDatos2String(){
		String cadena = "";
		double[][] aux = datosClases.get(1);
		for(int i = 0; i < aux.length; i++){
			for(int j = 0; j < aux[i].length; j++){
				if(j == 0)
					cadena += aux[i][j];
				else
					cadena += ", " + aux[i][j];			
			}
			cadena += "\n";
		}	
		
		return cadena;
	}
	
	public static String getEjemplosString(){
		String cadena = "";
		int pos = 0;
		for(double[] ej: ejemplos){
			for(int i = 0; i < ej.length; i++){
				if(i == 0)
					cadena += (pos+1) + "º = "+ ej[i];
				else
					cadena += ", " + ej[i];
			}
			cadena += "\n";
			pos++;
		}
		
		return cadena;
	}
}
