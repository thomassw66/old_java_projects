import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.*;

import javax.swing.GrayFilter;


public class GreyScale {

	public static BufferedImage toGreyScale(Image image){
		BufferedImage a = (BufferedImage)image;
		BufferedImage b = new BufferedImage(a.getWidth(), a.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
		
		Graphics g = b.getGraphics();
		g.drawImage(a, 0, 0, null);
		return b;
	}
}
