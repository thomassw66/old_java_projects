import java.awt.Color;
import java.awt.Graphics;


public abstract class GTObject {

	Color col;
	public void draw(Graphics g){
		Color original = g.getColor();
		g.setColor(col);
		gtdraw(g);
		g.setColor(original);
	}
	protected abstract void gtdraw(Graphics g);
}
