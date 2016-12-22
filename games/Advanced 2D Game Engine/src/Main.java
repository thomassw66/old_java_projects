import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import static org.lwjgl.opengl.GL11.*;

public class Main {

	public static void main(String [] args){
		try {
			Display.setDisplayMode(Display.getDesktopDisplayMode());
			Display.create();
			

			glMatrixMode(GL_PROJECTION);
			glLoadIdentity();
			glOrtho(0,600,0,500,100,-500);
			// glOrtho(left, right, bottom, top, zNear, zFar)
			//glMatrixMode(GL_MODELVIEW);
			
			int i = 1;
			while(!Display.isCloseRequested()){

				glClear(GL_COLOR_BUFFER_BIT);
				
				
				Display.update();
				Display.sync(60);

			}
			
		} catch (LWJGLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
