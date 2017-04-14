package GUI;

import java.util.ArrayList;

import javax.swing.JFrame;

import com.mxgraph.model.mxCell;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

import estructuras.Nodo;
import id3.Algoritmo;
import lecturaFicheros.ReadAtributos;
import lecturaFicheros.ReadEjemplos;

public class GraphEditor  extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2707712944901661771L;

	private ArrayList<Object> vertices;
	private int x;
	private int y;
	
	public GraphEditor(Nodo arbol)
	{
		super("Hello, World!");

		mxGraph graph = new mxGraph();
		Object parent = graph.getDefaultParent();

		graph.getModel().beginUpdate();
		
		vertices = new ArrayList<Object>();
		try
		{
			dibujaArbol(arbol, parent, graph);
			/*Object v1 = graph.insertVertex(parent, null, "Hello", 20, 20, 80,
					30);
			Object v2 = graph.insertVertex(parent, null, "World!", 240, 150,
					80, 30);
			graph.insertEdge(parent, null, "Edge", v1, v2);*/
		}
		finally
		{
			graph.getModel().endUpdate();
		}

		mxGraphComponent graphComponent = new mxGraphComponent(graph);
		getContentPane().add(graphComponent);
	}
	
	private void dibujaArbol(Nodo arbol, Object parent, mxGraph graph){
		vertices.add(graph.insertVertex(parent, null, arbol.getNombre(), 20, 20, 80,
				30));
		for(int i = 0; i < arbol.getHijos().size(); i++){
			for(int j = 0; j < arbol.getHijos().get(i).getHijos().size(); j++){
				vertices.add(graph.insertVertex(parent, null, arbol.getHijos().get(i).getHijos().get(j).getNombre(), 20+(i*100), 120, 80,
						30));
				graph.insertEdge(parent, null, arbol.getHijos().get(i).getNombre(), vertices.get(0), vertices.get(i+j+1));
			}
		}
	}

	public static void main(String[] args)
	{
		ReadAtributos.read();
		ReadEjemplos.read();
		
		Algoritmo alg = new Algoritmo();
		Nodo arbol = alg.getAlgorythm();
		
		GraphEditor frame = new GraphEditor(arbol);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 320);
		frame.setVisible(true);
	}

}