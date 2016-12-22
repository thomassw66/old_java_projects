import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;


public class PolyPaintPanel extends JPanel implements MouseListener, MouseMotionListener{
	ArrayList<Integer> x = new ArrayList<Integer>();
	ArrayList<Integer> y = new ArrayList<Integer>();
	
	ArrayList<Polygon> polys = new ArrayList<Polygon>();
	Polygon current;
	
	Point prev = null;
	Point curr = null;
	
	BufferedImage image;
	
	Graphics2D graph = null;
	Graphics2D G2 = null;
	
	public PolyPaintPanel(Image a){
		image = (BufferedImage) a;
		graph = image.createGraphics();
		
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	public void paintComponent(Graphics g){
		g.drawImage(image, 0, 0, this.getSize().width, this.getSize().height, null, null);
		
		g.setColor(Color.black);
		
		for(Polygon p : polys)
			g.drawPolygon(p);
		
		current = new Polygon(toArray(x),toArray(y),x.size());
		g.drawPolygon(current);
	}
	public void mouseClicked(MouseEvent arg0) {

	}

	public void mouseEntered(MouseEvent arg0) {
		
	}

	public void mouseExited(MouseEvent arg0) {
		
	}

	public void mousePressed(MouseEvent arg0) {
		if(prev != null){

		}else{
			
		}
	}
	public void mouseReleased(MouseEvent arg0) {
		polys.add(current);
		current = null;
		x = new ArrayList<Integer>();
		y = new ArrayList<Integer>();
		curr = null;
	}
	public void mouseDragged(MouseEvent arg0) {
		if(curr != null){
			x.add(curr.x);
			y.add(curr.y);
			repaint();
		}
		curr = arg0.getPoint();
		repaint();
	}
	public void mouseMoved(MouseEvent arg0) {
		
	}
	public static int [] toArray(ArrayList<Integer> a){
		int [] b = new int [a.size()];
		for(int i = 0; i < b.length; i++)
			b[i] = a.get(i);
		return b;
	}
}