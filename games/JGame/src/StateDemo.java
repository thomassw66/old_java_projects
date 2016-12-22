import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;


public class StateDemo {

	public StateDemo()
	{
		try {
			Display.setDisplayMode(new DisplayMode(600,500));
			Display.setTitle("Programming Bitches");
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}

		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0,600,500,0,1,-1);
		glMatrixMode(GL_MODELVIEW);
		
		while (!Display.isCloseRequested()){
			glClear(GL_COLOR_BUFFER_BIT);
			
			
			Display.update();
			Display.sync(60);
		}
		Display.destroy();
	}	
}