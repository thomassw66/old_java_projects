package ThomEngine;

public class Vector2D {
	static final double PI = Math.PI;
	
	double x,y;
	private double orientation;
	private double mag_squared;
	private double mag;
	
	public double magSquared(){return mag_squared;}
	public double mag(){return mag;}
	public double orientation(){return orientation;}
	
	private Vector2D(){}
	public Vector2D(double x, double y){
		this.x = x;
		this.y = y;
		orientation = Math.atan(y/x);
		mag_squared = (x * x) + (y * y);
		mag = Math.sqrt(mag_squared);
	}
	
	public static Vector2D fromOrientationAndMag(double orientation, double mag){
		Vector2D v = new Vector2D();
		v.orientation = orientation;
		v.mag = mag;
		v.mag_squared = mag * mag;
		v.x = Math.sin(orientation) * mag;
		v.y = Math.cos(orientation) * mag;
		return v;
	}
	public static Vector2D fromOrientationAndMag_squared(double orientation, double mag2){
		Vector2D v = new Vector2D();
		v.orientation = orientation;
		v.mag =Math.sqrt(mag2);
		v.mag_squared = mag2;
		v.x = Math.sin(orientation) * v.mag;
		v.y = Math.cos(orientation) * v.mag;
		return v;
	}
	
	public Vector2D rotated(double radians){
		double orientation = (this.orientation + radians) % (2 * PI);
		return fromOrientationAndMag(orientation, mag);
	}d
	
	public Vector2D inverted(){
		Vector2D a = new Vector2D();
		a.mag = mag;
		a.mag_squared = mag_squared;
		a.orientation = ((orientation + PI) % (2 * PI));
		a.x = -x;
		a.y = -y;
		return a;
	}
	
	
	public Vector2D mul(double scalar){
		return new Vector2D(x *scalar, y * scalar);
	}
	public Vector2D mul(Vector2D v){
		return new Vector2D(x * v.x, y * v.y);
	}
	
	public Vector2D div(double scalar){
		return new Vector2D(x / scalar, y / scalar);
	}
	public Vector2D div(Vector2D v){
		return new Vector2D(x / v.x, y / v.y);
	}

	public Vector2D add(double scalar){
		return new Vector2D(x + scalar, y + scalar);
	}
	public Vector2D add(Vector2D v){
		return new Vector2D(x + v.x, y + v.y);
	}
	
	public Vector2D sub(double scalar){
		return new Vector2D(x - scalar, y - scalar);
	}
	public Vector2D sub(Vector2D v){
		return new Vector2D(x - v.x, y - v.y);
	}
}

