import java.awt.Graphics;


public class MovableEnvironmentObject extends AbstractEnvironmentObject{

	double orientation;

	static final double PI = Math.PI;
	static final double PIx2 = PI * 2;
	
	public MovableEnvironmentObject(double x,double y,double orientation){
		super(x,y);
		this.orientation = orientation;
	}
	public void move(double distance){
		double yratio = Math.cos(orientation);
		double xratio = Math.sin(orientation);
		
		y += (yratio * distance);
		x += (xratio * distance);
	}
	public void rotate(double radians){
		orientation += radians;
		orientation %= PIx2;
	}
	public void draw(Graphics g){
		g.fillOval((int)(x - 10), (int)(y - 10), 20, 20);
	}
}
