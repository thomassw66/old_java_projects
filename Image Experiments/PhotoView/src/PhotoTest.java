import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class PhotoTest {

	public static void main(String [] args) throws IOException{
		//JFrame photoWin = new JFrame();
		String path = JOptionPane.showInputDialog("What is the file path?");
		System.out.println("ready");
		MainPanel m =new MainPanel(ImageIO.read(new File(path)));//"C:\\Users\\Public\\Pictures\\Sample Pictures\\cake.png"//C:\Users\Public\Pictures\Sample Pictures\cake.png
		System.out.println("done");
		//photoWin.add(m);
		//photoWin.setSize(m.getPreferredSize().width+20,m.getPreferredSize().height+20);
		//photoWin.setVisible(true);
	}
}
