import java.awt.Color;
import java.awt.Graphics;


public class GTLine extends GTShape{

	double length;
	public GTLine(double x, double y, double orientation,double length) {
		super(x, y, orientation);
		this.length = length;
		this.col = Color.BLUE;
	}
	protected void gtdraw(Graphics g) {
		g.drawLine((int)x,(int)y,(int)(x + Math.sin(orientation)*length),(int)(y + Math.cos(orientation) * length));
	}

}
