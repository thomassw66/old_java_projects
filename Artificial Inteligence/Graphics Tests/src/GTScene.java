import java.awt.Graphics;


public abstract class GTScene {

	final int  EWIDTH,EHIEGHT;
	public GTScene(int w,int h){
		EWIDTH = w;
		EHIEGHT = h;
	}
	public abstract void draw(Graphics g);
}
