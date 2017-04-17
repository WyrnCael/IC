package GUI;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.mxgraph.model.mxCell;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxStylesheet;

import estructuras.AtributoEntropia;
import estructuras.Nodo;
import id3.Algoritmo;
import lecturaFicheros.ReadAtributos;
import lecturaFicheros.ReadEjemplos;

public class GraphEditor  extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2707712944901661771L;

	private ArrayList<Object> vertices;
	private int x;
	private int y;
	
	public GraphEditor(Nodo arbol){
		setLayout(new BorderLayout());

		mxGraph graph = new mxGraph();
		
		Map<String, Object> edgeStyle = new HashMap<String, Object>();
		//edgeStyle.put(mxConstants.STYLE_EDGE, mxConstants.EDGESTYLE_ORTHOGONAL);
		edgeStyle.put(mxConstants.STYLE_SHAPE,    mxConstants.SHAPE_CONNECTOR);
		edgeStyle.put(mxConstants.STYLE_ENDARROW, mxConstants.ARROW_CLASSIC);
		edgeStyle.put(mxConstants.STYLE_STROKECOLOR, "#0033FF");
		edgeStyle.put(mxConstants.STYLE_FONTCOLOR, "#000000");
		edgeStyle.put(mxConstants.STYLE_LABEL_BACKGROUNDCOLOR, "#EEEEEE");

		mxStylesheet stylesheet = new mxStylesheet();
		stylesheet.setDefaultEdgeStyle(edgeStyle);
		graph.setStylesheet(stylesheet);
		
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
		}
		finally
		{
			graph.getModel().endUpdate();
		}

		mxGraphComponent graphComponent = new mxGraphComponent(graph);
		graphComponent.setEnabled(false);
		this.add(graphComponent, BorderLayout.CENTER);
		
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
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				try{
					Object cell = graphComponent.getCellAt(e.getX(), e.getY());
					Nodo nodo = (Nodo) ((mxCell) cell).getValue();
					
					if(nodo.getAtributosentorpias().size() > 0)
						Controlador.getInstance().setEntropias(nodo);
					
					System.out.println(nodo.getEntropia());
				} catch (ClassCastException | NullPointerException a){
					
				}
			}
		});
	}
	
	private void dibujaArbol(Nodo arbol, Object parent, mxGraph graph, int pos){
		y += 100;
		for(int i = 0; i < arbol.getHijos().size(); i++){			
			if( i > 0 ) x += 100;
			Object vert = null;
			if(arbol.getHijos().get(i).getHijos().get(0).getNombre().equals("SI")){
				vert = graph.insertVertex(parent, null, arbol.getHijos().get(i).getHijos().get(0), x, y, 80,
						30, "defaultVertex;fillColor=lightgreen");
			} else if (arbol.getHijos().get(i).getHijos().get(0).getNombre().equals("NO")){
				vert = graph.insertVertex(parent, null, arbol.getHijos().get(i).getHijos().get(0), x, y, 80,
						30, "defaultVertex;fillColor=#FF8888");
			} else {
				vert = graph.insertVertex(parent, null, arbol.getHijos().get(i).getHijos().get(0), x, y, 80,
						30);
			}
			vertices.add(vert);
			int aux = vertices.indexOf(vert);
			graph.insertEdge(parent, null, arbol.getHijos().get(i).getNombre(), vertices.get(pos), vertices.get(aux));			
			
			dibujaArbol(arbol.getHijos().get(i).getHijos().get(0), parent, graph, aux);	
			y -= 100;
		}
		
	}

}