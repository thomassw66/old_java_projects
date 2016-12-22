import java.util.Arrays;


public class Test {

	public static void main(String [] arfs){
		int [][] map = {{0, 3, 1, 2, 9},
						{7, 3, 4, 9, 9},
						{1, 7, 5, 5, 3},
						{2, 3, 4, 2, 5}};
		System.out.println(leastCostTo(0,0,map.length - 1, map[0].length - 1,map));
		leastCost(3,4,map);
		for(int i = 0; i < answer.length; i ++)
			System.out.println(Arrays.toString(answer[i]));
	}
	
	static int[][]answer;
	static void leastCost(int srow,int scol,int [][] map){
		answer = new int[map.length][map[0].length];
		for(int i = 0;i < answer.length; i ++){
			for(int j = 0; j < answer[i].length; j++){
				answer[i][j] = Integer.MAX_VALUE;
			}
		}
		leastCost(srow,scol,map,0);
	}
	//algorithm for a rectangular grid
	public static void leastCost(int srow,int scol,int [][] map, int cost){
		//were not out of bounds
		if((srow < map.length && srow >= 0) && (scol < map[srow].length && scol >= 0)){
			//only update the map
			int ncost = map[srow][scol] + cost;
			if(ncost < answer[srow][scol]){
				answer[srow][scol] = ncost;
				
				int N = srow - 1;
				int S = srow + 1;
				int E = scol + 1;
				int W = scol - 1;
				
				leastCost(N,scol,map,ncost);
				leastCost(S,scol,map,ncost);
				leastCost(srow,E,map,ncost);
				leastCost(srow,W,map,ncost);
			}
		}
	}
	public static int leastCostTo(int row,int col,int fromrow,int fromcol,int [][] map){
		boolean [][] memory = new boolean[map.length][map[0].length];
		return leastCostTo(row,col,fromrow,fromcol,map,memory,0);
	}
	static int leastCostTo(int row,int col,int fromrow,int fromcol,int [][] map,boolean [][] memory,int cost){
		if(row == fromrow && col == fromcol){
			return cost + map[row][col];
		}
		if((row < map.length && row >= 0)&&(col < map[row].length && col >= 0)){
			//this is to avoid looping in a circle
			if(memory[row][col] == false){
				
				cost += map[row][col];
				memory[row][col] = true;
				//North
				int N = leastCostTo(row - 1,col,fromrow,fromcol,map,memory,cost);
				//South 
				int S = leastCostTo(row + 1,col,fromrow,fromcol,map,memory,cost);
				//East 
				int E = leastCostTo(row,col + 1,fromrow,fromcol,map,memory,cost);
				//West
				int W = leastCostTo(row,col - 1,fromrow,fromcol,map,memory,cost);
				
				int costfrom = minimum(N,S,E,W);
				
				memory[row][col] = false;
				
				return costfrom;
			}
		}
		return 1000000000;
	}
	public static int minimum(int ... args){
		int min = args[0];
		for(int i = 1; i < args.length; i++){
			if(args[i] < min)
				min = args[i];
		}
		return min;
	}
	
}
