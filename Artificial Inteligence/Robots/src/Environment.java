import java.awt.Graphics;
import java.util.ArrayList;


public class Environment {

	final int SIZE;
	
	int [][] values;
	
	ArrayList<MovableEnvironmentObject> things;
	
	public Environment(int size){
		SIZE = size;
		values = new int[SIZE][SIZE];
	}
	public void modify(int x,int y,int val){
		if(x >= 0 && y >= 0 && x < SIZE && y < SIZE){
			values[y][x] = val;
		}
	}
	public void add(MovableEnvironmentObject e){
		things.add(e);
	}
	void draw(Graphics g){
		
		for(MovableEnvironmentObject e : things){
			e.draw(g);
		}
	}
}
