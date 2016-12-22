import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.*;
import javax.swing.JPanel;


public class MainPanel extends JPanel implements MouseListener{

	public MainPanel(BufferedImage i) throws IOException{
		this.setPreferredSize(new Dimension(i.getWidth(),i.getHeight()));
		this.toDisplay = i;
		addMouseListener(this);
		BufferedImage o = 	GreyScale.toGreyScale(toDisplay);
		//Binarization.binarize(o);
		BufferedImage im = FeatureExtraction.getEdges(o);
		ImageIO.write(im,"jpg",new File("cake2.jpg"));
	}
	BufferedImage toDisplay;
	int x = 100;
	int y = 100;
	public void paint(Graphics gd){
		
		BufferedImage o = GreyScale.toGreyScale(toDisplay); //(BufferedImage)toDisplay;
		gd.drawImage(FeatureExtraction.getEdges(o), 0, 0, null);
		//Binarization.binarize(o);
		//gd.drawImage(o, o.getWidth(), 0, null);
		/*
		int h = o.getHeight();
		int w = o.getWidth();
		
		
		int [][] rgbs = new int[h][w];
		
		double wx = 1.0;
		double wy = 1.0;

		double y = 0;
		for(int i = 0; i < h; i++, y += wy){
			double x = 0;
			for (int j =0; j < w; j ++, x += wx){
				
				int rgb = o.getRGB(j, i);
				rgbs[i][j] = rgb;

				int r = (rgb >> 16) & 255;
				int g = (rgb >> 8) & 255;
				int b = rgb & 255;
			
				gr.setColor(new Color(rgb));
				gr.fillRect((int)x,(int) y, (int)Math.ceil(wx),(int) Math.ceil(wy));
				
			}
		}
		System.out.println("painted");*/
	}
	public void mouseClicked(MouseEvent arg0) {
		
	}
	public void mouseEntered(MouseEvent arg0) {
		
	}
	public void mouseExited(MouseEvent arg0) {
		
	}
	public void mousePressed(MouseEvent arg0) {
		
	}
	public void mouseReleased(MouseEvent arg0) {
		x = arg0.getX();
		y = arg0.getY();
		repaint();
	}

}