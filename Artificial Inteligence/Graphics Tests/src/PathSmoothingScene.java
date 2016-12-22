import java.awt.Color;
import java.awt.Graphics;


public class PathSmoothingScene extends GTScene{

	public static void main(String [] args){
		GTViewingWindow g = new GTViewingWindow();
		g.setScene(new PathSmoothingScene(g.getSize().width, g.getSize().height));
		
	}
	public PathSmoothingScene(int w,int h){
		super(w,h);
	}
	public void draw(Graphics g){
		g.fillRect(0,0,EWIDTH,EHIEGHT);
		
		double [] x = new double [EWIDTH/4];
		double [] y = new double [EWIDTH/4];
		
		double pt = 0.0;
		boolean up = false;
		for(int i = 0; i < x.length; i ++){
			x[i] = pt;
			pt += 4.0;
			
			if(i % 32 == 0)
				up = !up;
			
			if(up){
				y[i] = 400;
			}else{
				y[i] = 100;
			}
		}
		
		
		GTPath p = new GTPath(x,y);
		p.col = Color.red;
		
		p.draw(g);
		
		double delta = .05;
		for(double i = .3; i < .5; i+=delta){
			double [] sx = x,sy = smooth(y,.3,i);
			GTPath p2 = new GTPath(sx,sy);
			p2.draw(g);
			delta = .5*(.5 - i);
			if(delta < .00002)
				delta = .00002;
		}
		
	}
	static double [] smooth(double [] x, double data_w, double smooth_w){
		double tolerance = .0001;
		double [] y = x.clone();
		
		double change = 1.0;
		while(change >= tolerance){
			change = 0.0;
			for(int i = 1; i < x.length - 1; i++){
				
				double aux = y[i];
				y[i] += data_w * (x[i] - y[i]);
				y[i] += smooth_w * (y[i+1] + y[i-1] - 2*y[i]);
				
				change += Math.abs(aux - y[i]);
			}
		}
		return y;
	}
}
