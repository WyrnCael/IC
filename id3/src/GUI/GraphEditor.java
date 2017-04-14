package GUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.mxgraph.model.mxCell;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

import estructuras.AtributoEntropia;
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
		super("ID3 - Juan José Prieto");

		mxGraph graph = new mxGraph();
		Object parent = graph.getDefaultParent();

		graph.getModel().beginUpdate();
		
		vertices = new ArrayList<Object>();
		try
		{
			vertices.add(graph.insertVertex(parent, null, arbol, 20, 20, 80,
					30));	
			x = 20;
			y = 20;
			dibujaArbol(arbol, parent, graph, 0);
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
		
		graphComponent.getGraphControl().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				Object cell = graphComponent.getCellAt(e.getX(), e.getY());
				Nodo nodo = (Nodo) ((mxCell) cell).getValue();
				
				JPanel entropias = new JPanel();
				String entr = "";
				for(AtributoEntropia ent: nodo.getAtributosentorpias()){
					entr += ent.getNombre() + ": " + ent.getEntropia() + ", ";
				}
				JLabel texto = new JLabel(entr);
				entropias.add(texto);
				entropias.setVisible(true);
				getContentPane().add(entropias);
				
				System.out.println(nodo.getEntropia());
				
			}
		});
	}
	
	private void dibujaArbol(Nodo arbol, Object parent, mxGraph graph, int pos){
		y += 100;
		for(int i = 0; i < arbol.getHijos().size(); i++){			
			if( i > 0 ) x += 100;
			Object vert = graph.insertVertex(parent, null, arbol.getHijos().get(i).getHijos().get(0), x, y, 80,
					30);
			vertices.add(vert);
			int aux = vertices.indexOf(vert);
			graph.insertEdge(parent, null, arbol.getHijos().get(i).getNombre(), vertices.get(pos), vertices.get(aux));			
			
			dibujaArbol(arbol.getHijos().get(i).getHijos().get(0), parent, graph, aux);	
			y -= 100;
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
		frame.setSize(1200, 800);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}