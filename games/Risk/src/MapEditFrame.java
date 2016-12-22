import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;


public class MapEditFrame extends JFrame{

	Image mapimage = null;
	private JMenuBar menu;
	
	private Container content;
	
	public void init(String text){

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		content = getContentPane();
		
		initMenuBar();
		
		
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		if(mapimage == null)
			mapimage = new BufferedImage(screen.width, screen.height, BufferedImage.TYPE_INT_RGB);
		
		initEditPanel();
		
		pack();
		setSize(screen);
		setTitle(text);
		
		setVisible(true);
	}
	void initEditPanel(){
		content.add(new PolyPaintPanel(mapimage));
	}
	void initMenuBar(){
		menu = new JMenuBar();
		JMenu file = new JMenu("File");
		menu.add(file);
		file.add(new JMenuItem("Save"));
		file.add(new JMenuItem("Load"));
		content.add(BorderLayout.NORTH, menu);
		//getContentPane().add(menu);
	}
	public MapEditFrame(String imgpath) throws IOException{
		this(ImageIO.read(new File(imgpath)));
	}
	public MapEditFrame(Image a){
		mapimage = a;
		init("New Map");
	}
	public MapEditFrame(){
		init("New Map From Scratch");
	}
	public static void main(String[] args){

		try {
			JFrame a = new MapEditFrame("C:\\Users\\Thomas\\Pictures\\Blank.jpg");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}