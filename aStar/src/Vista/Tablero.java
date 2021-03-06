package Vista;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import aStar.AlgoritmoAEstrella;
import aStar.Mapa;
import aStar.Nodo;
import aStar.TipoNodo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Tablero extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6980873179558383636L;
	/**
	 * Create the panel.
	 */
	private JButton[][] casillas;
	
	public Tablero() {			
		onCreate();
	}
	
	private void onCreate(){
		dibujaMapa();		
	}
	
	public void dibujaMapa(){
		this.removeAll();
		Mapa mapa = Controlador.getInstance().getMapa();
		setLayout(new GridLayout(mapa.getFilas(), mapa.getColumnas()));
		casillas = new JButton[mapa.getFilas()][mapa.getColumnas()];
		
		for(int i = 0; i < mapa.getFilas(); i++){
			for(int j = 0; j < mapa.getColumnas(); j++){
				casillas[i][j] = new JButton();
				
				if(mapa.getCasilla(i, j).isInicio()){
					drawInicio(i, j);				
				}
				else if(mapa.getCasilla(i, j).isDestino())
					drawDestino(i, j);
				else if(mapa.getCasilla(i, j).isAlcanzable())
					casillas[i][j].setBackground(Color.BLUE);
				else if(mapa.getCasilla(i, j).isCamino())
					drawCamino(i, j);
				else if(mapa.getCasilla(i, j).isWayPoint())
					drawWayPoint(i, j, "" + mapa.getCasilla(i, j).getWayPointPos());
				else
					drawObstaculo(i, j);
				
				casillas[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
				
				casillas[i][j].addActionListener(new ActionListcasilla(i, j));
				
				this.add(casillas[i][j]);
			}
		}
		this.revalidate();
		this.repaint();
	}
	
	private void drawInicio(int i, int j){
		try {
			Image image = ImageIO.read(getClass().getResource("barco.png"));
			BufferedImage img = TratadoImagen.toCompatibleImage((BufferedImage) image, "");
			ImageIcon icon = new ImageIcon(img);
			casillas[i][j].setIcon(icon);
			casillas[i][j].setBackground(Color.BLUE);
			TratadoImagen.resizeImage(casillas[i][j], img);
			casillas[i][j].addComponentListener(new ComponentAdapter() {

                @Override
                public void componentResized(ComponentEvent e) {
                    JButton btn = (JButton) e.getComponent();
                    TratadoImagen.resizeImage(btn, img);
                }

            });
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	private void drawDestino(int i, int j){
		try {
			Image image = ImageIO.read(getClass().getResource("moby_dick.png"));
			BufferedImage img = TratadoImagen.toCompatibleImage((BufferedImage) image, "");
			ImageIcon icon = new ImageIcon(img);
			casillas[i][j].setIcon(icon);
			casillas[i][j].setBackground(Color.BLUE);
			TratadoImagen.resizeImage(casillas[i][j], img);
			casillas[i][j].addComponentListener(new ComponentAdapter() {

                @Override
                public void componentResized(ComponentEvent e) {
                    JButton btn = (JButton) e.getComponent();
                    TratadoImagen.resizeImage(btn, img);
                }

            });
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	private void drawObstaculo(int i, int j){
		casillas[i][j] = new Obstaculo();
		casillas[i][j].addActionListener(new ActionListcasilla(i, j));
		this.revalidate();
		this.repaint();
	}
	
	private void drawCamino(int i, int j){
		casillas[i][j] = new Camino();	
		casillas[i][j].addActionListener(new ActionListcasilla(i, j));
	}
	
	private void drawWayPoint(int i, int j, String text){
		casillas[i][j].setBackground(Color.BLUE);
		try {
			Image image = ImageIO.read(getClass().getResource("fish.png"));
			BufferedImage img = TratadoImagen.toCompatibleImage((BufferedImage) image, text);
			ImageIcon icon = new ImageIcon(img);
			casillas[i][j].setIcon(icon);
			TratadoImagen.resizeImage(casillas[i][j], img);
			casillas[i][j].addComponentListener(new ComponentAdapter() {

                @Override
                public void componentResized(ComponentEvent e) {
                    JButton btn = (JButton) e.getComponent();
                    TratadoImagen.resizeImage(btn, img);
                }

            });
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private class ActionListcasilla implements ActionListener {
	    private int i;
	    private int j;

	    public ActionListcasilla(int i, int j) {
	        this.i = i;
	        this.j = j;
	    }

	    public void actionPerformed(ActionEvent e) {
	        if(Controlador.getInstance().isBotonInicio()){
	        	Controlador.getInstance().getMapa().setNodoInicial(new Nodo(TipoNodo.INICIO, i, j));
	        	drawInicio(i, j);
	        	Controlador.getInstance().setBotonInicio(false);
	        	Controlador.getInstance().refreshMapa();
	        }
	        else if(Controlador.getInstance().isBotonDestino()){
	        	Controlador.getInstance().getMapa().setNodoDestino(new Nodo(TipoNodo.DESTINO, i, j));
	        	drawDestino(i, j);
	        	Controlador.getInstance().setBotonDestino(false);
	        	Controlador.getInstance().refreshMapa();
	        }
	        else if(Controlador.getInstance().isBotonObstaculo()){
	        	if(Controlador.getInstance().getMapa().getNodo(i, j).isDestino()){
	        		if (JOptionPane.showConfirmDialog(null, "�Desea elimimar el nodo destino y cambiarlo por un obstaculo?", "�Atenci�n!",
					        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					    Controlador.getInstance().getMapa().removeNodoDestino();
					    Controlador.getInstance().getMapa().setNodo(i, j, TipoNodo.INALCANZABLE);
					    drawObstaculo(i, j);
					    Controlador.getInstance().refreshMapa();
					}
	        	}
	        	else if(Controlador.getInstance().getMapa().getNodo(i, j).isInicio()){
	        		if (JOptionPane.showConfirmDialog(null, "�Desea elimimar el nodo incial y cambiarlo por un obstaculo?", "�Atenci�n!",
					        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					    Controlador.getInstance().getMapa().removeNodoInicial();
					    Controlador.getInstance().getMapa().setNodo(i, j, TipoNodo.INALCANZABLE);
					    drawObstaculo(i, j);
					    Controlador.getInstance().refreshMapa();
					}
	        	}
	        	else if(Controlador.getInstance().getMapa().getNodo(i, j).isCamino()){
	        		Controlador.getInstance().getMapa().setNodo(i, j, TipoNodo.INALCANZABLE);
	        		Controlador.getInstance().getMapa().resetMapa();
					Controlador.getInstance().refreshMapa();
					AlgoritmoAEstrella algoritmo = new AlgoritmoAEstrella(Controlador.getInstance().getMapa());
					Mapa mapa = algoritmo.getCaminoFinal();					
					if(mapa == null){
						JOptionPane.showMessageDialog(null, "No se puede llegar al destino desde el inicio.", "No hay camino", JOptionPane.INFORMATION_MESSAGE);
					}
					else{
						Controlador.getInstance().setMapa(mapa);
						Controlador.getInstance().refreshMapa();
					}	
	        	}
	        	else{
	        		Controlador.getInstance().getMapa().setNodo(i, j, TipoNodo.INALCANZABLE);
	        		Controlador.getInstance().refreshMapa();
	        	}	        	
	        }
	        else if(Controlador.getInstance().isBotonAlcanzable()){
	        	if(Controlador.getInstance().getMapa().getNodo(i, j).isDestino()){
	        		if (JOptionPane.showConfirmDialog(null, "�Desea elimimar el nodo destino?", "�Atenci�n!",
					        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					    Controlador.getInstance().getMapa().removeNodoDestino();
					    Controlador.getInstance().getMapa().setNodo(i, j, TipoNodo.ALCANZABLE);
					    casillas[i][j].setBackground(Color.BLUE);
					    Controlador.getInstance().refreshMapa();
					}
	        	}
	        	else if(Controlador.getInstance().getMapa().getNodo(i, j).isInicio()){
	        		if (JOptionPane.showConfirmDialog(null, "�Desea elimimar el nodo incial?", "�Atenci�n!",
					        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					    Controlador.getInstance().getMapa().removeNodoInicial();
					    Controlador.getInstance().getMapa().setNodo(i, j, TipoNodo.ALCANZABLE);
					    casillas[i][j].setBackground(Color.BLUE);
					    Controlador.getInstance().refreshMapa();
					}
	        	}
	        	else{
	        		Controlador.getInstance().getMapa().setNodo(i, j, TipoNodo.ALCANZABLE);
	        		Controlador.getInstance().refreshMapa();
	        	}	        	
	        }
	        else if(Controlador.getInstance().isBotonWayPoint()){
	        	if(Controlador.getInstance().getMapa().getNodo(i, j).isDestino()){
	        		if (JOptionPane.showConfirmDialog(null, "�Desea elimimar el nodo destino y poner un waypoint?", "�Atenci�n!",
					        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					    Controlador.getInstance().getMapa().removeNodoDestino();
					    Controlador.getInstance().getMapa().setNodo(i, j, TipoNodo.WAYPOINT);
					    drawWayPoint(i, j, "" + Controlador.getInstance().getMapa().getCasilla(i, j).getWayPointPos());
					    Controlador.getInstance().refreshMapa();
					}
	        	}
	        	else if(Controlador.getInstance().getMapa().getNodo(i, j).isInicio()){
	        		if (JOptionPane.showConfirmDialog(null, "�Desea elimimar el nodo incial y poner un waypoint?", "�Atenci�n!",
					        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					    Controlador.getInstance().getMapa().removeNodoInicial();
					    Controlador.getInstance().getMapa().setNodo(i, j, TipoNodo.WAYPOINT);
					    drawWayPoint(i, j, "" + Controlador.getInstance().getMapa().getCasilla(i, j).getWayPointPos());
					    Controlador.getInstance().refreshMapa();
					}
	        	}
	        	else{
	        		Controlador.getInstance().getMapa().setNodo(i, j, TipoNodo.WAYPOINT);
	        		Controlador.getInstance().refreshMapa();
	        	}	        	
	        }
	    }
	}

	public static class Obstaculo extends JButton
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 9209619207494859570L;

		@Override
	    public void paintComponent(Graphics g)
	    {
	    	super.setBackground(Color.BLUE);
	    	super.paintComponent(g);
	        g.setColor(Color.GRAY);
	        g.fillOval(getHorizontalAlignment(), getVerticalAlignment(), getWidth(), getHeight());
	         
	    }
	}

	private class Camino extends JButton
	{
	    /**
		 * 
		 */
		private static final long serialVersionUID = 3411478378342734678L;

		public void paintComponent(Graphics g)
	    {
	    	super.setBackground(Color.BLUE);
	    	super.paintComponent(g);
	        g.setColor(Color.GREEN);
	        g.fillOval(getHorizontalAlignment() + getWidth()/4, getVerticalAlignment() + getHeight()/4, getWidth()/2, getHeight()/2);
	           
	    }
	}
	
}
