import static org.lwjgl.opengl.GL11.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.*;


public class SimpleOpenGL {
	
	public SimpleOpenGL (){
		try {
			Display.setDisplayMode(new DisplayMode(600,500));
			Display.setTitle("Programming Bitches");
			Display.create();
		} catch (LWJGLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0,600,500,0,1,-1);
		glMatrixMode(GL_MODELVIEW);
		
		List<Box> boxes = new ArrayList<Box>();
		boolean selected  = false;
		boxes.add(new Box(100,200,30));
		boxes.add(new Box(300,200,100));
		while (!Display.isCloseRequested()){
			
			glClear(GL_COLOR_BUFFER_BIT);
			
			while(Keyboard.next()){
				if(Keyboard.getEventKey() == Keyboard.KEY_C && Keyboard.getEventKeyState()){
					boxes.add(new Box(50,50,60));
				}
			}
			
			int mx = Mouse.getX();
			int my = 500 - Mouse.getY();
			for(Box i : boxes){
				if(Mouse.isButtonDown(0) && !selected){
					if(i.inBounds(mx, my)){
						i.selected = true;
						selected = true;
					}
				}else{
					i.selected = false;
					selected = false;
				}
				
				if(i.selected){
					i.update(Mouse.getDX(),- Mouse.getDY());
				}
				i.draw();
			}
			
			
			Display.update();
			Display.sync(60);
		}
		Display.destroy();
	}
	class Box{
		public boolean selected = false;
		public int x,y;
		private int sidelength;
		private int hside;
		private float r,g,b;
		private Random rand;
		public Box(int x , int y, int sidelength){
			this.x = x;
			this.y = y;
			this.sidelength = sidelength;
			
			//sidelength / 2
			hside = sidelength >> 1;
			
			rand = new Random();
			r = rand.nextFloat();
			g = rand.nextFloat();
			b = rand.nextFloat();
		}
		public boolean inBounds(int x, int y){
			if((x < this.x + hside && x > this.x - hside)&&
					(y < this.y + hside && y > this.y - hside))return true;
			return false;
		}
		public void update(int dx, int dy){
			x += dx;
			y += dy;
		}
		public void draw(){
			
			glBegin(GL_QUADS);
				glColor3f(r,g,b);
				glVertex2i(x - hside, y - hside);
				glVertex2i(x + hside, y - hside);
				glColor3f(r+1,g+1,b+1);
				glVertex2i(x + hside, y + hside);
				glVertex2i(x - hside, y + hside);
			glEnd();
		}
		public void changeColors(){
			r = rand.nextFloat();
			g = rand.nextFloat();
			b = rand.nextFloat();
		}
	}
	public static void main(String [] args){
		SimpleOpenGL a = new SimpleOpenGL();
	}
}
