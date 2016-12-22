import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;

public class GTEnvironment {

	final int EWIDTH;
	final int EHIEGHT;
	
	GTScene scene;
	
	public GTEnvironment(int w, int h){
		EWIDTH = w;
		EHIEGHT = h;
	}

	public GTEnvironment(int w, int h, GTScene scene){
		EWIDTH = w;
		EHIEGHT = h;
		this.scene = scene;
	}
	
	public void paint(Graphics g){
		g.fillRect(0,0,EWIDTH,EHIEGHT);
		
		if(scene != null)
			scene.draw(g);
	}
}
