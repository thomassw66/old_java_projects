import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;


public class NavigableGraphAlgorithm {
	static int [][] map = {{0, 3, 1, 2, 9},
					{7, 3, 4, 9, 9},
					{1, 7, 5, 5, 3},
					{2, 3, 4, 2, 5}};
	
	
	public static void main(String [] args){
		
	}
	public static int navigate(int startx, int starty,int goalx, int goaly, int [][] grid){
		int [][] delta = {{1, 0},
						{ 0, 1},
						{-1, 0},
						{ 0,-1}};
		int [][] been = new int [grid.length][grid[0].length];
		for(int i = 0; i< been.length; i ++){
			for(int j = 0; j < been[0].length; j++){
				been[i][j] = Integer.MAX_VALUE;
			}
		}
		PriorityQueue<Cell> p = new PriorityQueue<Cell>();
		
		int x = startx;
		int y = starty;
		
		p.add(new Cell(x,y,0));
		been[x][y] = 0;
		
		while(p.size() > 0){
			Cell c = p.poll();
			x = c.x;
			y = c.y;
			int cost = c.cost;
			for(int i = 0; i < delta.length; i ++){
				int nx = x + delta[i][0];
				int ny = y + delta[i][1];
				
				if(nx < grid.length && nx >= 0 && ny < grid[0].length && ny >= 0){
					int new_cost = cost + grid[nx][ny];
					if(new_cost < been[nx][ny]){
						been[nx][ny] = new_cost;
						Cell pi = new Cell(nx,ny,new_cost);
						p.add(pi);
					}
				}
			}
		}
		return been[goalx][goaly];
	}

}	
class Cell implements Comparable<Cell>{

	int x,y;
	int cost;
	int hueristic;
	public Cell(int x, int y, int cost){
		this.x = x;
		this.y = y;
		this.cost = cost;
		this.hueristic = 0;
	}
	public String toString(){
		return "[("+x+","+y+"), "+cost+", "+hueristic +"]";
	}
	public int compareTo(Cell c) {
		return (cost + hueristic) - (c.cost + c.hueristic);
	}
}
