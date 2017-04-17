package id3;

import java.awt.EventQueue;

import GUI.Controlador;
import GUI.MainWindow;
import estructuras.Nodo;
import lecturaFicheros.ReadAtributos;
import lecturaFicheros.ReadEjemplos;

public class Main {
	
	public static void main (String [ ] args) {
		ReadAtributos.read();
		ReadEjemplos.read();
		
		Algoritmo alg = new Algoritmo();
		Nodo arbol = alg.getAlgorythm();
		
		Controlador.getInstance().setArbol(arbol);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow.getInstance();	
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}