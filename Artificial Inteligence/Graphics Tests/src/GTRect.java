import java.awt.Graphics;


public class GTRect extends GTShape{

	double length,width;
	public GTRect(double x, double y, double orientation,double length, double width) {
		super(x, y, orientation);
		this.length = length;
		this.width = width;
	}

	protected void gtdraw(Graphics g) {
		
	}
}
