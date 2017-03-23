package Vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public final class TratadoImagen {

	public static BufferedImage toCompatibleImage(BufferedImage image, String text)
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
	    Font font = new Font("Arial", Font.BOLD, 80);
        g2d.setFont(font);
	    FontMetrics fm = g2d.getFontMetrics();
        int x = ((image.getWidth() + 75 - fm.stringWidth(text)) / 2);
        int y = ((image.getHeight() - fm.getHeight()) / 2) + fm.getAscent();
        g2d.setColor(Color.BLACK);
        g2d.drawString(text, x, y);
	    g2d.dispose();

	    // return the new optimized image
	    return new_image; 
	}
	
	public static void resizeImage(JButton btn, Image img){
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
}
