import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.*;


public class LWJGLHelloWorld {

	public LWJGLHelloWorld (){
		try {
			Display.setDisplayMode(new DisplayMode(600,500));
			Display.setTitle("Programming Bitches");
			Display.create();
		} catch (LWJGLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (!Display.isCloseRequested()){
			Display.update();
			Display.sync(60);
		}
	}
	public static void main(String [] args){
		LWJGLHelloWorld a = new LWJGLHelloWorld();
	}
}
