import java.awt.Graphics;
import java.awt.Polygon;


public abstract class GTShape extends GTObject{
	
	double x,y;
	double orientation;
	
	static final double PI = Math.PI;
	static final double PIx2 = PI * 2;
	
	public GTShape(double x, double y, double orientation){
		this.x = x;
		this.y = y;
		setOrientation(orientation);
	}
	public void setOrientation(double orientation){
		this.orientation = orientation % (PIx2);
		if(this.orientation < 0)
			this.orientation = -this.orientation;
	}
	public void rotate(double delta){
		setOrientation(orientation + delta);
	}
	protected abstract void gtdraw(Graphics g);
	
}
