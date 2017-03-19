package Vista;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import aStar.Mapa;
import aStar.Nodo;
import aStar.TipoNodo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Tablero extends JPanel {

	/**
	 * Create the panel.
	 */
	private JButton[][] casillas;
	
	public Tablero() {	
		
		onCreate();
	}
	
	private void onCreate(){
		dibujaMapa();	
		
		/*this.setSize(new Dimension(550, 550));
		this.setPreferredSize(new Dimension(550, 550));
		this.setMinimumSize(new Dimension(550, 550));
		this.setMaximumSize(new Dimension(550, 550));*/
		
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
				else
					drawObstaculo(i, j);
				
				casillas[i][j].setBorder(null);
				
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
			BufferedImage img = toCompatibleImage((BufferedImage) image);
			ImageIcon icon = new ImageIcon(img);
			casillas[i][j].setIcon(icon);
			casillas[i][j].setBackground(Color.BLUE);
			resizeImage(casillas[i][j], img);
			casillas[i][j].addComponentListener(new ComponentAdapter() {

                @Override
                public void componentResized(ComponentEvent e) {
                    JButton btn = (JButton) e.getComponent();
                    resizeImage(btn, img);
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
			BufferedImage img = toCompatibleImage((BufferedImage) image);
			ImageIcon icon = new ImageIcon(img);
			casillas[i][j].setIcon(icon);
			casillas[i][j].setBackground(Color.BLUE);
			resizeImage(casillas[i][j], img);
			casillas[i][j].addComponentListener(new ComponentAdapter() {

                @Override
                public void componentResized(ComponentEvent e) {
                    JButton btn = (JButton) e.getComponent();
                    resizeImage(btn, img);
                }

            });
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	private void drawObstaculo(int i, int j){
		casillas[i][j] = new Obstaculo();
	}
	
	private void drawCamino(int i, int j){
		casillas[i][j] = new Camino();	
	}
	
	private BufferedImage toCompatibleImage(BufferedImage image)
	{
	    // obtain the current system graphical settings
	    GraphicsConfiguration gfx_config = GraphicsEnvironment.
	        getLocalGraphicsEnvironment().getDefaultScreenDevice().
	        getDefaultConfiguration();

	    /*
	     * if image is already compatible and optimized for current system 
	     * settings, simply return it
	     */
	    if (image.getColorModel().equals(gfx_config.getColorModel()))
	        return image;

	    // image is not optimized, so create a new image that is
	    BufferedImage new_image = gfx_config.createCompatibleImage(
	            image.getWidth(), image.getHeight(), image.getTransparency());

	    // get the graphics context of the new image to draw the old image on
	    Graphics2D g2d = (Graphics2D) new_image.getGraphics();

	    // actually draw the image and dispose of context no longer needed
	    g2d.drawImage(image, 0, 0, null);
	    g2d.dispose();

	    // return the new optimized image
	    return new_image; 
	}
	
	private void resizeImage(JButton btn, Image img){
		Dimension size = btn.getSize();
        Insets insets = btn.getInsets();
        size.width -= insets.left + insets.right;
        size.height -= insets.top + insets.bottom;
        if (size.width > size.height) {
            size.width = -1;
        } else {
            size.height = -1;
        }
        Image scaled = img.getScaledInstance(size.width, size.height, java.awt.Image.SCALE_SMOOTH);
        btn.setIcon(new ImageIcon(scaled));
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
	        }
	        else if(Controlador.getInstance().isBotonDestino()){
	        	Controlador.getInstance().getMapa().setNodoDestino(new Nodo(TipoNodo.DESTINO, i, j));
	        	drawDestino(i, j);
	        	Controlador.getInstance().setBotonDestino(false);
	        }
	        else if(Controlador.getInstance().isBotonObstaculo()){
	        	if(Controlador.getInstance().getMapa().getNodo(i, j).isDestino()){
	        		if (JOptionPane.showConfirmDialog(null, "¿Desea elimimar el nodo destino y cambiarlo por un obstaculo?", "¡Atención!",
					        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					    Controlador.getInstance().getMapa().removeNodoDestino();
					    Controlador.getInstance().getMapa().setNodo(i, j, TipoNodo.INALCANZABLE);
					    drawObstaculo(i, j);
					}
	        	}
	        	else if(Controlador.getInstance().getMapa().getNodo(i, j).isInicio()){
	        		if (JOptionPane.showConfirmDialog(null, "¿Desea elimimar el nodo incial y cambiarlo por un obstaculo?", "¡Atención!",
					        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					    Controlador.getInstance().getMapa().removeNodoInicial();
					    Controlador.getInstance().getMapa().setNodo(i, j, TipoNodo.INALCANZABLE);
					    drawObstaculo(i, j);
					}
	        	}
	        	else{
	        		Controlador.getInstance().getMapa().setNodo(i, j, TipoNodo.INALCANZABLE);
	        		drawObstaculo(i, j);
	        	}
	        	
	        }
	    }
	}

	private class Obstaculo extends JButton
	{
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
	    public void paintComponent(Graphics g)
	    {
	    	super.setBackground(Color.BLUE);
	    	super.paintComponent(g);
	        g.setColor(Color.GREEN);
	        g.fillOval(getHorizontalAlignment() + getWidth()/4, getVerticalAlignment() + getHeight()/4, getWidth()/2, getHeight()/2);
	           
	    }
	}
	
}
