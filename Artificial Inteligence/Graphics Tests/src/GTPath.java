import java.awt.*;


public class GTPath extends GTObject{

	final int N;
	double [] x, y;
	public GTPath(double []x, double []y){
		N = x.length;
		this.x = x;
		this.y = y;
		col = Color.YELLOW;
	}
	public void gtdraw(Graphics g){
		for (int i = 0; i < N-1; i++){
			g.drawLine((int)x[i],(int) y[i], (int)x[i+1],(int) y[i+1]);
		}
	}
}
