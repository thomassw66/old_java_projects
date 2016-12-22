import javax.swing.*;
import java.awt.*;

public class GTViewingWindow extends JFrame{

	GTPanel panel = new GTPanel();
	public GTViewingWindow(){
		setSize(1000, 500);
		setLocation(200, 100);
		add(panel);
		setVisible(true);
	}
	public void setScene(GTScene s){
		panel.gte.scene = s;
	}
	class GTPanel extends JPanel{
		GTEnvironment gte = new GTEnvironment(1000,500);
		
		public void paint(Graphics g){
			gte.paint(g);
		}
	}
}
